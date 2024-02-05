lexer grammar StabsLexer;
@header {package stabs;}

SymbolName:  ~':'+ ;
SymbolColon: ':' -> mode(ModeSymbolDesc) ;

mode ModeSymbolDesc;
SymbolDescStackVariable:       '(' -> mode(ModeTypeDesc), pushMode(ModeTypeNum) ;
SymbolDescReferenceParameter:  'a' -> mode(ModeTypeDesc) ;
SymbolDescGlobalFunction:      'F' -> mode(ModeTypeDesc) ;
SymbolDescLocalFunction:       'f' -> mode(ModeTypeDesc) ;
SymbolDescGlobalVariable:      'G' -> mode(ModeTypeDesc) ;
SymbolDescRegisterParameterOrFunctionPrototype: 'P' -> mode(ModeTypeDesc) ;
SymbolDescStackParameter:      'p' -> mode(ModeTypeDesc) ;
SymbolDescRegisterVariable:    'r' -> mode(ModeTypeDesc) ;
SymbolDescStaticFileVariable:  'S' -> mode(ModeTypeDesc) ;
SymbolDescTaggedType:          'T' -> mode(ModeTypeDesc) ;
SymbolDescTypedefedType:       't' -> mode(ModeTypeDesc) ;
SymbolDescStaticLocalVariable: 'V' -> mode(ModeTypeDesc) ;

mode ModeTypeDesc;
TypeNumLeftBrace: '(' -> pushMode(ModeTypeNum) ;
TypeEquals:       '=' ;
TypeDescArray:    'a' ;
TypeDescEnum:     'e' -> pushMode(ModeEnumType) ;
TypeDescFunction: 'f' ;
TypeDescPointer:  '*' ;
TypeDescRange:    'r' ;
TypeDescStruct:   's' -> pushMode(ModeStructType) ;
TypeDescUnion:    'u' -> pushMode(ModeStructType) ;
TypeDescXref:     'x' -> pushMode(ModeXrefDesc) ;
RangeSemicolon:   ';' ;
RangeInt:         INT ;
StrucOrNestedFunctiontFirstComma: ',' -> mode(ModeStructOrNestedFunction) ;

mode ModeTypeNum;
TypeNumInt:        INT ;
TypeNumComma:      ',';
TypeNumRightBrace: ')' -> popMode ;

mode ModeEnumType;
EnumIdentifier: ID ;
EnumColon:      ':' ;
EnumInt:        INT ;
EnumComma:      ',' ;
EnumSemicolon:  ';' -> popMode ;

mode ModeStructType;
StructIdentifier:  ID ;
StructColon:       ':' -> pushMode(ModeTypeDesc) ;
StructSecondComma: ',' -> pushMode(ModeStructType) ;
StructInt:         INT ;
StructSemicolon:   ';' -> popMode ;

mode ModeXrefDesc;
XrefDescEnum:   'e' -> mode(ModeXrefType) ;
XrefDescStruct: 's' -> mode(ModeXrefType) ;
XrefDescUnion:  'u' -> mode(ModeXrefType) ;

mode ModeXrefType;
XrefIdentifier: ID ;
XrefColon:      ':' -> popMode ;

mode ModeStructOrNestedFunction;
StructFirstInt: INT -> popMode ;
NestedFunctionFirstIdentifier: ID -> mode(ModeNestedFunction) ;

mode ModeNestedFunction;
NestedFunctionIdentifier: ID ;
NestedFunctionSecondComma: ',' ;

fragment IDStart: [A-Za-z_] ;
fragment ID:  [A-Za-z_][0-9A-Za-z_]* ;
fragment INT: '-'? [0-9]+ ;