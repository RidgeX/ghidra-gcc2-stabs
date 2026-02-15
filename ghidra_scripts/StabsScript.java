//GCC 2.x Stabs debug information parser for C/C++
//@author Ridge Shrubsall/Tiago Costa
//@category Stabs
//@keybinding 
//@menupath 
//@toolbar 
//@runtime Java

import java.io.File;
import java.nio.file.AccessMode;
import java.util.ArrayList;
import java.util.Arrays;
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

import ghidra.app.cmd.data.CreateDataCmd;
import ghidra.app.cmd.function.AddMemoryVarCmd;
import ghidra.app.cmd.function.AddRegisterParameterCommand;
import ghidra.app.cmd.function.AddRegisterVarCmd;
import ghidra.app.cmd.function.AddStackParameterCommand;
import ghidra.app.cmd.function.AddStackVarCmd;
import ghidra.app.cmd.function.SetFunctionNameCmd;
import ghidra.app.cmd.function.SetReturnDataTypeCmd;
import ghidra.app.cmd.label.DemanglerCmd;
import ghidra.app.script.GhidraScript;
import ghidra.app.util.bin.BinaryReader;
import ghidra.app.util.bin.FileByteProvider;
import ghidra.app.util.bin.format.elf.ElfHeader;
import ghidra.app.util.bin.format.elf.ElfRelocation;
import ghidra.app.util.bin.format.elf.ElfRelocationTable;
import ghidra.app.util.bin.format.elf.ElfSectionHeader;
import ghidra.app.util.bin.format.elf.ElfStringTable;
import ghidra.app.util.bin.format.elf.ElfSymbol;
import ghidra.app.util.bin.format.elf.ElfSymbolTable;
import ghidra.app.util.demangler.gnu.GnuDemanglerFormat;
import ghidra.app.util.demangler.gnu.GnuDemanglerOptions;
import ghidra.framework.cmd.Command;
import ghidra.program.model.mem.*;
import ghidra.program.model.lang.*;
import ghidra.util.InvalidNameException;
import ghidra.util.exception.DuplicateNameException;

import stabs.StabsLexer;
import stabs.StabsParser;

import ghidra.program.model.data.*;
import ghidra.program.model.symbol.*;
import ghidra.program.model.listing.*;
import ghidra.program.model.address.*;

public class StabsScript extends GhidraScript {
    public static final boolean DEBUG = false;

    public static class StabSymbolTypes {
        private StabSymbolTypes() {
        }

        public static final int N_UNDF           = 0x0;
        public static final int N_ABS            = 0x2;
        public static final int N_TEXT           = 0x4;
        public static final int N_DATA           = 0x6;
        public static final int N_BSS            = 0x8;
        public static final int N_INDR           = 0x0a;
        public static final int N_FN_SEQ         = 0x0c;
        public static final int N_COMM           = 0x12;
        public static final int N_SETA           = 0x14;
        public static final int N_SETT           = 0x16;
        public static final int N_SETD           = 0x18;
        public static final int N_SETB           = 0x1a;
        public static final int N_SETV           = 0x1c;
        public static final int N_WARNING        = 0x1e;
        public static final int N_FN             = 0x1f;
        public static final int N_GSYM           = 0x20;
        public static final int N_FNAME          = 0x22;
        public static final int N_FUN            = 0x24;
        public static final int N_STSYM          = 0x26;
        public static final int N_LCSYM          = 0x28;
        public static final int N_MAIN           = 0x2a;
        public static final int N_ROSYM          = 0x2c;
        public static final int N_PC             = 0x30;
        public static final int N_NSYMS          = 0x32;
        public static final int N_NOMAP          = 0x34;
        public static final int N_MAC_DEFINE     = 0x36;
        public static final int N_OBJ            = 0x38;
        public static final int N_MAC_UNDEF      = 0x3a;
        public static final int N_OPT            = 0x3c;
        public static final int N_RSYM           = 0x40;
        public static final int N_M2C            = 0x42;
        public static final int N_SLINE          = 0x44;
        public static final int N_DSLINE         = 0x46;
        public static final int N_BSLINE_N_BROWS = 0x48;
        public static final int N_DEFD           = 0x4a;
        public static final int N_FLINE          = 0x4c;
        public static final int N_EHDECL_N_MOD2  = 0x50;
        public static final int N_CATCH          = 0x54;
        public static final int N_SSYM           = 0x60;
        public static final int N_ENDM           = 0x62;
        public static final int N_SO             = 0x64;
        public static final int N_LSYM           = 0x80;
        public static final int N_BINCL          = 0x82;
        public static final int N_SOL            = 0x84;
        public static final int N_PSYM           = 0xa0;
        public static final int N_EINCL          = 0xa2;
        public static final int N_ENTRY          = 0xa4;
        public static final int N_LBRAC          = 0xc0;
        public static final int N_EXCL           = 0xc2;
        public static final int N_SCOPE          = 0xc4;
        public static final int N_RBRAC          = 0xe0;
        public static final int N_BCOMM          = 0xe2;
        public static final int N_ECOMM          = 0xe4;
        public static final int N_ECOML          = 0xe8;
        public static final int N_WITH           = 0xea;
        public static final int N_NBTEXT         = 0xf0;
        public static final int N_NBDATA         = 0xf2;
        public static final int N_NBBSS          = 0xf4;
        public static final int N_NBSTS          = 0xf6;
        public static final int N_NBLCS          = 0xf8;
    }

    public static Map<Integer, String> stabSymbolTypesMap = Map.ofEntries(
        Map.entry(StabSymbolTypes.N_UNDF,           "N_UNDF"),
        Map.entry(StabSymbolTypes.N_ABS,            "N_ABS"),
        Map.entry(StabSymbolTypes.N_TEXT,           "N_TEXT"),
        Map.entry(StabSymbolTypes.N_DATA,           "N_DATA"),
        Map.entry(StabSymbolTypes.N_BSS,            "N_BSS"),
        Map.entry(StabSymbolTypes.N_INDR,           "N_INDR"),
        Map.entry(StabSymbolTypes.N_FN_SEQ,         "N_FN_SEQ"),
        Map.entry(StabSymbolTypes.N_COMM,           "N_COMM"),
        Map.entry(StabSymbolTypes.N_SETA,           "N_SETA"),
        Map.entry(StabSymbolTypes.N_SETT,           "N_SETT"),
        Map.entry(StabSymbolTypes.N_SETD,           "N_SETD"),
        Map.entry(StabSymbolTypes.N_SETB,           "N_SETB"),
        Map.entry(StabSymbolTypes.N_SETV,           "N_SETV"),
        Map.entry(StabSymbolTypes.N_WARNING,        "N_WARNING"),
        Map.entry(StabSymbolTypes.N_FN,             "N_FN"),
        Map.entry(StabSymbolTypes.N_GSYM,           "N_GSYM"),
        Map.entry(StabSymbolTypes.N_FNAME,          "N_FNAME"),
        Map.entry(StabSymbolTypes.N_FUN,            "N_FUN"),
        Map.entry(StabSymbolTypes.N_STSYM,          "N_STSYM"),
        Map.entry(StabSymbolTypes.N_LCSYM,          "N_LCSYM"),
        Map.entry(StabSymbolTypes.N_MAIN,           "N_MAIN"),
        Map.entry(StabSymbolTypes.N_ROSYM,          "N_ROSYM"),
        Map.entry(StabSymbolTypes.N_PC,             "N_PC"),
        Map.entry(StabSymbolTypes.N_NSYMS,          "N_NSYMS"),
        Map.entry(StabSymbolTypes.N_NOMAP,          "N_NOMAP"),
        Map.entry(StabSymbolTypes.N_MAC_DEFINE,     "N_MAC_DEFINE"),
        Map.entry(StabSymbolTypes.N_OBJ,            "N_OBJ"),
        Map.entry(StabSymbolTypes.N_MAC_UNDEF,      "N_MAC_UNDEF"),
        Map.entry(StabSymbolTypes.N_OPT,            "N_OPT"),
        Map.entry(StabSymbolTypes.N_RSYM,           "N_RSYM"),
        Map.entry(StabSymbolTypes.N_M2C,            "N_M2C"),
        Map.entry(StabSymbolTypes.N_SLINE,          "N_SLINE"),
        Map.entry(StabSymbolTypes.N_DSLINE,         "N_DSLINE"),
        Map.entry(StabSymbolTypes.N_BSLINE_N_BROWS, "N_BSLINE/N_BROWS"),
        Map.entry(StabSymbolTypes.N_DEFD,           "N_DEFD"),
        Map.entry(StabSymbolTypes.N_FLINE,          "N_FLINE"),
        Map.entry(StabSymbolTypes.N_EHDECL_N_MOD2,  "N_EHDECL/N_MOD2"),
        Map.entry(StabSymbolTypes.N_CATCH,          "N_CATCH"),
        Map.entry(StabSymbolTypes.N_SSYM,           "N_SSYM"),
        Map.entry(StabSymbolTypes.N_ENDM,           "N_ENDM"),
        Map.entry(StabSymbolTypes.N_SO,             "N_SO"),
        Map.entry(StabSymbolTypes.N_LSYM,           "N_LSYM"),
        Map.entry(StabSymbolTypes.N_BINCL,          "N_BINCL"),
        Map.entry(StabSymbolTypes.N_SOL,            "N_SOL"),
        Map.entry(StabSymbolTypes.N_PSYM,           "N_PSYM"),
        Map.entry(StabSymbolTypes.N_EINCL,          "N_EINCL"),
        Map.entry(StabSymbolTypes.N_ENTRY,          "N_ENTRY"),
        Map.entry(StabSymbolTypes.N_LBRAC,          "N_LBRAC"),
        Map.entry(StabSymbolTypes.N_EXCL,           "N_EXCL"),
        Map.entry(StabSymbolTypes.N_SCOPE,          "N_SCOPE"),
        Map.entry(StabSymbolTypes.N_RBRAC,          "N_RBRAC"),
        Map.entry(StabSymbolTypes.N_BCOMM,          "N_BCOMM"),
        Map.entry(StabSymbolTypes.N_ECOMM,          "N_ECOMM"),
        Map.entry(StabSymbolTypes.N_ECOML,          "N_ECOML"),
        Map.entry(StabSymbolTypes.N_WITH,           "N_WITH"),
        Map.entry(StabSymbolTypes.N_NBTEXT,         "N_NBTEXT"),
        Map.entry(StabSymbolTypes.N_NBDATA,         "N_NBDATA"),
        Map.entry(StabSymbolTypes.N_NBBSS,          "N_NBBSS"),
        Map.entry(StabSymbolTypes.N_NBSTS,          "N_NBSTS"),
        Map.entry(StabSymbolTypes.N_NBLCS,          "N_NBLCS")
    );

    public static enum ClassAccessibility {
        Undefined,
        Private,
        Protected,
        Public        
    }

    public static class Type {
        public Pair<String, Integer> id;
        public Type type;

        @Override
        public String toString() {
            return String.format("Type[id = %s, type = %s]", id, type);
        }
    }

    public static class ArrayType extends Type {
        public RangeType indexType;
        
        @Override
        public String toString() {
            return String.format("ArrayType[id = %s, indexType = %s, elementsType = %s]", id, indexType, type);
        }
    }

    public static class AttributeType extends Type {
        public static enum BuiltinType {
            Boolean8,
            Boolean16,
            Boolean32,
            Boolean64,
            Char,
            Complex,
            DoubleComplex,
            Double,
            Float,
            Int32,
            Int64,
            Short,
            String,
            UnsignedChar,
            UnsignedInt32,
            UnsignedInt64,
            UnsignedShort,
            Void,
            WChar
        }

        public BuiltinType builtinType;

        @Override
        public String toString() {
            return String.format("AttributeType[id = %s, builtinType = %s]", id, builtinType);
        }
    }

    public static class AttributeBoundaryType extends AttributeType {
        public int boundary;

        @Override
        public String toString() {
            return String.format("AttributeBoundaryType[id = %s, builtinType = %s, boundary = %d]", id, builtinType, boundary);
        }
    }

    public static class AttributePackedType extends AttributeType {
        @Override
        public String toString() {
            return String.format("AttributePackedType[id = %s, builtinType = %s]", id, builtinType);
        }
    }

    public static class AttributePointerType extends AttributeType {
        public int size;

        @Override
        public String toString() {
            return String.format("AttributePointerType[id = %s, builtinType = %s, size = %]", id, builtinType, size);
        }
    }

    public static class AttributeSizeType extends AttributeType {
        public int size;

        @Override
        public String toString() {
            return String.format("AttributeSizeType[id = %s, builtinType = %s, size = %d]", id, builtinType, size);
        }
    }

    public static class AttributeStringType extends AttributeType {
        @Override
        public String toString() {
            return String.format("AttributePointerType[id = %s, builtinType = %s]", id, builtinType);
        }
    }

    public static class AttributeVectorType extends AttributeType {
        @Override
        public String toString() {
            return String.format("AttributeVectorType[id = %s, builtinType = %s]", id, builtinType);
        }
    }

    public static class ClassMethodType extends Type {
        public boolean mangledSignature;
        public List<Type> signature;

        @Override
        public String toString() {
            return String.format("ClassMethodType[id = %s, returnType = %s, mangledSignature = %b, signature = %s]", id, type, mangledSignature, signature);
        }
    }

    public static class EnumType extends Type {
        public List<Pair<String, Integer>> members;

        @Override
        public String toString() {
            return String.format("EnumType[id = %s, members = %s]", id, members);
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

    public static class RangeType extends Type {
        public long minValue;
        public long maxValue;
		public boolean isArray;

        @Override
        public String toString() {
            return String.format("RangeType[id = %s, baseType = %s, minValue = %d, maxValue = %d, isArray = %b]", id, type, minValue, maxValue, isArray);
        }
    }

    public static class ReferenceType extends Type {
        @Override
        public String toString() {
            return String.format("ReferenceType[id = %s, targetType = %s]", id, type);
        }
    }

    public static class StructUnionClassType extends Type {
        public static enum StructUnionClassSpecificType {
            Struct,
            Union,
            UnionClass,
            Class,
        }

        public StructUnionClassSpecificType specificType;
        public Integer size;
        public List<ClassInheritanceDataType> inheritanceInfo;
        public List<StructUnionClassMemberType> members;

        @Override
        public String toString() {
            return String.format("StructUnionClassType[id = %s, specificType = %s, size = %d, members = %s]", id, specificType, size, members);
        }
    }

    public static class ClassInheritanceDataType extends Type {
        public boolean isVirtual;
        public ClassAccessibility accessibility;
        public int baseOffset;
        public Type baseClass;

        @Override
        public String toString() {
            return String.format("ClassInheritanceDataType[isVirtual = %b, accessibility = %s, baseOffset = %d, baseClass = %s]", isVirtual, accessibility, baseOffset, baseClass);
        }
    }

    public static class StructUnionClassMemberType extends Type {
        public String name;

        @Override
        public String toString() {
            return String.format("StructUnionClassMemberType[type = %s, name = %s, offset = %d, size = %d]", type, name);
        }
    }

    public static class StructUnionClassMemberFieldType extends StructUnionClassMemberType {
        public ClassAccessibility accessibility;
        public Integer offset;
        public Integer size;

        @Override
        public String toString() {
            return String.format("StructUnionClassMemberFieldType[type = %s, name = %s, accessibility = %s, offset = %d, size = %d]", type, name, accessibility, offset, size);
        }
    }

    public static class ClassMemberMethodType extends StructUnionClassMemberType {
        public List<ClassMemberMethodOverloadType> overloads;

        @Override
        public String toString() {
            return String.format("ClassMemberMethodType[type = %s, name = %s, overloads = %s]", type, name, overloads);
        }
    }

    public static class ClassMemberMethodOverloadType extends Type {
        public static enum MethodModifier {
            Normal,
            Const,
            Volatile,
            ConstVolatile
        }

        public String mangledSignature;
        public ClassAccessibility accessibility;
        public MethodModifier modifier;
        public boolean isStatic;
        public boolean isVirtual;
        public int vTableIndex;
        public Type baseClassType;

        @Override
        public String toString() {
            String virtualInfo = "";

            if (isVirtual) {
                virtualInfo = String.format(", vTableIndex = %d, baseClassType = %s", vTableIndex, baseClassType);
            }

            return String.format("ClassMemberMethodOverloadType[id = %s, type = %s, mangledSignature = %s, accessibility = %s, modifier = %s, isStatic = %b, isVirtual = %b%s]", id, type, mangledSignature, accessibility, modifier, isStatic, isVirtual, virtualInfo);
        }
    }

    public static class ClassMemberStaticFieldType extends StructUnionClassMemberType {
        public ClassAccessibility accessibility;
        public String mangledName;

        @Override
        public String toString() {
            return String.format("ClassMemberStaticFieldType[id = %s, type = %s, accessibility = %s, mangledName = %s]", id, type, accessibility, mangledName);
        }
    }

    public static class ClassMemberVirtualTableType extends StructUnionClassMemberType {
        public Type classType;
        public Integer offset;

        @Override
        public String toString() {
            return String.format("ClassVirtualTable[type = %s, name = %s, classType = %s, offset = %d]", type, name, classType, offset);
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

    public static class Symbol extends Type {
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

        public String category;
        public Integer typeValue;
        public Address address;
        public Integer value;
        public String name;
        public SymbolType symbolType;
        public Type type;

        @Override
        public String toString() {
            return String.format("Symbol[typeValue = %s, address = 0x%s, value = 0x%x, category = %s, name = %s, symbolType = %s, type = %s]", stabSymbolTypesMap.get(typeValue), address, value, category, name, symbolType, type);
        }
    }

    private String architecture;
    private boolean is64bit;
    private Address stabAddress;
    private int stabValue;
    private boolean isCpp;

    private int enumCounter;
    private int funcCounter;
    private int structCounter;
    private int unionCounter;
    private String sourceDirectory;
    private String sourceFilename;
    private String unitFilename;
    private Address funcAddress;
    private int funcOrdinal;
    private List<Command<Program>> commands;
    private List<String> fileList;
    private Stack<Integer> fileIndex;
    private Map<String, List<Map<Integer, Type>>> typeDict;
    private List<Symbol> symbolList;
    private Map<Type, DataType> dataTypeDict;
    private Map<String, Address> globalSymbolAddresses;

    public StabsScript() {
        commands = new ArrayList<>();
        fileList = new ArrayList<>();
        fileIndex = new Stack<>();
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
        unitFilename = null;
        funcAddress = null;
        funcOrdinal = 0;
        commands.clear();
        fileList.clear();
        fileIndex.clear();
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

    public String getCurrentPath() {
        String file = fileList.get(fileIndex.peek());
        String path = "";
		String categoryPath = "";

        if (!FilenameUtils.getPrefix(file).isEmpty()) {
            path = file;
        } else if (FilenameUtils.concat(sourceDirectory, file) != null) {
            path = FilenameUtils.separatorsToUnix(FilenameUtils.concat(sourceDirectory, file));
        }
		
		if(unitFilename != null && unitFilename.length() > 0) {
			categoryPath += String.format("/%s", unitFilename);
		}
		
        if (!path.isEmpty()) {
            path = path.substring(path.lastIndexOf("/"));
        }

        if (!path.isEmpty() && !path.equals(categoryPath)) {
		    categoryPath = path;
        }
		
        return categoryPath;
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
                default: throw new RuntimeException(String.format("Unknown register: %d", registerIndex));
            }
        }
        
        if (architecture.equals("sparc")) {
            switch (registerIndex / 8) {
                case 0: register = "g"; break;
                case 1: register = "o"; break;
                case 2: register = "l"; break;
                case 3: register = "i"; break;
                default: throw new RuntimeException(String.format("Unknown register: %d", registerIndex));
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
            if (type instanceof ArrayType) {
                dataType = createDataType((ArrayType) type);
            } else if (type instanceof AttributeType) {
                dataType = createDataType((AttributeType) type);
            } else if (type instanceof ClassMethodType) {
                dataType = createDataType((ClassMethodType) type);
            } else if (type instanceof EnumType) {
                dataType = createDataType((EnumType) type);
            } else if (type instanceof FunctionType) {
                dataType = createDataType((FunctionType) type);
            } else if (type instanceof NestedFunctionType) {
                dataType = createDataType((NestedFunctionType) type);
            } else if (type instanceof PointerType) {
                dataType = createDataType((PointerType) type);
            } else if (type instanceof RangeType) {
                dataType = createDataType((RangeType) type);
            } else if (type instanceof ReferenceType) {
                dataType = createDataType((ReferenceType) type);
            } else if (type instanceof StructUnionClassType) {
                dataType = createDataType((StructUnionClassType) type);
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
                throw new RuntimeException(String.format("Unknown data type: %s", type));
            }
            
            if (!dataTypeDict.containsKey(type)) {
                dataTypeDict.put(type, dataType);
            }
        }

        return dataType;
    }

    private DataType createDataType(ArrayType type) {
        DataType indexDataType = createDataType(type.indexType);
        DataType elementsDataType = getDataType(type.type);

        if (indexDataType instanceof PointerDataType) {
            if (is64bit) {
                return PointerDataType.getPointer(elementsDataType, LongLongDataType.dataType.getLength());
            }

            return PointerDataType.getPointer(elementsDataType, IntegerDataType.dataType.getLength());
        }

        return new ArrayDataType(elementsDataType, ((ArrayDataType)indexDataType).getNumElements(), elementsDataType.getLength());
    }

    private DataType createAttributeDataType(AttributeType.BuiltinType builtinType) {
        switch (builtinType) {
            case AttributeType.BuiltinType.Boolean8:
                return ByteDataType.dataType;
            case AttributeType.BuiltinType.Boolean16:
                return ShortDataType.dataType;
            case AttributeType.BuiltinType.Boolean32:
                return IntegerDataType.dataType;
            case AttributeType.BuiltinType.Boolean64:
                return LongLongDataType.dataType;
            case AttributeType.BuiltinType.Char:
                return CharDataType.dataType;
            case AttributeType.BuiltinType.Complex:
                return FloatComplexDataType.dataType;
            case AttributeType.BuiltinType.DoubleComplex:
                return DoubleComplexDataType.dataType;
            case AttributeType.BuiltinType.Double:
                return DoubleDataType.dataType;
            case AttributeType.BuiltinType.Float:
                return FloatDataType.dataType;
            case AttributeType.BuiltinType.Int32:
                return IntegerDataType.dataType;
            case AttributeType.BuiltinType.Int64:
                return LongLongDataType.dataType;
            case AttributeType.BuiltinType.Short:
                return ShortDataType.dataType;
            case AttributeType.BuiltinType.String:
                return TerminatedStringDataType.dataType;
            case AttributeType.BuiltinType.UnsignedChar:
                return UnsignedCharDataType.dataType;
            case AttributeType.BuiltinType.UnsignedInt32:
                return UnsignedIntegerDataType.dataType;
            case AttributeType.BuiltinType.UnsignedInt64:
                return UnsignedLongLongDataType.dataType;
            case AttributeType.BuiltinType.UnsignedShort:
                return UnsignedShortDataType.dataType;
            case AttributeType.BuiltinType.Void:
                return VoidDataType.dataType;
            case AttributeType.BuiltinType.WChar:
                return WideCharDataType.dataType;
            default:
                break;
        }

        return null;
    }

    private DataType createDataType(AttributeType type) {
        if (type instanceof AttributeBoundaryType) {
            throw new RuntimeException("Boundary attribute is not supported");
        }

        if (type instanceof AttributePackedType) {
            throw new RuntimeException("Packed attribute is not supported");
        }

        if (type instanceof AttributePointerType) {
            if (is64bit) {
                return PointerDataType.getPointer(createAttributeDataType(type.builtinType), LongLongDataType.dataType.getLength());
            }

            return PointerDataType.getPointer(createAttributeDataType(type.builtinType), IntegerDataType.dataType.getLength());
        }

        if (type instanceof AttributeSizeType) {
            switch (((AttributeSizeType)type).size) {
                case 8:
                    return ByteDataType.dataType;
                case 16:
                    return ShortDataType.dataType;
                case 32:
                    return IntegerDataType.dataType;
                case 64:
                    return LongLongDataType.dataType;
                default:
                    break;
            }
        }

        if (type instanceof AttributeStringType) {
            return TerminatedStringDataType.dataType;
        }

        if (type instanceof AttributeVectorType) {
            return PointerDataType.getPointer(createAttributeDataType(type.builtinType), IntegerDataType.dataType.getLength()); 
        }

        return null;
    }

    private DataType createDataType(ClassMethodType type) {
        return null;
    }

    private DataType createDataType(EnumType type) {
        EnumDataType enumDataType = new EnumDataType(new CategoryPath(getCurrentPath()), makeEnumName(), IntegerDataType.dataType.getLength());

        for (Pair<String, Integer> member : type.members) {
            enumDataType.add(member.getLeft(), member.getRight());
        }

        return enumDataType;
    }

    private DataType createDataType(FunctionType type) {
        FunctionDefinitionDataType functionDefinitionDataType = new FunctionDefinitionDataType(new CategoryPath(getCurrentPath()), makeFuncName());
        
        functionDefinitionDataType.setReturnType(getDataType(type.type));

        if (DEBUG) {
            println(String.format("Function created: %s\nOriginal type: %s", functionDefinitionDataType, type));
        }

        return functionDefinitionDataType;
    }

    private DataType createDataType(NestedFunctionType type) {
        DataType returnType = getDataType(type.type);

        FunctionDefinitionDataType functionDefinitionDataType = new FunctionDefinitionDataType(new CategoryPath(getCurrentPath()), makeFuncName());
        
        functionDefinitionDataType.setReturnType(returnType);

        return functionDefinitionDataType;
    }

    private DataType createDataType(PointerType type) {
        if (is64bit) {
            return PointerDataType.getPointer(getDataType(type.type), LongLongDataType.dataType.getLength());
        }

        return PointerDataType.getPointer(getDataType(type.type), IntegerDataType.dataType.getLength());
    }

    private DataType detectBuiltinDataType(long minValue, long maxValue) {
        if (minValue == 0x0L && maxValue == 0x7fL) {
            return CharDataType.dataType;
        }

        if (minValue == 0x80L && maxValue == 0x7fL) {
            return SignedByteDataType.dataType;
        }
        
        if (minValue == 0L && maxValue == 0xffL) {
            return ByteDataType.dataType;
        }

        if (minValue == 0x8000L && maxValue == 0x7fffL) {
            return ShortDataType.dataType;
        }

        if (minValue == 0L && maxValue == 0xffffL) {
            return UnsignedShortDataType.dataType;
        }

        if (minValue == 0x80000000L && maxValue == 0x7fffffffL) {
            return IntegerDataType.dataType;
        }

        if (minValue == 0L && maxValue == 0xffffffffL) {
            return UnsignedIntegerDataType.dataType;
        }

        if (minValue == 0x8000000000000000L && maxValue == 0x7fffffffffffffffL) {
            return LongLongDataType.dataType;
        }

        if (minValue == 0L && maxValue == 0xffffffffffffffffL) {
            return UnsignedLongLongDataType.dataType;
        }

        if (minValue == 4 && maxValue == 0) {
            return FloatComplexDataType.dataType;
        }

        if (minValue == 8 && maxValue == 0) {
            return DoubleComplexDataType.dataType;
        }

        if (minValue == 16 && maxValue == 0) {
            return LongDoubleComplexDataType.dataType;
        }

        return null;
    }

    private DataType createDataType(RangeType type) {
        if (type.id != null && type.id.equals(type.type.id)) {
            DataType builtinDataType = detectBuiltinDataType(type.minValue, type.maxValue);

            if (builtinDataType == null) {
                throw new RuntimeException(String.format("Unknown range type: %s", type));
            }

            return builtinDataType;
        }

        DataType baseDataType = getDataType(type.type);

        if (
            !type.isArray
            && (
                baseDataType instanceof IntegerDataType
                || (baseDataType instanceof TypedefDataType && ((TypedefDataType)baseDataType).getDataType() instanceof IntegerDataType)
            )
        ) {
            if (type.minValue == 0L && type.maxValue == 0xffffffffL) {
                return UnsignedIntegerDataType.dataType;
            }
            
            if (type.minValue == 4 && type.maxValue == 0) {
                return FloatDataType.dataType;
            }
            
            if (type.minValue == 8 && type.maxValue == 0) {
                return DoubleDataType.dataType;
            }
            
            if (type.minValue == 16 && type.maxValue == 0) {
                return LongDoubleDataType.dataType;
            }

            DataType builtinDataType = detectBuiltinDataType(type.minValue, type.maxValue);

            if (builtinDataType != null) {
                return builtinDataType;
            }
        }

        if (type.minValue != 0) {
            throw new RuntimeException(String.format("Unknown primitive type: %s", type));
        }

        if (type.isArray && type.maxValue == -1L) {
            if (is64bit) {
                return PointerDataType.getPointer(LongLongDataType.dataType, LongLongDataType.dataType.getLength());  // Implicitly sized array -> decays to pointer
            }

            return PointerDataType.getPointer(IntegerDataType.dataType, IntegerDataType.dataType.getLength());  // Implicitly sized array -> decays to pointer
        }

        int numElements = Long.valueOf(type.maxValue).intValue() - Long.valueOf(type.minValue).intValue() + 1;
        
        return new ArrayDataType(IntegerDataType.dataType, numElements, IntegerDataType.dataType.getLength());
    }

    private DataType createDataType(ReferenceType type) {
        if (is64bit) {
            return PointerDataType.getPointer(getDataType(type.type), LongLongDataType.dataType.getLength());
        }

        return PointerDataType.getPointer(getDataType(type.type), IntegerDataType.dataType.getLength());
    }

    private DataType createDataType(StructUnionClassType type) {
        if (
            type.specificType == StructUnionClassType.StructUnionClassSpecificType.Struct
            || type.specificType == StructUnionClassType.StructUnionClassSpecificType.Class
        ) {
            return createStruct(type);
        }

        if (
            type.specificType == StructUnionClassType.StructUnionClassSpecificType.Union
            || type.specificType == StructUnionClassType.StructUnionClassSpecificType.UnionClass
        ) {
            return createUnion(type);
        }

        throw new RuntimeException(String.format("Undefined composite type: %s", type));
    }
    
    private StructureDataType createStruct(StructUnionClassType structType) {
        StructureDataType structureDataType = new StructureDataType(new CategoryPath(getCurrentPath()), makeStructName(), 0);

        // Avoid circular reference errors
        dataTypeDict.put(structType, structureDataType);

        for (StructUnionClassMemberType memberType : structType.members) {
            if (!(memberType instanceof StructUnionClassMemberFieldType)
                && !(memberType instanceof ClassMemberVirtualTableType)
            ) {
                continue;
            }

            if (memberType instanceof StructUnionClassMemberFieldType) {
                StructUnionClassMemberFieldType fieldType = (StructUnionClassMemberFieldType)memberType;

                structureDataType.insertAtOffset(fieldType.offset, getDataType(fieldType.type), fieldType.size, fieldType.name, null);

                if (architecture.equals("x86")) {
                    DataTypeComponent dataTypeComponent = structureDataType.getComponent(structureDataType.getNumComponents() - 1);
                    
                    if (dataTypeComponent.getOffset() != fieldType.offset) {
                        throw new RuntimeException(String.format("Struct %s member %s offset mismatch: expected %d, actual %d", structureDataType.getName(), dataTypeComponent.getFieldName(), fieldType.offset, dataTypeComponent.getOffset()));
                    }
        
                    if (dataTypeComponent.getLength() != fieldType.size) {
                        throw new RuntimeException(String.format("Struct %s member %s size mismatch: expected %d, actual %d", structureDataType.getName(), dataTypeComponent.getFieldName(), fieldType.size, dataTypeComponent.getLength()));
                    }
                }
            } else if (memberType instanceof ClassMemberVirtualTableType) {
                ClassMemberVirtualTableType virtualTableType = (ClassMemberVirtualTableType)memberType;

                DataType virtualTableDataType = getDataType(virtualTableType.type);

                structureDataType.insertAtOffset(virtualTableType.offset, virtualTableDataType, virtualTableDataType.getLength(), virtualTableType.name, null);
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
                throw new RuntimeException(String.format("Struct %s size mismatch: expected %d, actual %d", structureDataType.getName(), structType.size, structureDataType.getLength()));
            }
        } else {
            if (structureDataType.getLength() < structType.size) {
                structureDataType.growStructure(structType.size - structureDataType.getLength());
            }
        }

        if (DEBUG) {
            println(String.format("Struct created: %s\nOriginal type = %s", structureDataType, structType));
        }

        return structureDataType;
    }
    
    private UnionDataType createUnion(StructUnionClassType unionType) {
        UnionDataType unionDataType = new UnionDataType(new CategoryPath(getCurrentPath()), makeUnionName());

        // Avoid circular reference errors
        dataTypeDict.put(unionType, unionDataType);

        for (StructUnionClassMemberType memberType : unionType.members) {
            if (!(memberType instanceof StructUnionClassMemberFieldType)) {
                continue;
            }

            StructUnionClassMemberFieldType fieldType = (StructUnionClassMemberFieldType)memberType;

            unionDataType.add(getDataType(fieldType.type), fieldType.name, null);

            if (architecture.equals("x86")) {
                DataTypeComponent dataTypeComponent = unionDataType.getComponent(unionDataType.getNumComponents() - 1);
                
                if (dataTypeComponent.getOffset() != fieldType.offset) {
                    throw new RuntimeException(String.format("Union %s member %s offset mismatch: expected %d, actual %d", unionDataType.getName(), dataTypeComponent.getFieldName(), fieldType.offset, dataTypeComponent.getOffset()));
                }
    
                if (dataTypeComponent.getLength() != fieldType.size) {
                    throw new RuntimeException(String.format("Union %s member %s size mismatch: expected %d, actual %d", unionDataType.getName(), dataTypeComponent.getFieldName(), fieldType.size, dataTypeComponent.getLength()));
                }
            }
        }

        if (architecture.equals("x86") && unionDataType.getLength() != unionType.size) {
            throw new RuntimeException(String.format("Union %s size mismatch: expected %d, actual %d", unionDataType.getName(), unionType.size, unionDataType.getLength()));
        }

        return unionDataType;
    }

    private DataType createDataType(XrefType type) {
        for (Symbol symbol : symbolList) {
            if (type.targetName.equals(symbol.name)) {
                switch (type.targetType) {
                    case Enum:
                        if (symbol.type instanceof EnumType) {
                            return getDataType(symbol.type);
                        }
                        break;
                    case Struct:
                    case Union:
                        if (symbol.type instanceof StructUnionClassType) {
                            return getDataType(symbol.type);
                        }
                    default:
                        break;
                }
            }
        }

        if (type.targetType == XrefType.TargetType.Enum) {
            return new EnumDataType(new CategoryPath(getCurrentPath()), type.targetName, IntegerDataType.dataType.getLength());
        }

        if (type.targetType == XrefType.TargetType.Struct) {
            return new StructureDataType(new CategoryPath(getCurrentPath()), type.targetName, 0);
        }

        if (type.targetType == XrefType.TargetType.Union) {
            return new UnionDataType(new CategoryPath(getCurrentPath()), type.targetName);
        }

        throw new RuntimeException(String.format("Undefined Xref Type: %s", type));
    }

    public void createFunction(Symbol symbol) {
        funcAddress = symbol.address;
        funcOrdinal = 0;

        Command<Program> command = new SetFunctionNameCmd(funcAddress, symbol.name, SourceType.IMPORTED);
        command.applyTo(currentProgram);

        command = new SetReturnDataTypeCmd(funcAddress, getDataType(symbol.type), SourceType.IMPORTED);
        command.applyTo(currentProgram);

        if (isCpp) {
            GnuDemanglerOptions options = new GnuDemanglerOptions(GnuDemanglerFormat.GNU);
            options.setApplyCallingConvention(true);
            options.setApplySignature(false);
            options.setDemangleOnlyKnownPatterns(false);
            options.setDoDisassembly(false);
            options.setUseStandardReplacements(true);

            DemanglerCmd demanglerCmd = new DemanglerCmd(symbol.address, symbol.name, options);

            if (DEBUG) {
                println(String.format("Demangling %s with command: %s and options %s", symbol.name, demanglerCmd, options));
            }

            if(!demanglerCmd.applyTo(currentProgram, monitor) && DEBUG) {
                println(String.format("Command failed: %s", demanglerCmd.getStatusMsg()));
            }
        }
    }

    private void createStackParameter(Symbol symbol) {
        FunctionManager functionManager = currentProgram.getFunctionManager();
        Function function = functionManager.getFunctionAt(funcAddress);

        Command<Program> command = new AddStackParameterCommand(function, symbol.value, symbol.name, getDataType(symbol.type), funcOrdinal++, SourceType.IMPORTED);
        command.applyTo(currentProgram);
    }

    private void createStackVariable(Symbol symbol) {
        Command<Program> command = new AddStackVarCmd(funcAddress, symbol.value, symbol.name, getDataType(symbol.type), SourceType.IMPORTED);
        command.applyTo(currentProgram);
    }

    public void createMemoryVariable(Symbol symbol) {
        Address address = symbol.address;

        if (symbol.symbolType == Symbol.SymbolType.GlobalFunction) {
            address = globalSymbolAddresses.get(symbol.name);
        }

        Command<Program> command = new AddMemoryVarCmd(address, address, symbol.name, getDataType(symbol.type), SourceType.IMPORTED);
        command.applyTo(currentProgram);
    }

    public void createRegisterParameter(Symbol symbol) {
        FunctionManager functionManager = currentProgram.getFunctionManager();
        Function function = functionManager.getFunctionAt(funcAddress);

        Command<Program> command = new AddRegisterParameterCommand(function, getRegister(symbol.value), symbol.name, getDataType(symbol.type), funcOrdinal++, SourceType.IMPORTED);
        command.applyTo(currentProgram);
    }

    public void createRegisterVariable(Symbol symbol) {
        Command<Program> command = new AddRegisterVarCmd(symbol.address, getRegister(symbol.value), symbol.name, getDataType(symbol.type), SourceType.IMPORTED);
        command.applyTo(currentProgram);
    }

    public void createGlobalVariable(Symbol symbol) {
        Command<Program> command = new CreateDataCmd(globalSymbolAddresses.get(symbol.name), true, getDataType(symbol.type));
        command.applyTo(currentProgram);
    }

    public void createStaticVariable(Symbol symbol) {
        Command<Program> command = new CreateDataCmd(symbol.address, true, getDataType(symbol.type));
        command.applyTo(currentProgram);
    }

    public void createTaggedType(Symbol symbol) {
        DataType dataType = getDataType(symbol.type);

        if (!(dataType instanceof EnumDataType
            || dataType instanceof StructureDataType
            || dataType instanceof UnionDataType
        )) {
            throw new RuntimeException(String.format("Expected enum, struct or union type, got %s", dataType.getClass().getName()));
        }

        if (!symbol.name.isBlank()) {
            try {
                boolean hasTypedef = false;

                for (Symbol otherSymbol : symbolList) {
                    if (otherSymbol.symbolType == Symbol.SymbolType.Typedef && symbol.name.equals(otherSymbol.name)) {
                        hasTypedef = true;
                        break;
                    }
                }

                if (!hasTypedef) {
                    dataType.setName(symbol.name);
                }
            } catch (DuplicateNameException|InvalidNameException e) {
                throw new RuntimeException(String.format("%s\n%s", e.getMessage(), Arrays.stream(e.getStackTrace()).map(x -> x.toString()).toList()));
            }
        }

        currentProgram.getDataTypeManager().addDataType(dataType, DataTypeConflictHandler.REPLACE_HANDLER);
    }

    public void createTypedefType(Symbol symbol) {
        DataType dataType = new TypedefDataType(new CategoryPath(getCurrentPath()), symbol.name, getDataType(symbol.type));
        dataTypeDict.put(symbol.type, dataType);

        currentProgram.getDataTypeManager().addDataType(dataType, DataTypeConflictHandler.REPLACE_HANDLER);
    }

    public Pair<String, Integer> getId(Pair<Integer, Integer> internalId) {
        if (internalId.getLeft() == -1) {
            return Pair.of(fileList.get(fileIndex.peek()), internalId.getRight());
        }

        return Pair.of(fileList.get(internalId.getLeft()), internalId.getRight());
    }

    public Pair<Integer, Integer> getInternalId(Pair<String, Integer> id) {
        if (id != null) {
            for (int i = 0; i < fileList.size(); i++) {
                if (fileList.get(i).equals(id.getLeft())) {
                    return Pair.of(i, id.getRight());
                }
            }
        }

        return null;
    }

    public Type getType(Pair<String, Integer> id) {
        if (typeDict.containsKey(id.getLeft())) {
            for (Map<Integer, Type> typesMap : typeDict.get(id.getLeft()).reversed()) {
                if (typesMap.containsKey(id.getRight())) {
                    return typesMap.get(id.getRight());
                }
            }
        }

        return null;
    }

    public void putType(Type type) {
        typeDict.get(type.id.getLeft()).getLast().put(type.id.getRight(), type);
    }

    public void putSymbol(Symbol symbol) {
        symbol.category = getCurrentPath();

        symbolList.add(symbol);
        putType(symbol);
    }

    private void importStabs() {
        if (DEBUG) {
            for (Symbol symbol : symbolList) {
                println(symbol.toString());
            }

            for (int i = 0; i < fileList.size(); i++) {
                String file = fileList.get(i);
                println(String.format("Types for file %d => %s:", i, file));

                List<Map<Integer, Type>> fileTypes = typeDict.getOrDefault(file, null);

                if (fileTypes == null) {
                    continue;
                }

                for (Map<Integer, Type> mapSet : fileTypes) {
                    for (Map.Entry<Integer,Type> type : mapSet.entrySet()) {
                        println(String.format("Type (%d, %d) => (%s, %d):", i, type.getKey(), file, type.getKey()));
                        println(String.format("%s", type.getValue()));
                    }
                }
            }
        }

        DataTypeManager dataTypeManager = currentProgram.getDataTypeManager();
        int id = dataTypeManager.startTransaction(unitFilename);

        if (!isCpp) {
            for (List<Map<Integer, Type>> typeList : typeDict.values()) {
                for (Map<Integer, Type> typeMap : typeList) {
                    for (Type type : typeMap.values()) {
                        if (type instanceof StructUnionClassType) {
                            StructUnionClassType structUnionClassType = (StructUnionClassType)type;

                            if (structUnionClassType.specificType == StructUnionClassType.StructUnionClassSpecificType.Class
                                || structUnionClassType.specificType == StructUnionClassType.StructUnionClassSpecificType.UnionClass
                            ) {
                                isCpp = true;
                                break;
                            }
                        }
                    }

                    if (isCpp) {
                        break;
                    }
                }

                if (isCpp) {
                    break;
                }
            }
        }

        for (Symbol symbol : symbolList) {
			try {
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
			} catch (RuntimeException e) {
				println(String.format("Error creating the symbol %s:\n%s", symbol, e));
			}
        }

        dataTypeManager.endTransaction(id, true);
        dataTypeManager.flushEvents();
    }

    private void parseStab(int symbolType, Address stabAddress, int stabValue, String str) {
		try {
			CharStream input = CharStreams.fromString(str);
			StabsLexer lexer = new StabsLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			StabsParser parser = new StabsParser(tokens);
			parser.setErrorHandler(new BailErrorStrategy());
			ParseTree tree = parser.symbol();
			StabsVisitor visitor = new StabsVisitor(this, symbolType, stabAddress, stabValue, is64bit);
			visitor.visit(tree);
		} catch (RuntimeException e) {
			println(String.format("Error parsing the stab entry: %s\n%s\n%s", str, e.getMessage(), String.join("\n", Arrays.stream(e.getStackTrace()).map(x -> x.toString()).toList())));
		}
    }

    @Override
    public AnalysisMode getScriptAnalysisMode() {
        return AnalysisMode.SUSPENDED;
    }

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
                break;
            default:
                throw new RuntimeException(String.format("Unsupported architecture: %d", elf.e_machine()));
        }

        is64bit = elf.is64Bit();

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

                if (type == 0) {
                    throw new RuntimeException(String.format("Unsupported relocation type: %d", type));
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

        for (int stab = 0; stab < stabCount; stab++) {
            long strx = reader.readNextUnsignedInt();
            int type = reader.readNextUnsignedByte();
            int other = reader.readNextUnsignedByte();
            int desc = reader.readNextUnsignedShort();
            int value = reader.readNextInt();

            if (type == StabSymbolTypes.N_UNDF) {
                unitOffset += unitSize;
                unitSize = value;
            }
            String str = "";

            if (strx != 0) {
                str = reader.readAsciiString(stabStrOffset + unitOffset + strx);
            }
            stabAddress = (hasRelocs ? addressMap.get(stab) : toAddr(value));
            stabValue = value;

            if (DEBUG && type != StabSymbolTypes.N_SLINE && type != StabSymbolTypes.N_LBRAC && type != StabSymbolTypes.N_RBRAC) {
                println(String.format("type = %s, other = %d, desc = %d, value = %d, str = %s", stabSymbolTypesMap.containsKey(type) ? stabSymbolTypesMap.get(type) : String.format("UNKNOWN: 0x%x", type), other, desc, value, str));
            }

            int newIndex;

            switch (type) {
                case StabSymbolTypes.N_UNDF:
                    if (sourceFilename != null || str.isEmpty()) {
                        importStabs();
                        clearStabs();
                        sourceDirectory = null;
                        sourceFilename = null;
                    }

                    if (str.isEmpty()) {
                        unitFilename = null;
                    } else {
                        unitFilename = str;
                    }
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
                        unitFilename = null;
                    } else {
						if (str.endsWith("/") || str.endsWith("\\")) {
							sourceDirectory = str;
						} else {
                            if (sourceDirectory != null && FilenameUtils.getPrefix(str).isEmpty() && FilenameUtils.concat(sourceDirectory, str) != null) {
                                str = FilenameUtils.separatorsToUnix(FilenameUtils.concat(sourceDirectory, str));
                            }

							sourceFilename = str;

                            if (unitFilename == null) {
                                unitFilename = FilenameUtils.getName(sourceFilename);
                            }

                            fileIndex.clear();
                            fileIndex.push(fileList.size());

                            fileList.add(sourceFilename);
                            typeDict.putIfAbsent(sourceFilename, new ArrayList<>());
                            typeDict.get(sourceFilename).add(new HashMap<>());

                            if (DEBUG) {
                                println(String.format("index = %d, unitFilename = %s, sourceFilename = %s, sourceDirectory = %s, fileIndex = %s, fileList = %s", fileIndex.peek(), unitFilename, sourceFilename, sourceDirectory, fileIndex, fileList));
                            }
						}
					}

                    break;

                case StabSymbolTypes.N_BINCL:
                    if (sourceDirectory != null && FilenameUtils.getPrefix(str).isEmpty() && FilenameUtils.concat(sourceDirectory, str) != null) {
                        str = FilenameUtils.separatorsToUnix(FilenameUtils.concat(sourceDirectory, str));
                    }

                    if (unitFilename == null) {
                        unitFilename = FilenameUtils.getName(str);
                    }

                    fileIndex.push(fileList.size());

                    fileList.add(str);
                    typeDict.putIfAbsent(str, new ArrayList<>());
                    typeDict.get(str).add(new HashMap<>());

                    if (DEBUG) {
                        println(String.format("index = %d, unitFilename = %s, str = %s, sourceDirectory = %s, fileIndex = %s, fileList = %s", fileIndex.peek(), unitFilename, str, sourceDirectory, fileIndex, fileList));
                    }
                    break;

                case StabSymbolTypes.N_SOL:
                    if (sourceDirectory != null && FilenameUtils.getPrefix(str).isEmpty() && FilenameUtils.concat(sourceDirectory, str) != null) {
                        str = FilenameUtils.separatorsToUnix(FilenameUtils.concat(sourceDirectory, str));
                    }

                    sourceFilename = str;

                    if (unitFilename == null) {
                        unitFilename = FilenameUtils.getName(sourceFilename);
                    }

                    newIndex = fileList.lastIndexOf(sourceFilename);

                    if (!fileIndex.empty()) {
                        fileIndex.pop();
                    }

                    if (newIndex > -1) {
                        fileIndex.push(newIndex);
                    } else {
                        fileIndex.push(fileList.size());
                        fileList.add(sourceFilename);
                    }

                    typeDict.putIfAbsent(str, new ArrayList<>());
                    
                    if (typeDict.get(str).isEmpty()) {
                        typeDict.get(str).add(new HashMap<>());
                    }

                    if (DEBUG) {
                        println(String.format("index = %d, unitFilename = %s, sourceFilename = %s, sourceDirectory = %s, fileIndex = %s, fileList = %s", fileIndex.peek(), unitFilename, sourceFilename, sourceDirectory, fileIndex, fileList));
                    }
                    break;

                case StabSymbolTypes.N_EINCL:
                    fileIndex.pop();

                    sourceFilename = fileList.get(fileIndex.peek());

                    if (DEBUG) {
                        println(String.format("index = %d, unitFilename = %s, sourceFilename = %s, sourceDirectory = %s, fileIndex = %s, fileList = %s", fileIndex.peek(), unitFilename, sourceFilename, sourceDirectory, fileIndex, fileList));
                    }
                    break;

                case StabSymbolTypes.N_LBRAC:
                    break;

                case StabSymbolTypes.N_EXCL:
                    if (sourceDirectory != null && FilenameUtils.getPrefix(str).isEmpty() && FilenameUtils.concat(sourceDirectory, str) != null) {
                        str = FilenameUtils.separatorsToUnix(FilenameUtils.concat(sourceDirectory, str));
                    }

                    if (unitFilename == null) {
                        unitFilename = FilenameUtils.getName(str);
                    }

                    if (!typeDict.containsKey(str)) {
                        throw new RuntimeException(String.format("N_EXCL not found: file %s, value %d", str, value));
                    }

                    fileList.add(str);

                    if (DEBUG) {
                        println(String.format("index = %d, unitFilename = %s, str = %s, sourceDirectory = %s, fileIndex = %s, fileList = %s", fileList.size(), unitFilename, str, sourceDirectory, fileIndex, fileList));
                    }
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

        if (!symbolList.isEmpty()) {
            importStabs();
            clearStabs();
        }

        provider.close();
    }
}
