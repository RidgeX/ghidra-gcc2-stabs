// Generated from c:/Users/tiagocost/ghidra_scripts/stabs/StabsParser.g4 by ANTLR 4.13.1
package stabs;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link StabsParser}.
 */
public interface StabsParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link StabsParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterSymbol(StabsParser.SymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitSymbol(StabsParser.SymbolContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#symbolType}.
	 * @param ctx the parse tree
	 */
	void enterSymbolType(StabsParser.SymbolTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#symbolType}.
	 * @param ctx the parse tree
	 */
	void exitSymbolType(StabsParser.SymbolTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#symbolTypeReferenceParameter}.
	 * @param ctx the parse tree
	 */
	void enterSymbolTypeReferenceParameter(StabsParser.SymbolTypeReferenceParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#symbolTypeReferenceParameter}.
	 * @param ctx the parse tree
	 */
	void exitSymbolTypeReferenceParameter(StabsParser.SymbolTypeReferenceParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#symbolTypeGlobalFunction}.
	 * @param ctx the parse tree
	 */
	void enterSymbolTypeGlobalFunction(StabsParser.SymbolTypeGlobalFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#symbolTypeGlobalFunction}.
	 * @param ctx the parse tree
	 */
	void exitSymbolTypeGlobalFunction(StabsParser.SymbolTypeGlobalFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#symbolTypeLocalFunction}.
	 * @param ctx the parse tree
	 */
	void enterSymbolTypeLocalFunction(StabsParser.SymbolTypeLocalFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#symbolTypeLocalFunction}.
	 * @param ctx the parse tree
	 */
	void exitSymbolTypeLocalFunction(StabsParser.SymbolTypeLocalFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#symbolTypeGlobalVariable}.
	 * @param ctx the parse tree
	 */
	void enterSymbolTypeGlobalVariable(StabsParser.SymbolTypeGlobalVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#symbolTypeGlobalVariable}.
	 * @param ctx the parse tree
	 */
	void exitSymbolTypeGlobalVariable(StabsParser.SymbolTypeGlobalVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#symbolTypeParameterOrFunctionPrototype}.
	 * @param ctx the parse tree
	 */
	void enterSymbolTypeParameterOrFunctionPrototype(StabsParser.SymbolTypeParameterOrFunctionPrototypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#symbolTypeParameterOrFunctionPrototype}.
	 * @param ctx the parse tree
	 */
	void exitSymbolTypeParameterOrFunctionPrototype(StabsParser.SymbolTypeParameterOrFunctionPrototypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#symbolTypeStackParameter}.
	 * @param ctx the parse tree
	 */
	void enterSymbolTypeStackParameter(StabsParser.SymbolTypeStackParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#symbolTypeStackParameter}.
	 * @param ctx the parse tree
	 */
	void exitSymbolTypeStackParameter(StabsParser.SymbolTypeStackParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#symbolTypeRegisterVariable}.
	 * @param ctx the parse tree
	 */
	void enterSymbolTypeRegisterVariable(StabsParser.SymbolTypeRegisterVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#symbolTypeRegisterVariable}.
	 * @param ctx the parse tree
	 */
	void exitSymbolTypeRegisterVariable(StabsParser.SymbolTypeRegisterVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#symbolTypeStaticFileVariable}.
	 * @param ctx the parse tree
	 */
	void enterSymbolTypeStaticFileVariable(StabsParser.SymbolTypeStaticFileVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#symbolTypeStaticFileVariable}.
	 * @param ctx the parse tree
	 */
	void exitSymbolTypeStaticFileVariable(StabsParser.SymbolTypeStaticFileVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#symbolTypeTaggedTypedef}.
	 * @param ctx the parse tree
	 */
	void enterSymbolTypeTaggedTypedef(StabsParser.SymbolTypeTaggedTypedefContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#symbolTypeTaggedTypedef}.
	 * @param ctx the parse tree
	 */
	void exitSymbolTypeTaggedTypedef(StabsParser.SymbolTypeTaggedTypedefContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#symbolTypeTagged}.
	 * @param ctx the parse tree
	 */
	void enterSymbolTypeTagged(StabsParser.SymbolTypeTaggedContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#symbolTypeTagged}.
	 * @param ctx the parse tree
	 */
	void exitSymbolTypeTagged(StabsParser.SymbolTypeTaggedContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#symbolTypeTypedef}.
	 * @param ctx the parse tree
	 */
	void enterSymbolTypeTypedef(StabsParser.SymbolTypeTypedefContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#symbolTypeTypedef}.
	 * @param ctx the parse tree
	 */
	void exitSymbolTypeTypedef(StabsParser.SymbolTypeTypedefContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#symbolTypeStaticLocalVariable}.
	 * @param ctx the parse tree
	 */
	void enterSymbolTypeStaticLocalVariable(StabsParser.SymbolTypeStaticLocalVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#symbolTypeStaticLocalVariable}.
	 * @param ctx the parse tree
	 */
	void exitSymbolTypeStaticLocalVariable(StabsParser.SymbolTypeStaticLocalVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(StabsParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(StabsParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#typeID}.
	 * @param ctx the parse tree
	 */
	void enterTypeID(StabsParser.TypeIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#typeID}.
	 * @param ctx the parse tree
	 */
	void exitTypeID(StabsParser.TypeIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#simpleTypeID}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTypeID(StabsParser.SimpleTypeIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#simpleTypeID}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTypeID(StabsParser.SimpleTypeIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#compositeTypeID}.
	 * @param ctx the parse tree
	 */
	void enterCompositeTypeID(StabsParser.CompositeTypeIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#compositeTypeID}.
	 * @param ctx the parse tree
	 */
	void exitCompositeTypeID(StabsParser.CompositeTypeIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#typeDescription}.
	 * @param ctx the parse tree
	 */
	void enterTypeDescription(StabsParser.TypeDescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#typeDescription}.
	 * @param ctx the parse tree
	 */
	void exitTypeDescription(StabsParser.TypeDescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#typeDescriptionArray}.
	 * @param ctx the parse tree
	 */
	void enterTypeDescriptionArray(StabsParser.TypeDescriptionArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#typeDescriptionArray}.
	 * @param ctx the parse tree
	 */
	void exitTypeDescriptionArray(StabsParser.TypeDescriptionArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#typeDescriptionAttribute}.
	 * @param ctx the parse tree
	 */
	void enterTypeDescriptionAttribute(StabsParser.TypeDescriptionAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#typeDescriptionAttribute}.
	 * @param ctx the parse tree
	 */
	void exitTypeDescriptionAttribute(StabsParser.TypeDescriptionAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#typeDescriptionClassMethod}.
	 * @param ctx the parse tree
	 */
	void enterTypeDescriptionClassMethod(StabsParser.TypeDescriptionClassMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#typeDescriptionClassMethod}.
	 * @param ctx the parse tree
	 */
	void exitTypeDescriptionClassMethod(StabsParser.TypeDescriptionClassMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#typeDescriptionEnum}.
	 * @param ctx the parse tree
	 */
	void enterTypeDescriptionEnum(StabsParser.TypeDescriptionEnumContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#typeDescriptionEnum}.
	 * @param ctx the parse tree
	 */
	void exitTypeDescriptionEnum(StabsParser.TypeDescriptionEnumContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#typeDescriptionFunction}.
	 * @param ctx the parse tree
	 */
	void enterTypeDescriptionFunction(StabsParser.TypeDescriptionFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#typeDescriptionFunction}.
	 * @param ctx the parse tree
	 */
	void exitTypeDescriptionFunction(StabsParser.TypeDescriptionFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#typeDescriptionNestedFunction}.
	 * @param ctx the parse tree
	 */
	void enterTypeDescriptionNestedFunction(StabsParser.TypeDescriptionNestedFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#typeDescriptionNestedFunction}.
	 * @param ctx the parse tree
	 */
	void exitTypeDescriptionNestedFunction(StabsParser.TypeDescriptionNestedFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#typeDescriptionPointer}.
	 * @param ctx the parse tree
	 */
	void enterTypeDescriptionPointer(StabsParser.TypeDescriptionPointerContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#typeDescriptionPointer}.
	 * @param ctx the parse tree
	 */
	void exitTypeDescriptionPointer(StabsParser.TypeDescriptionPointerContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#typeDescriptionRange}.
	 * @param ctx the parse tree
	 */
	void enterTypeDescriptionRange(StabsParser.TypeDescriptionRangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#typeDescriptionRange}.
	 * @param ctx the parse tree
	 */
	void exitTypeDescriptionRange(StabsParser.TypeDescriptionRangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#typeDescriptionReference}.
	 * @param ctx the parse tree
	 */
	void enterTypeDescriptionReference(StabsParser.TypeDescriptionReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#typeDescriptionReference}.
	 * @param ctx the parse tree
	 */
	void exitTypeDescriptionReference(StabsParser.TypeDescriptionReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#typeDescriptionStructUnionClass}.
	 * @param ctx the parse tree
	 */
	void enterTypeDescriptionStructUnionClass(StabsParser.TypeDescriptionStructUnionClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#typeDescriptionStructUnionClass}.
	 * @param ctx the parse tree
	 */
	void exitTypeDescriptionStructUnionClass(StabsParser.TypeDescriptionStructUnionClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#typeDescriptionXref}.
	 * @param ctx the parse tree
	 */
	void enterTypeDescriptionXref(StabsParser.TypeDescriptionXrefContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#typeDescriptionXref}.
	 * @param ctx the parse tree
	 */
	void exitTypeDescriptionXref(StabsParser.TypeDescriptionXrefContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#attributeBoundary}.
	 * @param ctx the parse tree
	 */
	void enterAttributeBoundary(StabsParser.AttributeBoundaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#attributeBoundary}.
	 * @param ctx the parse tree
	 */
	void exitAttributeBoundary(StabsParser.AttributeBoundaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#attributePacked}.
	 * @param ctx the parse tree
	 */
	void enterAttributePacked(StabsParser.AttributePackedContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#attributePacked}.
	 * @param ctx the parse tree
	 */
	void exitAttributePacked(StabsParser.AttributePackedContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#attributePointer}.
	 * @param ctx the parse tree
	 */
	void enterAttributePointer(StabsParser.AttributePointerContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#attributePointer}.
	 * @param ctx the parse tree
	 */
	void exitAttributePointer(StabsParser.AttributePointerContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#attributeSize}.
	 * @param ctx the parse tree
	 */
	void enterAttributeSize(StabsParser.AttributeSizeContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#attributeSize}.
	 * @param ctx the parse tree
	 */
	void exitAttributeSize(StabsParser.AttributeSizeContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#attributeString}.
	 * @param ctx the parse tree
	 */
	void enterAttributeString(StabsParser.AttributeStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#attributeString}.
	 * @param ctx the parse tree
	 */
	void exitAttributeString(StabsParser.AttributeStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#attributeVector}.
	 * @param ctx the parse tree
	 */
	void enterAttributeVector(StabsParser.AttributeVectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#attributeVector}.
	 * @param ctx the parse tree
	 */
	void exitAttributeVector(StabsParser.AttributeVectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#classInheritanceInfo}.
	 * @param ctx the parse tree
	 */
	void enterClassInheritanceInfo(StabsParser.ClassInheritanceInfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#classInheritanceInfo}.
	 * @param ctx the parse tree
	 */
	void exitClassInheritanceInfo(StabsParser.ClassInheritanceInfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#classInheritanceData}.
	 * @param ctx the parse tree
	 */
	void enterClassInheritanceData(StabsParser.ClassInheritanceDataContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#classInheritanceData}.
	 * @param ctx the parse tree
	 */
	void exitClassInheritanceData(StabsParser.ClassInheritanceDataContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#classAccessibility}.
	 * @param ctx the parse tree
	 */
	void enterClassAccessibility(StabsParser.ClassAccessibilityContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#classAccessibility}.
	 * @param ctx the parse tree
	 */
	void exitClassAccessibility(StabsParser.ClassAccessibilityContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#classMemberMethod}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberMethod(StabsParser.ClassMemberMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#classMemberMethod}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberMethod(StabsParser.ClassMemberMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#classMemberMethodOverload}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberMethodOverload(StabsParser.ClassMemberMethodOverloadContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#classMemberMethodOverload}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberMethodOverload(StabsParser.ClassMemberMethodOverloadContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#classMemberMethodInfo}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberMethodInfo(StabsParser.ClassMemberMethodInfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#classMemberMethodInfo}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberMethodInfo(StabsParser.ClassMemberMethodInfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#classMemberMethodModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberMethodModifier(StabsParser.ClassMemberMethodModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#classMemberMethodModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberMethodModifier(StabsParser.ClassMemberMethodModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#classMemberMethodStatic}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberMethodStatic(StabsParser.ClassMemberMethodStaticContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#classMemberMethodStatic}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberMethodStatic(StabsParser.ClassMemberMethodStaticContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#classMemberMethodVirtualInfo}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberMethodVirtualInfo(StabsParser.ClassMemberMethodVirtualInfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#classMemberMethodVirtualInfo}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberMethodVirtualInfo(StabsParser.ClassMemberMethodVirtualInfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#classMemberStaticField}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberStaticField(StabsParser.ClassMemberStaticFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#classMemberStaticField}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberStaticField(StabsParser.ClassMemberStaticFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#classMemberVirtualTable}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberVirtualTable(StabsParser.ClassMemberVirtualTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#classMemberVirtualTable}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberVirtualTable(StabsParser.ClassMemberVirtualTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#classMethodMangledSignature}.
	 * @param ctx the parse tree
	 */
	void enterClassMethodMangledSignature(StabsParser.ClassMethodMangledSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#classMethodMangledSignature}.
	 * @param ctx the parse tree
	 */
	void exitClassMethodMangledSignature(StabsParser.ClassMethodMangledSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#enumMember}.
	 * @param ctx the parse tree
	 */
	void enterEnumMember(StabsParser.EnumMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#enumMember}.
	 * @param ctx the parse tree
	 */
	void exitEnumMember(StabsParser.EnumMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#structUnionType}.
	 * @param ctx the parse tree
	 */
	void enterStructUnionType(StabsParser.StructUnionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#structUnionType}.
	 * @param ctx the parse tree
	 */
	void exitStructUnionType(StabsParser.StructUnionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#structUnionClassMember}.
	 * @param ctx the parse tree
	 */
	void enterStructUnionClassMember(StabsParser.StructUnionClassMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#structUnionClassMember}.
	 * @param ctx the parse tree
	 */
	void exitStructUnionClassMember(StabsParser.StructUnionClassMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#structUnionClassMemberField}.
	 * @param ctx the parse tree
	 */
	void enterStructUnionClassMemberField(StabsParser.StructUnionClassMemberFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#structUnionClassMemberField}.
	 * @param ctx the parse tree
	 */
	void exitStructUnionClassMemberField(StabsParser.StructUnionClassMemberFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#classVirtualInfo}.
	 * @param ctx the parse tree
	 */
	void enterClassVirtualInfo(StabsParser.ClassVirtualInfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#classVirtualInfo}.
	 * @param ctx the parse tree
	 */
	void exitClassVirtualInfo(StabsParser.ClassVirtualInfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#xrefType}.
	 * @param ctx the parse tree
	 */
	void enterXrefType(StabsParser.XrefTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#xrefType}.
	 * @param ctx the parse tree
	 */
	void exitXrefType(StabsParser.XrefTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(StabsParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(StabsParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#letter}.
	 * @param ctx the parse tree
	 */
	void enterLetter(StabsParser.LetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#letter}.
	 * @param ctx the parse tree
	 */
	void exitLetter(StabsParser.LetterContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#boolean}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(StabsParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#boolean}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(StabsParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(StabsParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(StabsParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(StabsParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(StabsParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link StabsParser#digit}.
	 * @param ctx the parse tree
	 */
	void enterDigit(StabsParser.DigitContext ctx);
	/**
	 * Exit a parse tree produced by {@link StabsParser#digit}.
	 * @param ctx the parse tree
	 */
	void exitDigit(StabsParser.DigitContext ctx);
}