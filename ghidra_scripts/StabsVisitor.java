import java.util.ArrayList;

import org.apache.commons.lang3.tuple.Pair;

import ghidra.program.model.address.Address;
import stabs.StabsParserBaseVisitor;
import stabs.StabsParser.*;

@SuppressWarnings("unchecked")
public class StabsVisitor extends StabsParserBaseVisitor<Object> {
    private StabsScript script;
    private Integer symbolTypeValue;
    private Address symbolAddress;
    private Integer symbolValue;
    private Boolean is64bit;

    public StabsVisitor(StabsScript script, Integer symbolTypeValue, Address symbolAddress, int symbolValue, boolean is64bit) {
        this.script = script;
        this.symbolTypeValue = symbolTypeValue;
        this.symbolAddress = symbolAddress;
        this.symbolValue = symbolValue;
        this.is64bit = is64bit;
    }

    @Override
    public StabsScript.ArrayType visitTypeDescriptionArray(TypeDescriptionArrayContext ctx) {
        StabsScript.ArrayType arrayType = new StabsScript.ArrayType();

        arrayType.indexType = (StabsScript.RangeType) visit(ctx.typeDescriptionRange());
        arrayType.indexType.isArray = true;
        arrayType.type = (StabsScript.Type) visit(ctx.type());

        return arrayType;
    }

    @Override
    public StabsScript.AttributeType visitTypeDescriptionAttribute(TypeDescriptionAttributeContext ctx) {
        StabsScript.AttributeType attributeType = null;

        if (ctx.attributeBoundary() != null) {
            StabsScript.AttributeBoundaryType attributeBoundaryType = new StabsScript.AttributeBoundaryType();
            attributeBoundaryType.boundary = Integer.parseInt(ctx.attributeBoundary().integer().getText());

            attributeType = attributeBoundaryType;
        } else if (ctx.attributePacked() != null) {
            attributeType = new StabsScript.AttributePackedType();
        } else if (ctx.attributePointer() != null) {
            StabsScript.AttributePointerType attributePointerType = new StabsScript.AttributePointerType();
            attributePointerType.size = Integer.parseInt(ctx.attributePointer().integer().getText());
            
            attributeType = attributePointerType;
        } else if (ctx.attributeSize() != null) {
            StabsScript.AttributeSizeType attributeSizeType = new StabsScript.AttributeSizeType();
            attributeSizeType.size = Integer.parseInt(ctx.attributeSize().number().getText());

            attributeType = attributeSizeType;
        } else if (ctx.attributeString() != null) {
            attributeType = new StabsScript.AttributeStringType();
        } else if (ctx.attributeVector() != null) {
            attributeType = new StabsScript.AttributeVectorType();
        }

        switch (Integer.parseInt(ctx.number().getText())) {
            case 1:
            case 4:
            case 15:
            case 29:
                attributeType.builtinType = StabsScript.AttributeType.BuiltinType.Int32;
                break;
            case 2:
            case 27:
                attributeType.builtinType = StabsScript.AttributeType.BuiltinType.Char;
                break;
            case 3:
            case 28:
                attributeType.builtinType = StabsScript.AttributeType.BuiltinType.Short;
                break;
            case 5:
                attributeType.builtinType = StabsScript.AttributeType.BuiltinType.UnsignedChar;
                break;
            case 6:
            case 20:
                attributeType.builtinType = StabsScript.AttributeType.BuiltinType.Char;
                break;
            case 7:
                attributeType.builtinType = StabsScript.AttributeType.BuiltinType.UnsignedShort;
                break;
            case 8:
            case 9:
            case 10:
                attributeType.builtinType = StabsScript.AttributeType.BuiltinType.UnsignedInt32;
                break;
            case 11:
                attributeType.builtinType = StabsScript.AttributeType.BuiltinType.Void;
                break;
            case 12:
            case 17:
                attributeType.builtinType = StabsScript.AttributeType.BuiltinType.Float;
                break;
            case 13:
            case 14:
            case 18:
                attributeType.builtinType = StabsScript.AttributeType.BuiltinType.Double;
                break;
            case 16:
                attributeType.builtinType = StabsScript.AttributeType.BuiltinType.Boolean32;
                break;
            case 19:
                attributeType.builtinType = StabsScript.AttributeType.BuiltinType.String;
                break;
            case 21:
                attributeType.builtinType = StabsScript.AttributeType.BuiltinType.Boolean8;
                break;
            case 22:
                attributeType.builtinType = StabsScript.AttributeType.BuiltinType.Boolean16;
                break;
            case 23:
            case 24:
                attributeType.builtinType = StabsScript.AttributeType.BuiltinType.Boolean32;
                break;
            case 25:
                attributeType.builtinType = StabsScript.AttributeType.BuiltinType.Complex;
                break;
            case 26:
                attributeType.builtinType = StabsScript.AttributeType.BuiltinType.DoubleComplex;
                break;
            case 30:
                attributeType.builtinType = StabsScript.AttributeType.BuiltinType.WChar;
                break;
            case 31:
            case 34:
                attributeType.builtinType = StabsScript.AttributeType.BuiltinType.Int64;
                break;
            case 32:
                attributeType.builtinType = StabsScript.AttributeType.BuiltinType.UnsignedInt64;
                break;
            case 33:
                attributeType.builtinType = StabsScript.AttributeType.BuiltinType.Boolean64;
                break;
            default:
                break;
        }

        return attributeType;
    }

    @Override
    public StabsScript.ClassMethodType visitTypeDescriptionClassMethod(TypeDescriptionClassMethodContext ctx) {
        StabsScript.ClassMethodType classMethodType = new StabsScript.ClassMethodType();

        classMethodType.mangledSignature = ctx.classMethodMangledSignature() != null;
        classMethodType.signature = new ArrayList<>();

        boolean returnType = true;

        for (TypeContext typeContext : ctx.type()) {
            if (returnType) {
                classMethodType.type = (StabsScript.Type) visit(typeContext);
                returnType = false;
                continue;
            }

            classMethodType.signature.add((StabsScript.Type) visit(typeContext));
        }

        return classMethodType;
    }

    @Override
    public StabsScript.EnumType visitTypeDescriptionEnum(TypeDescriptionEnumContext ctx) {
        StabsScript.EnumType enumType = new StabsScript.EnumType();

        enumType.members = new ArrayList<>();

        for (EnumMemberContext memberContext : ctx.enumMember()) {
            enumType.members.add((Pair<String, Integer>) visit(memberContext));
        }

        return enumType;
    }

    @Override
    public Pair<String, Integer> visitEnumMember(EnumMemberContext ctx) {
        String key = ctx.identifier().getText();
        Integer value = Integer.parseInt(ctx.integer().getText());

        return Pair.of(key, value);
    }

    @Override
    public StabsScript.FunctionType visitTypeDescriptionFunction(TypeDescriptionFunctionContext ctx) {
        StabsScript.FunctionType functionType = new StabsScript.FunctionType();

        functionType.type = (StabsScript.Type) visit(ctx.type());

        return functionType;
    }

    @Override
    public StabsScript.NestedFunctionType visitTypeDescriptionNestedFunction(TypeDescriptionNestedFunctionContext ctx) {
        StabsScript.NestedFunctionType nestedFunctionType = new StabsScript.NestedFunctionType();

        nestedFunctionType.name = ctx.identifier(0).getText();
        nestedFunctionType.parentName = ctx.identifier(1).getText();

        return nestedFunctionType;
    }

    @Override
    public StabsScript.PointerType visitTypeDescriptionPointer(TypeDescriptionPointerContext ctx) {
        StabsScript.PointerType pointerType = new StabsScript.PointerType();
        
        pointerType.type = (StabsScript.Type) visit(ctx.type());

        return pointerType;
    }

    @Override
    public StabsScript.RangeType visitTypeDescriptionRange(TypeDescriptionRangeContext ctx) {
        StabsScript.RangeType rangeType = new StabsScript.RangeType();
        
        rangeType.type = (StabsScript.Type) visit(ctx.type());

        String minValue = ctx.integer(0).getText();
        String maxValue = ctx.integer(1).getText();

        if (minValue.length() > 1 && minValue.charAt(0) == '0') {
            rangeType.minValue = Long.parseUnsignedLong(minValue, 8);
        } else {
            rangeType.minValue = Long.parseLong(minValue);

            if (rangeType.minValue == -1L && !is64bit) {
                rangeType.minValue = 0xffffffffL;
            } else if (rangeType.minValue <= -128) {
                int valueByteSize = (64 - Long.numberOfLeadingZeros(~rangeType.minValue) + 7) / 8;

                if (valueByteSize <= 1) {
                    rangeType.minValue &= 0xffL;
                } else if (valueByteSize <= 2) {
                    rangeType.minValue &= 0xffffL;
                } else if (valueByteSize <= 4) {
                    rangeType.minValue &= 0xffffffffL;
                }
            }
        }

        if (maxValue.length() > 1 && maxValue.charAt(0) == '0') {
            rangeType.maxValue = Long.parseUnsignedLong(maxValue, 8);
        } else {
            rangeType.maxValue = Long.parseLong(maxValue);

            if (rangeType.maxValue == -1L && !is64bit) {
                rangeType.maxValue = 0xffffffffL;
            } else if (rangeType.maxValue <= -128) {
                int valueByteSize = (64 - Long.numberOfLeadingZeros(~rangeType.maxValue) + 7) / 8;

                if (valueByteSize <= 1) {
                    rangeType.maxValue &= 0xffL;
                } else if (valueByteSize <= 2) {
                    rangeType.maxValue &= 0xffffL;
                } else if (valueByteSize <= 4) {
                    rangeType.maxValue &= 0xffffffffL;
                }
            }
        }

        rangeType.isArray = false;

        return rangeType;
    }

    @Override
    public StabsScript.ReferenceType visitTypeDescriptionReference(TypeDescriptionReferenceContext ctx) {
        StabsScript.ReferenceType referenceType = new StabsScript.ReferenceType();
        
        referenceType.type = (StabsScript.Type) visit(ctx.type());

        return referenceType;
    }

    @Override
    public StabsScript.StructUnionClassType visitTypeDescriptionStructUnionClass(TypeDescriptionStructUnionClassContext ctx) {
        StabsScript.StructUnionClassType structUnionClassType = new StabsScript.StructUnionClassType();

        boolean isClass = ctx.classInheritanceInfo() != null || ctx.classVirtualInfo() != null;

        if (!isClass) {
            for (StructUnionClassMemberContext member : ctx.structUnionClassMember()) {
                if (
                    (member.structUnionClassMemberField() != null && member.structUnionClassMemberField().classAccessibility() != null)
                    || member.classMemberMethod() != null
                    || member.classMemberVirtualTable() != null
                ) {
                    isClass = true;
                    break;
                }
            }
        }

        switch (ctx.structUnionType().getText()) {
            case "s":
                structUnionClassType.specificType = isClass
                    ? StabsScript.StructUnionClassType.StructUnionClassSpecificType.Class
                    : StabsScript.StructUnionClassType.StructUnionClassSpecificType.Struct;
                break;
            case "u":
                structUnionClassType.specificType = isClass
                    ? StabsScript.StructUnionClassType.StructUnionClassSpecificType.UnionClass
                    : StabsScript.StructUnionClassType.StructUnionClassSpecificType.Union;
                break;
            default:
                break;
        }

        structUnionClassType.size = Integer.parseInt(ctx.number().getText());

        if (ctx.classInheritanceInfo() != null) {
            structUnionClassType.inheritanceInfo = new ArrayList<>();

            for (ClassInheritanceDataContext inheritanceData : ctx.classInheritanceInfo().classInheritanceData()) {
                structUnionClassType.inheritanceInfo.add((StabsScript.ClassInheritanceDataType) visit(inheritanceData));
            }
        }

        structUnionClassType.members = new ArrayList<>();

        for (StructUnionClassMemberContext member : ctx.structUnionClassMember()) {
            structUnionClassType.members.add((StabsScript.StructUnionClassMemberType) visit(member));
        }

        return structUnionClassType;
    }

    @Override
    public StabsScript.StructUnionClassMemberType visitStructUnionClassMember(StructUnionClassMemberContext ctx) {
        StabsScript.StructUnionClassMemberType structUnionClassMemberType = null;

        if (ctx.structUnionClassMemberField() != null) {
            structUnionClassMemberType = (StabsScript.StructUnionClassMemberFieldType) visit(ctx.structUnionClassMemberField());
        } else if (ctx.classMemberMethod() != null) {
            structUnionClassMemberType = (StabsScript.ClassMemberMethodType) visit(ctx.classMemberMethod());
        } else if (ctx.classMemberStaticField() != null) {
            structUnionClassMemberType = (StabsScript.ClassMemberStaticFieldType) visit(ctx.classMemberStaticField());
        } else if (ctx.classMemberVirtualTable() != null) {
            structUnionClassMemberType = (StabsScript.ClassMemberVirtualTableType) visit(ctx.classMemberVirtualTable());
        }

        structUnionClassMemberType.name = ctx.identifier().getText();

        return structUnionClassMemberType;
    }

    @Override
    public StabsScript.StructUnionClassMemberFieldType visitStructUnionClassMemberField(StructUnionClassMemberFieldContext ctx) {
        StabsScript.StructUnionClassMemberFieldType structUnionClassMemberFieldType = new StabsScript.StructUnionClassMemberFieldType();

        structUnionClassMemberFieldType.accessibility = StabsScript.ClassAccessibility.Undefined;

        if (ctx.classAccessibility() != null) {
            switch (ctx.classAccessibility().getText()) {
                case "0":
                    structUnionClassMemberFieldType.accessibility = StabsScript.ClassAccessibility.Private;
                    break;
                case "1":
                    structUnionClassMemberFieldType.accessibility = StabsScript.ClassAccessibility.Protected;
                    break;
                case "2":
                    structUnionClassMemberFieldType.accessibility = StabsScript.ClassAccessibility.Public;
                    break;
                default:
                    break;
            }
        }

        structUnionClassMemberFieldType.type = (StabsScript.Type) visitType(ctx.type());
        structUnionClassMemberFieldType.offset = Integer.parseInt(ctx.number(0).getText()) / 8;
        structUnionClassMemberFieldType.size = Integer.parseInt(ctx.number(1).getText()) / 8;

        return structUnionClassMemberFieldType;
    }

    @Override
    public StabsScript.ClassMemberMethodType visitClassMemberMethod(ClassMemberMethodContext ctx) {
        StabsScript.ClassMemberMethodType classMemberMethodType = new StabsScript.ClassMemberMethodType();

        classMemberMethodType.overloads = new ArrayList<>();

        for (ClassMemberMethodOverloadContext overload : ctx.classMemberMethodOverload()) {
            classMemberMethodType.overloads.add((StabsScript.ClassMemberMethodOverloadType) visit(overload));
        }

        return classMemberMethodType;
    }

    @Override
    public StabsScript.ClassMemberMethodOverloadType visitClassMemberMethodOverload(ClassMemberMethodOverloadContext ctx) {
        StabsScript.ClassMemberMethodOverloadType classMemberMethodOverloadType = new StabsScript.ClassMemberMethodOverloadType();

        classMemberMethodOverloadType.type = (StabsScript.Type) visit(ctx.type());
        
        if (ctx.identifier() != null) {
            classMemberMethodOverloadType.mangledSignature = ctx.identifier().getText();
        }

        switch (ctx.classMemberMethodInfo().classAccessibility().getText()) {
            case "0":
                classMemberMethodOverloadType.accessibility = StabsScript.ClassAccessibility.Private;
                break;
            case "1":
                classMemberMethodOverloadType.accessibility = StabsScript.ClassAccessibility.Protected;
                break;
            case "2":
                classMemberMethodOverloadType.accessibility = StabsScript.ClassAccessibility.Public;
                break;
            default:
                break;
        }

        switch (ctx.classMemberMethodInfo().classMemberMethodModifier().getText()) {
            case "A":
                classMemberMethodOverloadType.modifier = StabsScript.ClassMemberMethodOverloadType.MethodModifier.Normal;
                break;
            case "B":
                classMemberMethodOverloadType.modifier = StabsScript.ClassMemberMethodOverloadType.MethodModifier.Const;
                break;
            case "C":
                classMemberMethodOverloadType.modifier = StabsScript.ClassMemberMethodOverloadType.MethodModifier.Volatile;
                break;
            case "D":
                classMemberMethodOverloadType.modifier = StabsScript.ClassMemberMethodOverloadType.MethodModifier.ConstVolatile;
                break;
            default:
                break;
        }

        if (ctx.classMemberMethodInfo().classMemberMethodStatic() != null) {
            classMemberMethodOverloadType.isStatic = true;
        }

        if (ctx.classMemberMethodInfo().classMemberMethodVirtualInfo() != null) {
            classMemberMethodOverloadType.isVirtual = true;
            classMemberMethodOverloadType.vTableIndex = Integer.parseInt(ctx.classMemberMethodInfo().classMemberMethodVirtualInfo().integer().getText()) & 0x7fffffff; // set the higher bit to zero
            classMemberMethodOverloadType.baseClassType = (StabsScript.Type) visit(ctx.classMemberMethodInfo().classMemberMethodVirtualInfo().type());
        }

        return classMemberMethodOverloadType;
    }

    @Override
    public StabsScript.ClassMemberStaticFieldType visitClassMemberStaticField(ClassMemberStaticFieldContext ctx) {
        StabsScript.ClassMemberStaticFieldType classMemberStaticFieldType = new StabsScript.ClassMemberStaticFieldType();

        classMemberStaticFieldType.accessibility = StabsScript.ClassAccessibility.Private;

        if (ctx.classAccessibility() != null) {
            switch (ctx.classAccessibility().getText()) {
                case "0":
                    classMemberStaticFieldType.accessibility = StabsScript.ClassAccessibility.Private;
                    break;
                case "1":
                    classMemberStaticFieldType.accessibility = StabsScript.ClassAccessibility.Protected;
                    break;
                case "2":
                    classMemberStaticFieldType.accessibility = StabsScript.ClassAccessibility.Public;
                    break;
                default:
                    break;
            }
        }

        classMemberStaticFieldType.type = (StabsScript.Type) visit(ctx.type());
        classMemberStaticFieldType.mangledName = ctx.identifier().getText();

        return classMemberStaticFieldType;
    }

    @Override
    public StabsScript.ClassMemberVirtualTableType visitClassMemberVirtualTable(ClassMemberVirtualTableContext ctx) {
        StabsScript.ClassMemberVirtualTableType classMemberVirtualTableType = new StabsScript.ClassMemberVirtualTableType();

        classMemberVirtualTableType.classType = (StabsScript.Type) visit(ctx.type(0));
        classMemberVirtualTableType.type = (StabsScript.Type) visit(ctx.type(1));

        classMemberVirtualTableType.offset = Integer.parseInt(ctx.integer().getText()) / 8;

        return classMemberVirtualTableType;
    }

    @Override
    public StabsScript.XrefType visitTypeDescriptionXref(TypeDescriptionXrefContext ctx) {
        StabsScript.XrefType xrefType = new StabsScript.XrefType();

        xrefType.targetType = StabsScript.XrefType.TargetType.Undefined;

        switch (ctx.xrefType().getText()) {
            case "e":
                xrefType.targetType = StabsScript.XrefType.TargetType.Enum;
                break;
            case "s":
                xrefType.targetType = StabsScript.XrefType.TargetType.Struct;
                break;
            case "u":
                xrefType.targetType = StabsScript.XrefType.TargetType.Union;
                break;
            default:
                break;
        }

        xrefType.targetName = ctx.identifier().getText();

        return xrefType;
    }

    @Override
    public StabsScript.Type visitTypeDescription(TypeDescriptionContext ctx) {
        StabsScript.Type typeDescription = (StabsScript.Type) visit(ctx.getChild(1));

        return typeDescription;
    }

    @Override
    public Pair<Integer, Integer> visitTypeID(TypeIDContext ctx) {
        int i = 0;
        int j = 0;

        if (ctx.simpleTypeID() != null) {
            i = -1;
            j = Integer.parseInt(ctx.simpleTypeID().getText());
        } else if (ctx.compositeTypeID() != null) {
            i = Integer.parseInt(ctx.compositeTypeID().number(0).getText());
            j = Integer.parseInt(ctx.compositeTypeID().number(1).getText());
        }

        return Pair.of(i, j);
    }

    @Override
    public StabsScript.Type visitType(TypeContext ctx) {
        Pair<Integer, Integer> internalId = (Pair<Integer, Integer>) visit(ctx.typeID());

        StabsScript.Type type = null;

        if (ctx.typeDescription() != null) {
            type = (StabsScript.Type) visit(ctx.typeDescription());

            if (type.id != null) {
                StabsScript.Type typeDescription = new StabsScript.Type();
                typeDescription.type = type;
                type = typeDescription;
            }

            type.id = script.getId(internalId);

            script.putType(type);
        } else {
            type = new StabsScript.Type();
            type.id = script.getId(internalId);
        }

        return type;
    }

    @Override
    public StabsScript.Symbol visitSymbol(SymbolContext ctx) {
        StabsScript.Symbol symbol = new StabsScript.Symbol();

        symbol.typeValue = symbolTypeValue;
        symbol.address = symbolAddress;
        symbol.value = symbolValue;
        symbol.name = ctx.identifier().getText();
        symbol.type = (StabsScript.Type) visit(ctx.type());

        if (ctx.symbolType() != null && ctx.symbolType().symbolTypeReferenceParameter() != null) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.ReferenceParameter;
        } else if (ctx.symbolType() != null && ctx.symbolType().symbolTypeGlobalFunction() != null) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.GlobalFunction;
        } else if (ctx.symbolType() != null && ctx.symbolType().symbolTypeLocalFunction() != null) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.LocalFunction;
        } else if (ctx.symbolType() != null && ctx.symbolType().symbolTypeGlobalVariable() != null) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.GlobalVariable;
        } else if (ctx.symbolType() != null && ctx.symbolType().symbolTypeParameterOrFunctionPrototype() != null && symbolTypeValue.equals(StabsScript.StabSymbolTypes.N_FUN)) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.FunctionPrototype;
        } else if (ctx.symbolType() != null && ctx.symbolType().symbolTypeParameterOrFunctionPrototype() != null && symbolTypeValue.equals(StabsScript.StabSymbolTypes.N_RSYM)) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.RegisterParameter;
        } else if (ctx.symbolType() != null && ctx.symbolType().symbolTypeStackParameter() != null) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.StackParameter;
        } else if (ctx.symbolType() != null && ctx.symbolType().symbolTypeRegisterVariable() != null) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.RegisterVariable;
        } else if (ctx.symbolType() != null && ctx.symbolType().symbolTypeStaticFileVariable() != null) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.StaticFileVariable;
        } else if (ctx.symbolType() != null && (ctx.symbolType().symbolTypeTagged() != null || ctx.symbolType().symbolTypeTaggedTypedef() != null)) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.TaggedType;
        } else if (ctx.symbolType() != null && ctx.symbolType().symbolTypeTypedef() != null) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.Typedef;
        } else if (ctx.symbolType() != null && ctx.symbolType().symbolTypeStaticLocalVariable() != null) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.HeapVariable;
        } else if (ctx.symbolType() == null && symbolTypeValue.equals(StabsScript.StabSymbolTypes.N_LSYM)) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.StackVariable;
        } else {
            throw new RuntimeException(String.format("Unknown symbol type: %s", ctx.symbolType() != null ? ctx.symbolType().getText() : ctx.symbolType()));
        }

        script.putSymbol(symbol);

        return symbol;
    }
}
