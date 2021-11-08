parser grammar StabsParser;
options {tokenVocab = StabsLexer;}
@header {package stabs;}

arrayType:    TypeDescArray rangeType type ;
enumMember:   EnumIdentifier EnumColon EnumInt EnumComma ;
enumType:     TypeDescEnum enumMember* EnumSemicolon ;
functionType: TypeDescFunction type ;
pointerType:  TypeDescPointer type ;
rangeType:    TypeDescRange type RangeSemicolon RangeInt RangeSemicolon RangeInt RangeSemicolon ;
structMember: StructIdentifier StructColon type StructFirstComma StructInt StructSecondComma StructInt StructSemicolon ;
structType:   (TypeDescStruct|TypeDescUnion) StructInt structMember* StructSemicolon ;
xrefType:     TypeDescXref (XrefDescEnum|XrefDescStruct|XrefDescUnion) XrefIdentifier XrefColon ;

typeDesc: type
        | arrayType
        | enumType
        | functionType
        | pointerType
        | rangeType
        | structType
        | xrefType
        ;
typeNum:  TypeNumLeftBrace? TypeNumInt TypeNumComma TypeNumInt TypeNumRightBrace ;
type:     typeNum (TypeEquals typeDesc)? ;

symbol: SymbolName SymbolColon
        ( SymbolDescStackVariable
        | SymbolDescReferenceParameter
        | SymbolDescGlobalFunction
        | SymbolDescLocalFunction
        | SymbolDescGlobalVariable
        | SymbolDescRegisterParameter
        | SymbolDescStackParameter
        | SymbolDescRegisterVariable
        | SymbolDescStaticFileVariable
        | SymbolDescTaggedType
        | SymbolDescTypedefedType
        | SymbolDescStaticLocalVariable
        )
        type ;
