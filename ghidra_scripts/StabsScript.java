//GCC 2.x Stabs debug information parser
//@author Ridge Shrubsall
//@category Stabs
//@keybinding 
//@menupath 
//@toolbar 

import java.io.File;
import java.nio.file.AccessMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.tuple.Pair;

import generic.continues.RethrowContinuesFactory;

import ghidra.app.cmd.function.*;
import ghidra.app.script.GhidraScript;
import ghidra.app.util.bin.*;
import ghidra.app.util.bin.format.elf.*;
import ghidra.app.util.bin.format.elf.relocation.X86_32_ElfRelocationConstants;
import ghidra.framework.cmd.Command;
import ghidra.program.model.address.*;
import ghidra.program.model.data.*;
import ghidra.program.model.lang.*;
import ghidra.program.model.listing.*;
import ghidra.program.model.mem.*;
import ghidra.program.model.symbol.*;
import ghidra.util.InvalidNameException;
import ghidra.util.exception.DuplicateNameException;

import stabs.StabsLexer;
import stabs.StabsParser;

public class StabsScript extends GhidraScript {
    private Address stabAddress;
    private int stabValue;

    private int enumCounter;
    private int funcCounter;
    private int structCounter;
    private int unionCounter;
    private Stack<String> includeFilename;
    private String sourceDirectory;
    private String sourceFilename;
    private String unitFilename;
    private Address funcAddress;
    private int funcOrdinal;
    private List<Command> commands;
    private Map<Pair<Integer, Integer>, DataType> typeDict;
    private List<Pair<Integer, Integer>> typeOrder;

    public StabsScript() {
        includeFilename = new Stack<>();
        commands = new ArrayList<>();
        typeDict = new HashMap<>();
        typeOrder = new ArrayList<>();
    }

    private void clearStabs() {
        enumCounter = 0;
        funcCounter = 0;
        structCounter = 0;
        unionCounter = 0;
        includeFilename.clear();
        sourceDirectory = null;
        sourceFilename = null;
        unitFilename = null;
        funcAddress = null;
        funcOrdinal = 0;
        commands.clear();
        typeDict.clear();
        typeOrder.clear();
    }

    public String makeEnumName() {
        return String.format("_enum_%d", ++enumCounter); 
    }

    public String makeFuncName() {
        return String.format("_func_%d", ++funcCounter);
    }

    public String makeStructName() {
        return String.format("_struct_%d", ++structCounter);
    }

    public String makeUnionName() {
        return String.format("_union_%d", ++unionCounter);
    }

    public CategoryPath getCurrentPath() {
        String file;
        if (includeFilename.isEmpty()) {
            file = sourceFilename;
        } else {
            file = includeFilename.peek();
        }
        String path;
        if (file.startsWith("/")) {
            path = file;
        } else {
            path = FilenameUtils.normalize(sourceDirectory + file, true);
        }
        path = path.substring(path.lastIndexOf("/") + 1);
        return new CategoryPath(String.format("/%s/%s", unitFilename, path));
    }

    private Address getAddress() {
        return stabAddress;
    }

    private Register getRegister() {
        String register;
        switch (stabValue) {
            case 0: register = "eax"; break;
            case 1: register = "ecx"; break;
            case 2: register = "edx"; break;
            case 3: register = "ebx"; break;
            case 4: register = "esp"; break;
            case 5: register = "ebp"; break;
            case 6: register = "esi"; break;
            case 7: register = "edi"; break;
            default: throw new RuntimeException("Unknown register");
        }
        return currentProgram.getRegister(register);
    }

    private int getStackOffset() {
        return stabValue;
    }

    public void recordFunction(DataType dataType, String name) {
        funcAddress = getAddress();
        funcOrdinal = 0;
        commands.add(new SetFunctionNameCmd(funcAddress, name, SourceType.USER_DEFINED));
        commands.add(new SetReturnDataTypeCmd(funcAddress, dataType, SourceType.USER_DEFINED));
    }

    public void recordReferenceParameter(DataType dataType, String name) {
        // TODO
    }

    public void recordRegisterParameter(DataType dataType, String name) {
        FunctionManager functionManager = currentProgram.getFunctionManager();
        Function function = functionManager.getFunctionAt(funcAddress);
        commands.add(new AddRegisterParameterCommand(function, getRegister(), name, dataType, funcOrdinal++, SourceType.USER_DEFINED));
    }

    public void recordStackParameter(DataType dataType, String name) {
        FunctionManager functionManager = currentProgram.getFunctionManager();
        Function function = functionManager.getFunctionAt(funcAddress);
        commands.add(new AddStackParameterCommand(function, getStackOffset(), name, dataType, funcOrdinal++, SourceType.USER_DEFINED));
    }

    public void recordHeapVariable(DataType dataType, String name) {
        // TODO
    }

    public void recordRegisterVariable(DataType dataType, String name) {
        // TODO
    }

    public void recordStackVariable(DataType dataType, String name) {
        // TODO
    }

    public void recordTaggedType(Pair<Integer, Integer> number, String name) {
        DataType dataType = typeDict.get(number);
        if (!(dataType instanceof EnumDataType ||
                dataType instanceof StructureDataType ||
                dataType instanceof UnionDataType)) {
            throw new RuntimeException("Expected enum, struct or union type");
        }

        if (!name.isBlank()) {
            try {
                if (dataType instanceof EnumDataType) {
                    dataType.setName("enum " + name);
                } else if (dataType instanceof StructureDataType) {
                    dataType.setName("struct " + name);
                } else if (dataType instanceof UnionDataType) {
                    dataType.setName("union " + name);
                }
            } catch (DuplicateNameException|InvalidNameException e) {
                throw new RuntimeException(e);
            }
        }

        if (!typeOrder.contains(number)) {
            typeOrder.add(number);
        }
    }

    public void recordTypedefedType(Pair<Integer, Integer> number, String name) {
        DataType dataType = typeDict.get(number);
        if (dataType instanceof VoidDataType) return;

        TypedefDataType typedefType = new TypedefDataType(getCurrentPath(), name, dataType);
        typeDict.put(number, typedefType);

        if (!typeOrder.contains(number)) {
            typeOrder.add(number);
        }
    }

    public DataType getType(Pair<Integer, Integer> number) {
        return typeDict.get(number);
    }

    public void putType(Pair<Integer, Integer> number, DataType dataType) {
        if (typeDict.containsKey(number)) {
            DataType xrefType = typeDict.get(number);
            if (!xrefType.isNotYetDefined()) {
                throw new RuntimeException("Expected cross reference type");
            }

            try {
                xrefType.setCategoryPath(dataType.getCategoryPath());
            } catch (DuplicateNameException e) {
                throw new RuntimeException(e);
            }
            xrefType.replaceWith(dataType);
            return;
        }

        typeDict.put(number, dataType);
    }

    private void importStabs() {
        DataTypeManager dataTypeManager = currentProgram.getDataTypeManager();
        int id = dataTypeManager.startTransaction(unitFilename);

        for (Pair<Integer, Integer> pair : typeOrder) {
            DataType dataType = typeDict.get(pair);
            dataTypeManager.addDataType(dataType, DataTypeConflictHandler.DEFAULT_HANDLER);
        }
        for (Command cmd : commands) {
            cmd.applyTo(currentProgram);
        }

        dataTypeManager.endTransaction(id, true);
        dataTypeManager.flushEvents();
    }

    private void parseStab(String str) {
        CharStream input = CharStreams.fromString(str);
        StabsLexer lexer = new StabsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        StabsParser parser = new StabsParser(tokens);
        parser.setErrorHandler(new BailErrorStrategy());
        ParseTree tree = parser.symbol();
        StabsVisitor visitor = new StabsVisitor(this);
        visitor.visit(tree);
    }

    @Override
    public AnalysisMode getScriptAnalysisMode() {
        return AnalysisMode.SUSPENDED;
    }

    @Override
    public void run() throws Exception {
        File elfFile = new File(currentProgram.getExecutablePath());
        FileByteProvider provider = new FileByteProvider(elfFile, null, AccessMode.READ);
        ElfHeader elf = ElfHeader.createElfHeader(RethrowContinuesFactory.INSTANCE, provider);
        BinaryReader reader = elf.getReader();
        elf.parse();

        ElfSectionHeader stabSection = elf.getSection(".stab");
        ElfSectionHeader stabstrSection = elf.getSection(".stabstr");
        ElfSectionHeader relStabSection = elf.getSection(".rel.stab");
        ElfSectionHeader symtabSection = elf.getSection(".symtab");
        ElfSectionHeader[] sections = elf.getSections();
        ElfRelocationTable relStab = elf.getRelocationTable(relStabSection);
        ElfRelocation[] relocs = relStab.getRelocations();
        ElfSymbolTable symtab = elf.getSymbolTable(symtabSection);
        ElfSymbol[] symbols = symtab.getSymbols();

        Map<Integer, Address> addressMap = new TreeMap<>();
        for (ElfRelocation reloc : relocs) {
            int type = reloc.getType();
            if (type != X86_32_ElfRelocationConstants.R_386_32) {
                throw new RuntimeException("type != R_386_32");
            }
            ElfSymbol symbol = symbols[reloc.getSymbolIndex()];
            ElfSectionHeader section = sections[symbol.getSectionHeaderIndex()];
            String sectionName = section.getNameAsString();
            MemoryBlock memoryBlock = currentProgram.getMemory().getBlock(sectionName);
            int index = (int)((reloc.getOffset() - 8) / 12);
            Address address = memoryBlock.getStart().add(symbol.getValue()).add(reloc.getAddend());
            addressMap.put(index, address);
        }

        long length = stabSection.getSize();
        long entrySize = stabSection.getEntrySize();
        int stabCount = (int)(length / entrySize);
        reader.setPointerIndex(stabSection.getOffset());
        long stabStrOffset = stabstrSection.getOffset();
        long unitOffset = 0;
        long unitSize = 0;
        StringBuilder sym = new StringBuilder();

        for (int i = 0; i < stabCount; i++) {
            long strx = reader.readNextUnsignedInt();
            int type = reader.readNextUnsignedByte();
            int other = reader.readNextUnsignedByte();
            int desc = reader.readNextUnsignedShort();
            int value = reader.readNextInt();
            if (type == 0) {
                unitOffset += unitSize;
                unitSize = value;
            }
            String str = "";
            if (strx != 0) {
                str = reader.readTerminatedString(stabStrOffset + unitOffset + strx, '\0');
            }
            stabAddress = addressMap.get(i);
            stabValue = value;

            switch (type) {
                case 0x0:   // UNDF
                    clearStabs();
                    unitFilename = str;
                    break;

                case 0x3c:  // OPT
                    break;

                case 0x44:  // SLINE
                    break;

                case 0x64:  // SO
                    if (str.isEmpty()) {
                        importStabs();
                        sourceDirectory = null;
                        sourceFilename = null;
                    } else if (sourceDirectory == null) {
                        sourceDirectory = str;
                    } else if (sourceFilename == null) {
                        sourceFilename = str;
                    } else {
                        throw new RuntimeException("Source file already defined");
                    }
                    break;

                case 0x82:  // BINCL
                    includeFilename.add(str);
                    break;

                case 0x84:  // SOL
                    sourceFilename = str;
                    break;

                case 0xa2:  // EINCL
                    includeFilename.pop();
                    break;

                case 0xc0:  // LBRAC
                    break;

                case 0xe0:  // RBRAC
                    break;

                case 0x20:  // GSYM
                case 0x24:  // FUN
                case 0x26:  // STSYM
                case 0x28:  // LCSYM
                case 0x40:  // RSYM
                case 0x80:  // LSYM
                case 0xa0:  // PSYM
                    if (str.endsWith("\\")) {
                        sym.append(str.substring(0, str.length() - 1));
                    } else if (!str.isEmpty()) {
                        sym.append(str);
                        parseStab(sym.toString());
                        sym.setLength(0);
                    }
                    break;

                default:
                    if (strx != 0) {
                        println(String.format(".stabs \"%s\",%d,%d,%d,%d", str, type, other, desc, value));
                    } else {
                        println(String.format(".stabn %d,%d,%d,%d", type, other, desc, value));
                    }
                    break;
            }
        }

        provider.close();
    }
}
