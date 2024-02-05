import java.util.ArrayList;

import org.apache.commons.lang3.tuple.Pair;

import ghidra.program.model.address.Address;
import stabs.StabsParser.*;
import stabs.StabsParserBaseVisitor;

@SuppressWarnings("unchecked")
public class StabsVisitor extends StabsParserBaseVisitor<Object> {
    private StabsScript script;
    private Integer symbolTypeValue;
    private Address symbolAddress;
    private Integer symbolValue;

    public StabsVisitor(StabsScript script, Integer symbolTypeValue, Address symbolAddress, int symbolValue) {
        this.script = script;
        this.symbolTypeValue = symbolTypeValue;
        this.symbolAddress = symbolAddress;
        this.symbolValue = symbolValue;
    }

    @Override
    public StabsScript.ArrayType visitArrayType(ArrayTypeContext ctx) {
        StabsScript.ArrayType arrayType = new StabsScript.ArrayType();

        arrayType.type = (StabsScript.Type) visit(ctx.type());
        arrayType.indexType = (StabsScript.RangeType) visit(ctx.rangeType());

        return arrayType;
    }

    @Override
    public Pair<String, Integer> visitEnumMember(EnumMemberContext ctx) {
        String key = ctx.EnumIdentifier().getText();
        Integer value = Integer.parseInt(ctx.EnumInt().getText());

        return Pair.of(key, value);
    }

    @Override
    public StabsScript.EnumType visitEnumType(EnumTypeContext ctx) {
        StabsScript.EnumType enumType = new StabsScript.EnumType();

        enumType.members = new ArrayList<>();

        for (EnumMemberContext memberContext : ctx.enumMember()) {
            enumType.members.add((Pair<String, Integer>) visit(memberContext));
        }

        return enumType;
    }

    @Override
    public StabsScript.FunctionType visitFunctionType(FunctionTypeContext ctx) {
        StabsScript.FunctionType functionType = new StabsScript.FunctionType();

        functionType.type = (StabsScript.Type) visit(ctx.type());

        return functionType;
    }

    @Override
    public StabsScript.NestedFunctionType visitNestedFunctionType(NestedFunctionTypeContext ctx) {
        StabsScript.NestedFunctionType nestedFunctionType = new StabsScript.NestedFunctionType();

        nestedFunctionType.name = ctx.NestedFunctionFirstIdentifier().getText();
        nestedFunctionType.parentName = ctx.NestedFunctionIdentifier().getText();

        return nestedFunctionType;
    }

    @Override
    public StabsScript.PointerType visitPointerType(PointerTypeContext ctx) {
        StabsScript.PointerType pointerType = new StabsScript.PointerType();
        
        pointerType.type = (StabsScript.Type) visit(ctx.type());

        return pointerType;
    }

    @Override
    public StabsScript.RangeType visitRangeType(RangeTypeContext ctx) {
        StabsScript.RangeType rangeType = new StabsScript.RangeType();
        
        rangeType.type = (StabsScript.Type) visit(ctx.type());
        rangeType.minValue = ctx.RangeInt(0).getText();
        rangeType.maxValue = ctx.RangeInt(1).getText();

        return rangeType;
    }

    @Override
    public StabsScript.StructUnionMemberType visitStructMember(StructMemberContext ctx) {
        StabsScript.StructUnionMemberType structUnionMemberType = new StabsScript.StructUnionMemberType();

        structUnionMemberType.type = (StabsScript.Type) visit(ctx.type());
        structUnionMemberType.name = ctx.StructIdentifier().getText();;
        structUnionMemberType.offset = Integer.parseInt(ctx.StructFirstInt().getText()) / 8;
        structUnionMemberType.size = Integer.parseInt(ctx.StructInt().getText()) / 8;;

        return structUnionMemberType;
    }

    @Override
    public StabsScript.StructUnionType visitStructType(StructTypeContext ctx) {
        StabsScript.StructUnionType structUnionType = new StabsScript.StructUnionType();
        
        structUnionType.specificType = StabsScript.StructUnionType.StructUnionSpecificType.Undefined;

        if (ctx.TypeDescStruct() != null) {
            structUnionType.specificType = StabsScript.StructUnionType.StructUnionSpecificType.Struct;
        } else if (ctx.TypeDescUnion() != null) {
            structUnionType.specificType = StabsScript.StructUnionType.StructUnionSpecificType.Union;
        }

        structUnionType.size = Integer.parseInt(ctx.StructInt().getText());
        structUnionType.members = new ArrayList<>();

        for (StructMemberContext memberContext : ctx.structMember()) {
            structUnionType.members.add((StabsScript.StructUnionMemberType) visit(memberContext));
        }

        return structUnionType;
    }

    @Override
    public StabsScript.XrefType visitXrefType(XrefTypeContext ctx) {
        StabsScript.XrefType xrefType = new StabsScript.XrefType();

        xrefType.targetType = StabsScript.XrefType.TargetType.Undefined;

        if (ctx.XrefDescEnum() != null) {
            xrefType.targetType = StabsScript.XrefType.TargetType.Enum;
        } else if (ctx.XrefDescStruct() != null) {
            xrefType.targetType = StabsScript.XrefType.TargetType.Struct;
        } else if (ctx.XrefDescUnion() != null) {
            xrefType.targetType = StabsScript.XrefType.TargetType.Union;
        }

        xrefType.targetName = ctx.XrefIdentifier().getText();

        return xrefType;
    }

    @Override
    public StabsScript.Type visitTypeDesc(TypeDescContext ctx) {
        StabsScript.Type typeDesc = (StabsScript.Type) visit(ctx.getChild(0));

        return typeDesc;
    }

    @Override
    public Pair<Integer, Integer> visitTypeNum(TypeNumContext ctx) {
        int i = Integer.parseInt(ctx.TypeNumInt(0).getText());
        int j = Integer.parseInt(ctx.TypeNumInt(1).getText());

        return Pair.of(i, j);
    }

    @Override
    public StabsScript.Type visitType(TypeContext ctx) {
        Pair<Integer, Integer> internalId = (Pair<Integer, Integer>) visit(ctx.typeNum());
        StabsScript.Type type = null;

        if (ctx.typeDesc() != null) {
            type = (StabsScript.Type) visit(ctx.typeDesc());
            
            if (type.id != null) {
                StabsScript.Type typeDesc = new StabsScript.Type();
                typeDesc.type = type;
                type = typeDesc;
            }

            type.id = script.getId(internalId);
            
            script.putType(type);
        } else if (ctx.nestedFunctionType() != null) {
            type = (StabsScript.NestedFunctionType) visit(ctx.nestedFunctionType());
            
            type.type = new StabsScript.Type();
            type.type.id = script.getId(internalId);
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
        symbol.name = ctx.SymbolName().getText();
        symbol.type = (StabsScript.Type) visit(ctx.type());

        if (ctx.SymbolDescStackVariable() != null) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.StackVariable;
        } else if (ctx.SymbolDescReferenceParameter() != null) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.ReferenceParameter;
        } else if (ctx.SymbolDescGlobalFunction() != null) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.GlobalFunction;
        } else if (ctx.SymbolDescLocalFunction() != null && ctx.type().nestedFunctionType() == null) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.LocalFunction;
        } else if (ctx.SymbolDescLocalFunction() != null && ctx.type().nestedFunctionType() != null) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.NestedFunction;
        } else if (ctx.SymbolDescGlobalVariable() != null) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.GlobalVariable;
        } else if (ctx.SymbolDescRegisterParameterOrFunctionPrototype() != null && symbolTypeValue.equals(StabsScript.StabSymbolTypes.N_FUN)) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.FunctionPrototype;
        } else if (ctx.SymbolDescRegisterParameterOrFunctionPrototype() != null && symbolTypeValue.equals(StabsScript.StabSymbolTypes.N_RSYM)) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.RegisterParameter;
        } else if (ctx.SymbolDescStackParameter() != null) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.StackParameter;
        } else if (ctx.SymbolDescRegisterVariable() != null) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.RegisterVariable;
        } else if (ctx.SymbolDescStaticFileVariable() != null) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.StaticFileVariable;
        } else if (ctx.SymbolDescTaggedType() != null) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.TaggedType;
        } else if (ctx.SymbolDescTypedefedType() != null) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.Typedef;
        } else if (ctx.SymbolDescStaticLocalVariable() != null) {
            symbol.symbolType = StabsScript.Symbol.SymbolType.HeapVariable;
        }

        script.putSymbol(symbol);
        return symbol;
    }
}
