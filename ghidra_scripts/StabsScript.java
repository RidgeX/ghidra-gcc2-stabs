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

import ghidra.app.cmd.data.*;
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
    public static class StabSymbolTypes {
        private StabSymbolTypes() {
        }

        public static final int N_UNDF = 0x0;
        public static final int N_ABS = 0x2;
        public static final int N_TEXT = 0x4;
        public static final int N_DATA = 0x6;
        public static final int N_BSS = 0x8;
        public static final int N_INDR = 0x0a;
        public static final int N_FN_SEQ = 0x0c;
        public static final int N_COMM = 0x12;
        public static final int N_SETA = 0x14;
        public static final int N_SETT = 0x16;
        public static final int N_SETD = 0x18;
        public static final int N_SETB = 0x1a;
        public static final int N_SETV = 0x1c;
        public static final int N_WARNING = 0x1e;
        public static final int N_FN = 0x1f;
        public static final int N_GSYM = 0x20;
        public static final int N_FNAME = 0x22;
        public static final int N_FUN = 0x24;
        public static final int N_STSYM = 0x26;
        public static final int N_LCSYM = 0x28;
        public static final int N_MAIN = 0x2a;
        public static final int N_ROSYM = 0x2c;
        public static final int N_PC = 0x30;
        public static final int N_NSYMS = 0x32;
        public static final int N_NOMAP = 0x34;
        public static final int N_MAC_DEFINE = 0x36;
        public static final int N_OBJ = 0x38;
        public static final int N_MAC_UNDEF = 0x3a;
        public static final int N_OPT = 0x3c;
        public static final int N_RSYM = 0x40;
        public static final int N_M2C = 0x42;
        public static final int N_SLINE = 0x44;
        public static final int N_DSLINE = 0x46;
        public static final int N_BSLINE = 0x48;
        public static final int N_BROWS = 0x48;
        public static final int N_DEFD = 0x4a;
        public static final int N_FLINE = 0x4c;
        public static final int N_EHDECL = 0x50;
        public static final int N_MOD2 = 0x50;
        public static final int N_CATCH = 0x54;
        public static final int N_SSYM = 0x60;
        public static final int N_ENDM = 0x62;
        public static final int N_SO = 0x64;
        public static final int N_LSYM = 0x80;
        public static final int N_BINCL = 0x82;
        public static final int N_SOL = 0x84;
        public static final int N_PSYM = 0xa0;
        public static final int N_EINCL = 0xa2;
        public static final int N_ENTRY = 0xa4;
        public static final int N_LBRAC = 0xc0;
        public static final int N_EXCL = 0xc2;
        public static final int N_SCOPE = 0xc4;
        public static final int N_RBRAC = 0xe0;
        public static final int N_BCOMM = 0xe2;
        public static final int N_ECOMM = 0xe4;
        public static final int N_ECOML = 0xe8;
        public static final int N_WITH = 0xea;
        public static final int N_NBTEXT = 0xf0;
        public static final int N_NBDATA = 0xf2;
        public static final int N_NBBSS = 0xf4;
        public static final int N_NBSTS = 0xf6;
        public static final int N_NBLCS = 0xf8;        
    }

    public static class Type {
        public Pair<String, Integer> id;
        public Type type;

        @Override
        public String toString() {
            return String.format("Type[id = %s, type = %s]", id, type);
        }
    }

    public static class RangeType extends Type {
        public String minValue;
        public String maxValue;

        @Override
        public String toString() {
            return String.format("RangeType[id = %s, baseType = %s, minValue = %s, maxValue = %s]", id, type, minValue, maxValue);
        }
    }

    public static class ArrayType extends Type {
        public RangeType indexType;
        
        @Override
        public String toString() {
            return String.format("ArrayType[id = %s, indexType = %s, elementsType = %s]", id, indexType, type);
        }
    }

    public static class EnumType extends Type {
        public List<Pair<String, Integer>> members;

        @Override
        public String toString() {
            List<String> membersString = new ArrayList<>();

            for (Pair<String,Integer> member : members) {
                membersString.add(member.toString());
            }

            return String.format("EnumType[id = %s, members = [%s]]", id, String.join(", ", membersString));
        }
    }

    public static class FunctionType extends Type {
        @Override
        public String toString() {
            return String.format("FunctionType[id = %s, returnType = %s]", id, type);
        }
    }

    public static class NestedFunctionType extends Type {
        public String name;
        public String parentName;

        @Override
        public String toString() {
            return String.format("NestedFunctionType[id = %s, returnType = %s, name = %s, parentName = %s]", id, type, name, parentName);
        }
    }

    public static class PointerType extends Type {
        @Override
        public String toString() {
            return String.format("PointerType[id = %s, targetType = %s]", id, type);
        }
    }

    public static class StructUnionMemberType extends Type {
        public String name;
        public Integer offset;
        public Integer size;

        @Override
        public String toString() {
            return String.format("StructUnionMemberType[type = %s, name = %s, offset = %d, size = %d]", type, name, offset, size);
        }
    }

    public static class StructUnionType extends Type {
        public static enum StructUnionSpecificType {
            Undefined,
            Struct,
            Union
        }

        public StructUnionSpecificType specificType;
        public Integer size;
        public List<StructUnionMemberType> members;

        @Override
        public String toString() {
            List<String> membersString = new ArrayList<>();

            for (StructUnionMemberType member : members) {
                membersString.add(member.toString());
            }

            return String.format("StructUnionType[id = %s, specificType = %s, size = %d, members = [%s]]", id, specificType, size, String.join(", ", membersString));
        }
    }

    public static class XrefType extends Type {
        public static enum TargetType {
            Undefined,
            Enum,
            Struct,
            Union
        }

        public TargetType targetType;
        public String targetName;

        @Override
        public String toString() {
            return String.format("XrefType[id = %s, targetType = %s, targetName = %s]", id, targetType, targetName);
        }
    }

    public static class Symbol {
        public static enum SymbolType {
            Undefined,
            StackVariable,
            ReferenceParameter,
            GlobalFunction,
            LocalFunction,
            NestedFunction,
            GlobalVariable,
            RegisterParameter,
            FunctionPrototype,
            StackParameter,
            RegisterVariable,
            StaticFileVariable,
            TaggedType,
            Typedef,
            HeapVariable
        }

        public Integer typeValue;
        public Address address;
        public Integer value;
        public String name;
        public SymbolType symbolType;
        public Type type;

        @Override
        public String toString() {
            return String.format("Symbol[typeValue = 0x%x, address = 0x%s, value = 0x%x, name = %s, symbolType = %s, type = %s]", typeValue, address, value, name, symbolType, type);
        }
    }

    private String architecture;
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
    private List<String> fileList;
    private Map<String, Map<Integer, Type>> typeDict;
    private List<Symbol> symbolList;
    private Map<Type, DataType> dataTypeDict;
    private Map<String, Address> globalSymbolAddresses;

    public StabsScript() {
        includeFilename = new Stack<>();
        commands = new ArrayList<>();
        fileList = new ArrayList<>();
        typeDict = new HashMap<>();
        symbolList = new ArrayList<>();
        dataTypeDict = new HashMap<>();
        globalSymbolAddresses = new HashMap<>();
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
        fileList.clear();
        symbolList.clear();
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
		String categoryPath;
        if (includeFilename.isEmpty()) {
            file = sourceFilename != null ? sourceFilename : "";
        } else {
            file = includeFilename.peek();
        }
        String path;
        if (file.startsWith("/")) {
            path = file;
        } else {
            path = FilenameUtils.normalize(sourceDirectory + file, true);
        }
		
		categoryPath = "";
		
		if(unitFilename != null && unitFilename.length() > 0) {
			categoryPath += String.format("/%s", unitFilename);
		}
		
        path = path.substring(path.lastIndexOf("/") + 1);
		
		categoryPath += String.format("/%s", path);
        return new CategoryPath(categoryPath);
    }

    private Register getRegister(int registerIndex) {
        String register = "";
        if (architecture.equals("x86")) {
            switch (registerIndex) {
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
        }
        
        if (architecture.equals("sparc")) {
            switch (registerIndex / 8) {
                case 0: register = "g"; break;
                case 1: register = "o"; break;
                case 2: register = "l"; break;
                case 3: register = "i"; break;
                default: throw new RuntimeException("Unknown register");
            }

            register = String.format("%%%s%d", register, registerIndex % 8);
        }

        return currentProgram.getRegister(register);
    }

    private DataType getDataType(Pair<String, Integer> id) {
        Type type = getType(id);

        if (type != null) {
            while (type.type != null && type.getClass().equals(Type.class) && !type.id.equals(type.type.id)) {
                type = getType(type.type.id);
            }
    
            return getDataType(type);
        }

        return null;
    }

    private DataType getDataType(Type type) {
        DataType dataType = dataTypeDict.get(type);
        
        if (dataType == null) {
            if (type instanceof RangeType) {
                dataType = createDataType((RangeType) type);
            } else if (type instanceof ArrayType) {
                dataType = createDataType((ArrayType) type);
            } else if (type instanceof EnumType) {
                dataType = createDataType((EnumType) type);
            } else if (type instanceof FunctionType) {
                dataType = createDataType((FunctionType) type);
            } else if (type instanceof NestedFunctionType) {
                dataType = createDataType((NestedFunctionType) type);
            } else if (type instanceof PointerType) {
                dataType = createDataType((PointerType) type);
            } else if (type instanceof StructUnionType) {
                dataType = createDataType((StructUnionType) type);
            } else if (type instanceof XrefType) {
                dataType = createDataType((XrefType) type);
            } else if (type.type == null && type.getClass().equals(Type.class)) {
                dataType = getDataType(type.id);
            } else if (type.type != null && type.getClass().equals(Type.class) && !type.id.equals(type.type.id)) {
                dataType = getDataType(type.type.id);
            } else if (type.type != null && type.getClass().equals(Type.class) && type.id.equals(type.type.id)) {
                dataType = VoidDataType.dataType;
            }
            
            if (dataType == null) {
                throw new RuntimeException("Unknown data type");
            }
            
            if (!dataTypeDict.containsKey(type)) {
                dataTypeDict.put(type, dataType);
            }
        }

        return dataType;
    }

    private DataType createDataType(RangeType type) {
        DataTypeManager dataTypeManager = getCurrentProgram().getDataTypeManager();

        if (type.id != null && type.id.equals(type.type.id)) {
            if (type.minValue.equals("0") && type.maxValue.equals("127")) {
                return CharDataType.dataType;
            }

            if (type.minValue.equals("-128") && type.maxValue.equals("127")) {
                return SignedCharDataType.dataType;
            }
            
            if (type.minValue.equals("0") && type.maxValue.equals("255")) {
                return UnsignedCharDataType.dataType;
            }

            if (type.minValue.equals("-32768") && type.maxValue.equals("32767")) {
                return ShortDataType.dataType;
            }

            if (type.minValue.equals("0") && type.maxValue.equals("65535")) {
                return UnsignedShortDataType.dataType;
            }

            if (type.minValue.equals("0020000000000") && type.maxValue.equals("0017777777777")) {
                return IntegerDataType.dataType;
            }

            if (type.minValue.equals("4") && type.maxValue.equals("0")) {
                return FloatComplexDataType.dataType;
            }

            if (type.minValue.equals("8") && type.maxValue.equals("0")) {
                return DoubleComplexDataType.dataType;
            }

            if (type.minValue.equals("12") && type.maxValue.equals("0")) {
                return AbstractComplexDataType.getComplexDataType(12, dataTypeManager);
            }

            if (type.minValue.equals("16") && type.maxValue.equals("0")) {
                return LongDoubleComplexDataType.dataType;
            }

            throw new RuntimeException("Unknown range type");
        }

        DataType baseDataType = getDataType(type.type);

        if (baseDataType instanceof IntegerDataType) {
            if (type.minValue.equals("0020000000000") && type.maxValue.equals("0017777777777")) {
                return IntegerDataType.dataType;
            }

            if (type.minValue.equals("0000000000000") && type.maxValue.equals("0037777777777")) {
                return UnsignedIntegerDataType.dataType;
            }

            if (type.minValue.equals("01000000000000000000000") && type.maxValue.equals("0777777777777777777777")) {
                return LongLongDataType.dataType;
            }

            if (type.minValue.equals("0000000000000") && type.maxValue.equals("01777777777777777777777")) {
                return UnsignedLongLongDataType.dataType;
            }

            if (type.minValue.equals("4") && type.maxValue.equals("0")) {
                return FloatDataType.dataType;
            }

            if (type.minValue.equals("8") && type.maxValue.equals("0")) {
                return DoubleDataType.dataType;
            }

            if (type.minValue.equals("12") && type.maxValue.equals("0")) {
                return AbstractFloatDataType.getFloatDataType(12, dataTypeManager);
            }

            if (type.minValue.equals("16") && type.maxValue.equals("0")) {
                return LongDoubleDataType.dataType;
            }
        }

        int minValue = Integer.parseInt(type.minValue);
        int maxValue = Integer.parseInt(type.maxValue);

        if (minValue != 0) {
            throw new RuntimeException("Unknown primitive type");
        }
        if (maxValue == -1) {
            return PointerDataType.getPointer(IntegerDataType.dataType, IntegerDataType.dataType.getLength());  // Implicitly sized array -> decays to pointer
        }

        int numElements = maxValue - minValue + 1;
        
        return new ArrayDataType(IntegerDataType.dataType, numElements, IntegerDataType.dataType.getLength());
    }

    private DataType createDataType(ArrayType type) {
        DataType indexDataType = createDataType(type.indexType);
        DataType elementsDataType = getDataType(type.type);

        if (indexDataType instanceof PointerDataType) {
            return PointerDataType.getPointer(elementsDataType, IntegerDataType.dataType.getLength());
        }

        return new ArrayDataType(elementsDataType, ((ArrayDataType)indexDataType).getNumElements(), elementsDataType.getLength());
    }

    private DataType createDataType(EnumType type) {
        EnumDataType enumDataType = new EnumDataType(getCurrentPath(), makeEnumName(), IntegerDataType.dataType.getLength());

        for (Pair<String, Integer> member : type.members) {
            enumDataType.add(member.getLeft(), member.getRight());
        }

        return enumDataType;
    }

    private DataType createDataType(FunctionType type) {
        FunctionDefinitionDataType functionDefinitionDataType = new FunctionDefinitionDataType(getCurrentPath(), makeFuncName());
        
        functionDefinitionDataType.setReturnType(getDataType(type.type));

        return functionDefinitionDataType;
    }

    private DataType createDataType(NestedFunctionType type) {
        DataType returnType = getDataType(type.type);

        FunctionDefinitionDataType functionDefinitionDataType = new FunctionDefinitionDataType(getCurrentPath(), makeFuncName());
        
        functionDefinitionDataType.setReturnType(returnType);

        return functionDefinitionDataType;
    }

    private DataType createDataType(PointerType type) {
        return PointerDataType.getPointer(getDataType(type.type), IntegerDataType.dataType.getLength());
    }

    private DataType createDataType(StructUnionType type) {
        if (type.specificType == StructUnionType.StructUnionSpecificType.Struct) {
            return createStruct(type);
        }

        if (type.specificType == StructUnionType.StructUnionSpecificType.Union) {
            return createUnion(type);
        }

        throw new RuntimeException("Undefined composite type");
    }
    
    private StructureDataType createStruct(StructUnionType structType) {
        StructureDataType structureDataType = new StructureDataType(getCurrentPath(), makeStructName(), 0);

        // Avoid circular reference errors
        dataTypeDict.put(structType, structureDataType);

        for (StructUnionMemberType memberType : structType.members) {
            structureDataType.insertAtOffset(memberType.offset, getDataType(memberType.type), memberType.size, memberType.name, null);

            if (architecture.equals("x86")) {
                DataTypeComponent dataTypeComponent = structureDataType.getComponent(structureDataType.getNumComponents() - 1);
                
                if (dataTypeComponent.getOffset() != memberType.offset) {
                    throw new RuntimeException("Struct member offset mismatch");
                }
    
                if (dataTypeComponent.getLength() != memberType.size) {
                    throw new RuntimeException("Struct member size mismatch");
                }
            }
        }

        if (architecture.equals("x86")) {
            if (structureDataType.getLength() < structType.size) {
                structureDataType.setExplicitMinimumAlignment(IntegerDataType.dataType.getLength());
                structureDataType.setExplicitPackingValue(IntegerDataType.dataType.getLength());
            }
    
            if (structureDataType.getLength() < structType.size) {
                structureDataType.setExplicitMinimumAlignment(LongLongDataType.dataType.getLength());
                structureDataType.setExplicitPackingValue(LongLongDataType.dataType.getLength());
            }
    
            if (structureDataType.getLength() != structType.size) {
                throw new RuntimeException("Struct size mismatch");
            }
        } else {
            if (structureDataType.getLength() < structType.size) {
                structureDataType.growStructure(structType.size - structureDataType.getLength());
            }
        }

        return structureDataType;
    }
    
    private UnionDataType createUnion(StructUnionType unionType) {
        UnionDataType unionDataType = new UnionDataType(getCurrentPath(), makeUnionName());

        // Avoid circular reference errors
        dataTypeDict.put(unionType, unionDataType);

        for (StructUnionMemberType memberType : unionType.members) {
            unionDataType.add(getDataType(memberType.type), memberType.name, null);

            if (architecture.equals("x86")) {
                DataTypeComponent dataTypeComponent = unionDataType.getComponent(unionDataType.getNumComponents() - 1);
                
                if (dataTypeComponent.getOffset() != memberType.offset) {
                    throw new RuntimeException("Union member offset mismatch");
                }
    
                if (dataTypeComponent.getLength() != memberType.size) {
                    throw new RuntimeException("Union member size mismatch");
                }
            }
        }

        if (architecture.equals("x86") && unionDataType.getLength() != unionType.size) {
            throw new RuntimeException("Union size mismatch");
        }

        return unionDataType;
    }

    private DataType createDataType(XrefType type) {
        if (type.targetType == XrefType.TargetType.Enum) {
            return new EnumDataType(getCurrentPath(), type.targetName, IntegerDataType.dataType.getLength());
        }

        if (type.targetType == XrefType.TargetType.Struct) {
            return new StructureDataType(getCurrentPath(), type.targetName, 0);
        }

        if (type.targetType == XrefType.TargetType.Union) {
            return new UnionDataType(getCurrentPath(), type.targetName);
        }

        throw new RuntimeException("Undefined Xref Type");
    }

    public void createFunction(Symbol symbol) {
        funcAddress = symbol.address;
        funcOrdinal = 0;

        Command command = new SetFunctionNameCmd(funcAddress, symbol.name, SourceType.IMPORTED);
        command.applyTo(currentProgram);

        command = new SetReturnDataTypeCmd(funcAddress, getDataType(symbol.type), SourceType.IMPORTED);
        command.applyTo(currentProgram);
    }

    private void createStackParameter(Symbol symbol) {
        FunctionManager functionManager = currentProgram.getFunctionManager();
        Function function = functionManager.getFunctionAt(funcAddress);

        Command command = new AddStackParameterCommand(function, symbol.value, symbol.name, getDataType(symbol.type), funcOrdinal++, SourceType.IMPORTED);
        command.applyTo(currentProgram);
    }

    private void createStackVariable(Symbol symbol) {
        Command command = new AddStackVarCmd(funcAddress, symbol.value, symbol.name, getDataType(symbol.type), SourceType.IMPORTED);
        command.applyTo(currentProgram);
    }

    public void createMemoryVariable(Symbol symbol) {
        Address address = symbol.address;

        if (symbol.symbolType == Symbol.SymbolType.GlobalFunction) {
            address = globalSymbolAddresses.get(symbol.name);
        }

        Command command = new AddMemoryVarCmd(address, address, symbol.name, getDataType(symbol.type), SourceType.IMPORTED);
        command.applyTo(currentProgram);
    }

    public void createRegisterParameter(Symbol symbol) {
        FunctionManager functionManager = currentProgram.getFunctionManager();
        Function function = functionManager.getFunctionAt(funcAddress);

        Command command = new AddRegisterParameterCommand(function, getRegister(symbol.value), symbol.name, getDataType(symbol.type), funcOrdinal++, SourceType.IMPORTED);
        command.applyTo(currentProgram);
    }

    public void createRegisterVariable(Symbol symbol) {
        Command command = new AddRegisterVarCmd(symbol.address, getRegister(symbol.value), symbol.name, getDataType(symbol.type), SourceType.IMPORTED);
        command.applyTo(currentProgram);
    }

    public void createGlobalVariable(Symbol symbol) {
        Command command = new CreateDataCmd(globalSymbolAddresses.get(symbol.name), true, getDataType(symbol.type));
        command.applyTo(currentProgram);
    }

    public void createStaticVariable(Symbol symbol) {
        Command command = new CreateDataCmd(symbol.address, true, getDataType(symbol.type));
        command.applyTo(currentProgram);
    }

    public void createTaggedType(Symbol symbol) {
        DataType dataType = getDataType(symbol.type);

        if (!(dataType instanceof EnumDataType
            || dataType instanceof StructureDataType
            || dataType instanceof UnionDataType
        )) {
            throw new RuntimeException("Expected enum, struct or union type");
        }

        if (!symbol.name.isBlank()) {
            try {
                dataType.setName(symbol.name);
            } catch (DuplicateNameException|InvalidNameException e) {
                throw new RuntimeException(e);
            }
        }

        currentProgram.getDataTypeManager().addDataType(dataType, DataTypeConflictHandler.DEFAULT_HANDLER);
    }

    public void createTypedefType(Symbol symbol) {
        DataType dataType = new TypedefDataType(getCurrentPath(), symbol.name, getDataType(symbol.type));
        currentProgram.getDataTypeManager().addDataType(dataType, DataTypeConflictHandler.DEFAULT_HANDLER);
    }

    public Pair<String, Integer> getId(Pair<Integer, Integer> internalId) {
        return Pair.of(fileList.get(internalId.getLeft()), internalId.getRight());
    }

    public Pair<Integer, Integer> getInternalId(Pair<String, Integer> id) {
        if (id != null) {
            return Pair.of(fileList.indexOf(id.getLeft()), id.getRight());
        }

        return null;
    }

    public Type getType(Pair<String, Integer> id) {
        if (typeDict.containsKey(id.getLeft())) {
            return typeDict.get(id.getLeft()).get(id.getRight());
        }

        return null;
    }

    public void putType(Type type) {
        if (!typeDict.containsKey(type.id.getLeft())) {
            throw new RuntimeException(String.format("Invalid file name: %s", type.id.getLeft()));
        }
        
        typeDict.get(type.id.getLeft()).put(type.id.getRight(), type);
    }

    public void putSymbol(Symbol symbol) {
        symbolList.add(symbol);
    }

    private void importStabs() {
        DataTypeManager dataTypeManager = currentProgram.getDataTypeManager();
        int id = dataTypeManager.startTransaction(unitFilename);

        for (Symbol symbol : symbolList) {
            switch (symbol.symbolType) {
                case StackVariable:
                    createStackVariable(symbol);
                    break;
                case GlobalFunction:
                case LocalFunction:
                case NestedFunction:
                    createFunction(symbol);
                    break;
                case RegisterParameter:
                    createRegisterParameter(symbol);
                    break;
                case FunctionPrototype:
                    break;
                case ReferenceParameter:
                case StackParameter:
                    createStackParameter(symbol);
                    break;
                case RegisterVariable:
                    createRegisterVariable(symbol);
                    break;
                case TaggedType:
                    createTaggedType(symbol);
                    break;
                case Typedef:
                    createTypedefType(symbol);
                    break;
                case GlobalVariable:
                    createGlobalVariable(symbol);
                case StaticFileVariable:
                    createStaticVariable(symbol);
                case HeapVariable:
                    createMemoryVariable(symbol);
                    break;
                default:
                    break;
            }
        }

        dataTypeManager.endTransaction(id, true);
        dataTypeManager.flushEvents();
    }

    private void parseStab(int symbolType, Address stabAddress, int stabValue, String str) {
        CharStream input = CharStreams.fromString(str);
        StabsLexer lexer = new StabsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        StabsParser parser = new StabsParser(tokens);
        parser.setErrorHandler(new BailErrorStrategy());
        ParseTree tree = parser.symbol();
        StabsVisitor visitor = new StabsVisitor(this, symbolType, stabAddress, stabValue);
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
        ElfHeader elf = new ElfHeader(provider, x -> println(x));
        BinaryReader reader = elf.getReader();
        elf.parse();

        switch (elf.e_machine()) {
            case 2:
                architecture = "sparc";
                break;
            case 3:
                architecture = "x86";
            default:
                throw new RuntimeException("Unsupported architecture");
        }

        ElfSectionHeader stabSection = elf.getSection(".stab");
        ElfSectionHeader stabstrSection = elf.getSection(".stabstr");
        ElfSectionHeader relStabSection = elf.getSection(".rel.stab");
        Map<Integer, Address> addressMap = new TreeMap<>();
        ElfSectionHeader symtabSection = elf.getSection(".symtab");
        ElfSymbolTable symtab = elf.getSymbolTable(symtabSection);
        ElfStringTable stringTable = symtab.getStringTable();

        ElfSymbol[] globalSymbols = symtab.getGlobalSymbols();

        for (ElfSymbol elfSymbol : globalSymbols) {
            elfSymbol.initSymbolName(reader, stringTable);
            globalSymbolAddresses.put(elfSymbol.getNameAsString(), toAddr(elfSymbol.getValue()));
        }

        boolean hasRelocs = (relStabSection != null);

        if (hasRelocs) {
            ElfSectionHeader[] sections = elf.getSections();
            ElfRelocationTable relStab = elf.getRelocationTable(relStabSection);
            ElfRelocation[] relocs = relStab.getRelocations();
            ElfSymbol[] symbols = symtab.getSymbols();

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
                str = reader.readAsciiString(stabStrOffset + unitOffset + strx);
            }
            stabAddress = (hasRelocs ? addressMap.get(i) : toAddr(value));
            stabValue = value;

            switch (type) {
                case StabSymbolTypes.N_UNDF:
                    unitFilename = str;
                    break;

                case StabSymbolTypes.N_OPT:
                    break;

                case StabSymbolTypes.N_SLINE:
                    break;

                case StabSymbolTypes.N_SO:
                    if (str.isEmpty()) {
                        importStabs();
                        clearStabs();
                        sourceDirectory = null;
                        sourceFilename = null;
                    } else if (sourceDirectory == null) {
                        sourceDirectory = str;
                    } else if (sourceFilename == null) {
                        sourceFilename = str;
                        fileList.add(str);
                        typeDict.putIfAbsent(str, new HashMap<>());
                    } else {
                        throw new RuntimeException("Source file already defined");
                    }

                    break;

                case StabSymbolTypes.N_BINCL:
                    includeFilename.add(str);
                    fileList.add(str);
                    typeDict.putIfAbsent(str, new HashMap<>());
                    break;

                case StabSymbolTypes.N_SOL:
                    sourceFilename = str;
                    typeDict.putIfAbsent(str, new HashMap<>());
                    break;

                case StabSymbolTypes.N_EINCL:
                    includeFilename.pop();
                    break;

                case StabSymbolTypes.N_LBRAC:
                    break;

                case StabSymbolTypes.N_EXCL:
                    fileList.add(str);
                    break;

                case StabSymbolTypes.N_RBRAC:
                    break;

                case StabSymbolTypes.N_GSYM:
                case StabSymbolTypes.N_FUN:
                case StabSymbolTypes.N_STSYM:
                case StabSymbolTypes.N_LCSYM:
                case StabSymbolTypes.N_RSYM:
                case StabSymbolTypes.N_LSYM:
                case StabSymbolTypes.N_PSYM:
                    if (str.endsWith("\\")) {
                        sym.append(str.substring(0, str.length() - 1));
                    } else if (!str.isEmpty()) {
                        sym.append(str);
                        parseStab(type, stabAddress, stabValue, sym.toString());
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
