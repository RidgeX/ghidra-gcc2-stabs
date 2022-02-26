import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import ghidra.program.model.data.*;
import stabs.StabsParser.*;
import stabs.StabsParserBaseVisitor;

@SuppressWarnings("unchecked")
public class StabsVisitor extends StabsParserBaseVisitor<Object> {
    private static final DataType BAD = BadDataType.dataType;
    private static final DataType CHAR = CharDataType.dataType;
    private static final DataType DOUBLE = DoubleDataType.dataType;
    private static final DataType DOUBLECOMPLEX = DoubleComplexDataType.dataType;
    private static final DataType FLOAT = FloatDataType.dataType;
    private static final DataType FLOATCOMPLEX = FloatComplexDataType.dataType;
    private static final DataType INT = IntegerDataType.dataType;
    private static final DataType LONGDOUBLE = LongDoubleDataType.dataType;
    private static final DataType LONGDOUBLECOMPLEX = LongDoubleComplexDataType.dataType;
    private static final DataType LONGLONG = LongLongDataType.dataType;
    private static final DataType SCHAR = SignedCharDataType.dataType;
    private static final DataType SHORT = ShortDataType.dataType;
    private static final DataType UCHAR = UnsignedCharDataType.dataType;
    private static final DataType UINT = UnsignedIntegerDataType.dataType;
    private static final DataType ULONGLONG = UnsignedLongLongDataType.dataType;
    private static final DataType UNDEF = Undefined4DataType.dataType;
    private static final DataType USHORT = UnsignedShortDataType.dataType;
    private static final DataType VOID = VoidDataType.dataType;

    private static final int SIZEOF_INT = INT.getLength();
    private static final int SIZEOF_LONGLONG = LONGLONG.getLength();

    private StabsScript script;

    public StabsVisitor(StabsScript script) {
        this.script = script;
    }

    @Override
    public DataType visitArrayType(ArrayTypeContext ctx) {
        DataType rangeType = (DataType) visit(ctx.rangeType());
        DataType memberType = (DataType) visit(ctx.type());

        if (rangeType instanceof PointerDataType) {
            return PointerDataType.getPointer(memberType, SIZEOF_INT);
        }

        int numElements = ((ArrayDataType) rangeType).getNumElements();
        return new ArrayDataType(memberType, numElements, memberType.getLength());
    }

    @Override
    public Pair<String, Integer> visitEnumMember(EnumMemberContext ctx) {
        String key = ctx.EnumIdentifier().getText();
        int value = Integer.parseInt(ctx.EnumInt().getText());

        return Pair.of(key, value);
    }

    @Override
    public DataType visitEnumType(EnumTypeContext ctx) {
        List<Pair<String, Integer>> pairs = new ArrayList<>();
        for (EnumMemberContext member : ctx.enumMember()) {
            pairs.add((Pair<String, Integer>) visit(member));
        }

        EnumDataType enumType = new EnumDataType(script.getCurrentPath(), script.makeEnumName(), SIZEOF_INT);
        for (Pair<String, Integer> pair : pairs) {
            enumType.add(pair.getLeft(), pair.getRight());
        }
        return enumType;
    }

    @Override
    public DataType visitFunctionType(FunctionTypeContext ctx) {
        DataType returnType = (DataType) visit(ctx.type());

        FunctionDefinitionDataType funcType = new FunctionDefinitionDataType(script.getCurrentPath(), script.makeFuncName());
        funcType.setReturnType(returnType);
        return funcType;
    }

    @Override
    public DataType visitPointerType(PointerTypeContext ctx) {
        DataType dataType = (DataType) visit(ctx.type());

        return PointerDataType.getPointer(dataType, SIZEOF_INT);
    }

    @Override
    public DataType visitRangeType(RangeTypeContext ctx) {
        DataType dataType = (DataType) visit(ctx.type());
        DataType baseType = null;
        if (dataType instanceof TypedefDataType) {
            baseType = ((TypedefDataType) dataType).getBaseDataType();
        }
        String min = ctx.RangeInt(0).getText();
        String max = ctx.RangeInt(1).getText();
        DataTypeManager dtm = script.getCurrentProgram().getDataTypeManager();

        if (dataType == UNDEF && min.equals("0020000000000") && max.equals("0017777777777")) {
            return INT;
        } else if (dataType == UNDEF && min.equals("0") && max.equals("127")) {
            return CHAR;
        } else if (baseType instanceof IntegerDataType && min.equals("0020000000000") && max.equals("0017777777777")) {
            return INT;
        } else if (baseType instanceof IntegerDataType && min.equals("0000000000000") && max.equals("0037777777777")) {
            return UINT;
        } else if (baseType instanceof IntegerDataType && min.equals("01000000000000000000000") && max.equals("0777777777777777777777")) {
            return LONGLONG;
        } else if (baseType instanceof IntegerDataType && min.equals("0000000000000") && max.equals("01777777777777777777777")) {
            return ULONGLONG;
        } else if (dataType == UNDEF && min.equals("-32768") && max.equals("32767")) {
            return SHORT;
        } else if (dataType == UNDEF && min.equals("0") && max.equals("65535")) {
            return USHORT;
        } else if (dataType == UNDEF && min.equals("-128") && max.equals("127")) {
            return SCHAR;
        } else if (dataType == UNDEF && min.equals("0") && max.equals("255")) {
            return UCHAR;
        } else if (baseType instanceof IntegerDataType && min.equals("4") && max.equals("0")) {
            return FLOAT;
        } else if (baseType instanceof IntegerDataType && min.equals("8") && max.equals("0")) {
            return DOUBLE;
        } else if (baseType instanceof IntegerDataType && min.equals("12") && max.equals("0")) {
            return AbstractFloatDataType.getFloatDataType(12, dtm);
        } else if (baseType instanceof IntegerDataType && min.equals("16") && max.equals("0")) {
            return LONGDOUBLE;
        } else if (dataType == UNDEF && min.equals("4") && max.equals("0")) {
            return FLOATCOMPLEX;
        } else if (dataType == UNDEF && min.equals("8") && max.equals("0")) {
            return DOUBLECOMPLEX;
        } else if (dataType == UNDEF && min.equals("12") && max.equals("0")) {
            return AbstractComplexDataType.getComplexDataType(12, dtm);
        } else if (dataType == UNDEF && min.equals("16") && max.equals("0")) {
            return LONGDOUBLECOMPLEX;
        }

        int rangeMin = Integer.parseInt(min);
        int rangeMax = Integer.parseInt(max);

        if (rangeMin != 0) {
            throw new RuntimeException("Unknown primitive type");
        }
        if (rangeMax == -1) {
            return PointerDataType.getPointer(INT, SIZEOF_INT);  // Implicitly sized array -> decays to pointer
        }

        int numElements = rangeMax - rangeMin + 1;
        return new ArrayDataType(INT, numElements, SIZEOF_INT);
    }

    @Override
    public Triple<DataType, String, Pair<Integer, Integer>> visitStructMember(StructMemberContext ctx) {
        String memberName = ctx.StructIdentifier().getText();
        DataType memberType = (DataType) visit(ctx.type());
        int memberOffset = Integer.parseInt(ctx.StructInt(0).getText()) / 8;
        int memberSize = Integer.parseInt(ctx.StructInt(1).getText()) / 8;

        return Triple.of(memberType, memberName, Pair.of(memberOffset, memberSize));
    }

    private DataType visitUnionType(StructTypeContext ctx) {
        int unionSize = Integer.parseInt(ctx.StructInt().getText());
        List<Triple<DataType, String, Pair<Integer, Integer>>> triples = new ArrayList<>();
        for (StructMemberContext member : ctx.structMember()) {
            triples.add((Triple<DataType, String, Pair<Integer, Integer>>) visit(member));
        }

        UnionDataType unionType = new UnionDataType(script.getCurrentPath(), script.makeUnionName());
        for (Triple<DataType, String, Pair<Integer, Integer>> triple : triples) {
            DataType memberDataType = triple.getLeft();
            String memberName = triple.getMiddle();
            int memberOffset = triple.getRight().getLeft();
            int memberSize = triple.getRight().getRight();

            unionType.add(memberDataType, memberName, null);
            DataTypeComponent component = unionType.getComponent(unionType.getNumComponents() - 1);
            if (component.getOffset() != memberOffset) {
                throw new RuntimeException("Union member offset mismatch");
            }
            if (component.getLength() != memberSize) {
                throw new RuntimeException("Union member size mismatch");
            }
        }
        if (unionType.getLength() != unionSize) {
            throw new RuntimeException("Union size mismatch");
        }
        return unionType;
    }

    @Override
    public DataType visitStructType(StructTypeContext ctx) {
        if (ctx.TypeDescUnion() != null) {
            return visitUnionType(ctx);
        }

        int structSize = Integer.parseInt(ctx.StructInt().getText());
        List<Triple<DataType, String, Pair<Integer, Integer>>> triples = new ArrayList<>();
        for (StructMemberContext member : ctx.structMember()) {
            triples.add((Triple<DataType, String, Pair<Integer, Integer>>) visit(member));
        }

        StructureDataType structType = new StructureDataType(script.getCurrentPath(), script.makeStructName(), 0);
        for (Triple<DataType, String, Pair<Integer, Integer>> triple : triples) {
            DataType memberDataType = triple.getLeft();
            String memberName = triple.getMiddle();
            int memberOffset = triple.getRight().getLeft();
            int memberSize = triple.getRight().getRight();

            structType.insertAtOffset(memberOffset, memberDataType, memberSize, memberName, null);
            DataTypeComponent component = structType.getComponent(structType.getNumComponents() - 1);
            if (component.getOffset() != memberOffset) {
                throw new RuntimeException("Struct member offset mismatch");
            }
            if (component.getLength() != memberSize) {
                throw new RuntimeException("Struct member size mismatch");
            }
        }
        if (structType.getLength() < structSize) {
            structType.setExplicitMinimumAlignment(SIZEOF_INT);
            structType.setExplicitPackingValue(SIZEOF_INT);
        }
        if (structType.getLength() < structSize) {
            structType.setExplicitMinimumAlignment(SIZEOF_LONGLONG);
            structType.setExplicitPackingValue(SIZEOF_LONGLONG);
        }
        if (structType.getLength() != structSize) {
            throw new RuntimeException("Struct size mismatch");
        }
        return structType;
    }

    @Override
    public DataType visitXrefType(XrefTypeContext ctx) {
        String xrefName = ctx.XrefIdentifier().getText();

        if (ctx.XrefDescEnum() != null) {
            return new EnumDataType(script.getCurrentPath(), "enum " + xrefName, SIZEOF_INT);
        }
        if (ctx.XrefDescUnion() != null) {
            return new UnionDataType(script.getCurrentPath(), "union " + xrefName);
        }
        return new StructureDataType(script.getCurrentPath(), "struct " + xrefName, 0);
    }

    @Override
    public DataType visitTypeDesc(TypeDescContext ctx) {
        return (DataType) visit(ctx.getChild(0));
    }

    @Override
    public Pair<Integer, Integer> visitTypeNum(TypeNumContext ctx) {
        int i = Integer.parseInt(ctx.TypeNumInt(0).getText());
        int j = Integer.parseInt(ctx.TypeNumInt(1).getText());

        return Pair.of(i, j);
    }

    @Override
    public DataType visitType(TypeContext ctx) {
        Pair<Integer, Integer> number = (Pair<Integer, Integer>) visit(ctx.typeNum());

        if (ctx.typeDesc() == null) {
            DataType dataType = script.getType(number);
            if (dataType == null) {
                dataType = UNDEF;  // Recursive range -> primitive type
            }
            return dataType;
        }

        DataType dataType = (DataType) visit(ctx.typeDesc());
        if (dataType == UNDEF) {
            dataType = VOID;  // Recursive typedef -> void type
        } else if (dataType == null) {
            dataType = BAD;  // Parsing error -> bad type
        }

        script.putType(number, dataType);
        return dataType;
    }

    @Override
    public DataType visitSymbol(SymbolContext ctx) {
        String name = ctx.SymbolName().getText();
        Pair<Integer, Integer> number = (Pair<Integer, Integer>) visit(ctx.type().typeNum());
        DataType dataType = (DataType) visit(ctx.type());

        if (ctx.SymbolDescStackVariable() != null) {
            script.recordStackVariable(dataType, name);
        } else if (ctx.SymbolDescReferenceParameter() != null) {
            script.recordReferenceParameter(dataType, name);
        } else if (ctx.SymbolDescGlobalFunction() != null) {
            script.recordFunction(dataType, name);
        } else if (ctx.SymbolDescLocalFunction() != null) {
            script.recordFunction(dataType, name);
        } else if (ctx.SymbolDescGlobalVariable() != null) {
            script.recordHeapVariable(dataType, name);
        } else if (ctx.SymbolDescRegisterParameter() != null) {
            script.recordRegisterParameter(dataType, name);
        } else if (ctx.SymbolDescStackParameter() != null) {
            script.recordStackParameter(dataType, name);
        } else if (ctx.SymbolDescRegisterVariable() != null) {
            script.recordRegisterVariable(dataType, name);
        } else if (ctx.SymbolDescStaticFileVariable() != null) {
            script.recordHeapVariable(dataType, name);
        } else if (ctx.SymbolDescTaggedType() != null) {
            script.recordTaggedType(number, name);
        } else if (ctx.SymbolDescTypedefedType() != null) {
            script.recordTypedefedType(number, name);
        } else if (ctx.SymbolDescStaticLocalVariable() != null) {
            script.recordHeapVariable(dataType, name);
        }
        return dataType;
    }
}
