parser grammar StabsParser;
options { tokenVocab=StabsLexer; }
@header {package stabs;}

symbol: identifier Colon symbolType? type;

symbolType:
    symbolTypeReferenceParameter
  | symbolTypeGlobalFunction
  | symbolTypeLocalFunction
  | symbolTypeGlobalVariable
  | symbolTypeParameterOrFunctionPrototype
  | symbolTypeStackParameter
  | symbolTypeRegisterVariable
  | symbolTypeStaticFileVariable
  | symbolTypeTaggedTypedef
  | symbolTypeTagged
  | symbolTypeTypedef
  | symbolTypeStaticLocalVariable;

symbolTypeReferenceParameter:           LowercaseA;
symbolTypeGlobalFunction:               UppercaseF;
symbolTypeLocalFunction:                LowercaseF;
symbolTypeGlobalVariable:               UppercaseG;
symbolTypeParameterOrFunctionPrototype: UppercaseP;
symbolTypeStackParameter:               LowercaseP;
symbolTypeRegisterVariable:             LowercaseR;
symbolTypeStaticFileVariable:           UppercaseS;
symbolTypeTaggedTypedef:                UppercaseT LowercaseT;
symbolTypeTagged:                       UppercaseT;
symbolTypeTypedef:                      LowercaseT;
symbolTypeStaticLocalVariable:          UppercaseV;

type: typeID typeDescription?;

typeID:          simpleTypeID | compositeTypeID;
simpleTypeID:    number;
compositeTypeID: ParenthesisLeft number Comma number ParenthesisRight;

typeDescription: Equals
  (
      type
    | typeDescriptionArray
    | typeDescriptionAttribute
    | typeDescriptionClassMethod
    | typeDescriptionEnum
    | typeDescriptionFunction
    | typeDescriptionPointer
    | typeDescriptionRange
    | typeDescriptionReference
    | typeDescriptionStructUnionClass
    | typeDescriptionXref
  );

typeDescriptionArray:            LowercaseA typeDescriptionRange type;
typeDescriptionAttribute:        At (attributeBoundary | attributePacked | attributePointer | attributeSize | attributeString | attributeVector) Semicolon Minus number Semicolon;
typeDescriptionClassMethod:      Hash classMethodMangledSignature? type (Comma type)* Semicolon;
typeDescriptionEnum:             LowercaseE enumMember* Semicolon;
typeDescriptionFunction:         LowercaseF type;
typeDescriptionNestedFunction:   LowercaseF type Comma identifier Comma identifier;
typeDescriptionPointer:          Asterisk type;
typeDescriptionRange:            LowercaseR type Semicolon integer Semicolon integer Semicolon;
typeDescriptionReference:        Ampersand type;
typeDescriptionStructUnionClass: structUnionType number classInheritanceInfo? structUnionClassMember* classVirtualInfo? Semicolon;
typeDescriptionXref:             LowercaseX xrefType identifier Colon;

attributeBoundary: LowercaseA integer;
attributePacked:   UppercaseP;
attributePointer:  LowercaseP integer;
attributeSize:     LowercaseS number;
attributeString:   UppercaseS;
attributeVector:   UppercaseV;

classInheritanceInfo:         Exclamation number Comma classInheritanceData+;
classInheritanceData:         boolean classAccessibility integer Comma type Semicolon;
classAccessibility:           Number0 | Number1 | Number2;
classMemberMethod:            Colon Colon classMemberMethodOverload+ Semicolon;
classMemberMethodOverload:    type Colon identifier? Semicolon classMemberMethodInfo;
classMemberMethodInfo:        classAccessibility classMemberMethodModifier (Dot | classMemberMethodStatic | Asterisk classMemberMethodVirtualInfo);
classMemberMethodModifier:    UppercaseA | UppercaseB | UppercaseC | UppercaseD;
classMemberMethodStatic:      Question;
classMemberMethodVirtualInfo: integer Semicolon type Semicolon;
classMemberStaticField:       Colon (Slash classAccessibility)? type Colon identifier Semicolon;
classMemberVirtualTable:      type Colon type Comma integer Semicolon;

classMethodMangledSignature:  Hash;

enumMember: identifier Colon integer Comma;

structUnionType: LowercaseS | LowercaseU;

structUnionClassMember:      identifier (structUnionClassMemberField | classMemberMethod | classMemberStaticField | classMemberVirtualTable);
structUnionClassMemberField: Colon (Slash classAccessibility)? type Comma number Comma number Semicolon;

classVirtualInfo: Semicolon Tilde Percent type;

xrefType: LowercaseE | LowercaseS | LowercaseU;

identifier:
  (
      letter
    | digit
    | Ampersand
    | AngleBracketLeft
    | AngleBracketRight
    | Asterisk
    | Comma
    | Dot
    | Space
    | Underscore
  )+;

letter: UppercaseA
  | UppercaseB
  | UppercaseC
  | UppercaseD
  | UppercaseE
  | UppercaseF
  | UppercaseG
  | UppercaseH
  | UppercaseI
  | UppercaseJ
  | UppercaseK
  | UppercaseL
  | UppercaseM
  | UppercaseN
  | UppercaseO
  | UppercaseP
  | UppercaseQ
  | UppercaseR
  | UppercaseS
  | UppercaseT
  | UppercaseU
  | UppercaseV
  | UppercaseW
  | UppercaseX
  | UppercaseY
  | UppercaseZ
  | LowercaseA
  | LowercaseB
  | LowercaseC
  | LowercaseD
  | LowercaseE
  | LowercaseF
  | LowercaseG
  | LowercaseH
  | LowercaseI
  | LowercaseJ
  | LowercaseK
  | LowercaseL
  | LowercaseM
  | LowercaseN
  | LowercaseO
  | LowercaseP
  | LowercaseQ
  | LowercaseR
  | LowercaseS
  | LowercaseT
  | LowercaseU
  | LowercaseV
  | LowercaseW
  | LowercaseX
  | LowercaseY
  | LowercaseZ;

boolean: Number0 | Number1;

integer: (Plus | Minus)? number;

number: digit+;

digit: Number0
  | Number1
  | Number2
  | Number3
  | Number4
  | Number5
  | Number6
  | Number7
  | Number8
  | Number9;
