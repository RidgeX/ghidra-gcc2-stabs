// Generated from c:/Users/tiagocost/ghidra_scripts/stabs/StabsParser.g4 by ANTLR 4.13.1
package stabs;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link StabsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface StabsParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link StabsParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbol(StabsParser.SymbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#symbolType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolType(StabsParser.SymbolTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#symbolTypeReferenceParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolTypeReferenceParameter(StabsParser.SymbolTypeReferenceParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#symbolTypeGlobalFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolTypeGlobalFunction(StabsParser.SymbolTypeGlobalFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#symbolTypeLocalFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolTypeLocalFunction(StabsParser.SymbolTypeLocalFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#symbolTypeGlobalVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolTypeGlobalVariable(StabsParser.SymbolTypeGlobalVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#symbolTypeParameterOrFunctionPrototype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolTypeParameterOrFunctionPrototype(StabsParser.SymbolTypeParameterOrFunctionPrototypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#symbolTypeStackParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolTypeStackParameter(StabsParser.SymbolTypeStackParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#symbolTypeRegisterVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolTypeRegisterVariable(StabsParser.SymbolTypeRegisterVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#symbolTypeStaticFileVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolTypeStaticFileVariable(StabsParser.SymbolTypeStaticFileVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#symbolTypeTaggedTypedef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolTypeTaggedTypedef(StabsParser.SymbolTypeTaggedTypedefContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#symbolTypeTagged}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolTypeTagged(StabsParser.SymbolTypeTaggedContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#symbolTypeTypedef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolTypeTypedef(StabsParser.SymbolTypeTypedefContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#symbolTypeStaticLocalVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolTypeStaticLocalVariable(StabsParser.SymbolTypeStaticLocalVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(StabsParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#typeID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeID(StabsParser.TypeIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#simpleTypeID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleTypeID(StabsParser.SimpleTypeIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#compositeTypeID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompositeTypeID(StabsParser.CompositeTypeIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#typeDescription}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDescription(StabsParser.TypeDescriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#typeDescriptionArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDescriptionArray(StabsParser.TypeDescriptionArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#typeDescriptionAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDescriptionAttribute(StabsParser.TypeDescriptionAttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#typeDescriptionClassMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDescriptionClassMethod(StabsParser.TypeDescriptionClassMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#typeDescriptionEnum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDescriptionEnum(StabsParser.TypeDescriptionEnumContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#typeDescriptionFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDescriptionFunction(StabsParser.TypeDescriptionFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#typeDescriptionNestedFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDescriptionNestedFunction(StabsParser.TypeDescriptionNestedFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#typeDescriptionPointer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDescriptionPointer(StabsParser.TypeDescriptionPointerContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#typeDescriptionRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDescriptionRange(StabsParser.TypeDescriptionRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#typeDescriptionReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDescriptionReference(StabsParser.TypeDescriptionReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#typeDescriptionStructUnionClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDescriptionStructUnionClass(StabsParser.TypeDescriptionStructUnionClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#typeDescriptionXref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDescriptionXref(StabsParser.TypeDescriptionXrefContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#attributeBoundary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeBoundary(StabsParser.AttributeBoundaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#attributePacked}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributePacked(StabsParser.AttributePackedContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#attributePointer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributePointer(StabsParser.AttributePointerContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#attributeSize}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeSize(StabsParser.AttributeSizeContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#attributeString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeString(StabsParser.AttributeStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#attributeVector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeVector(StabsParser.AttributeVectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#classInheritanceInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInheritanceInfo(StabsParser.ClassInheritanceInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#classInheritanceData}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInheritanceData(StabsParser.ClassInheritanceDataContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#classAccessibility}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassAccessibility(StabsParser.ClassAccessibilityContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#classMemberMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberMethod(StabsParser.ClassMemberMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#classMemberMethodOverload}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberMethodOverload(StabsParser.ClassMemberMethodOverloadContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#classMemberMethodInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberMethodInfo(StabsParser.ClassMemberMethodInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#classMemberMethodModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberMethodModifier(StabsParser.ClassMemberMethodModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#classMemberMethodStatic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberMethodStatic(StabsParser.ClassMemberMethodStaticContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#classMemberMethodVirtualInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberMethodVirtualInfo(StabsParser.ClassMemberMethodVirtualInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#classMemberStaticField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberStaticField(StabsParser.ClassMemberStaticFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#classMemberVirtualTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberVirtualTable(StabsParser.ClassMemberVirtualTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#classMethodMangledSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMethodMangledSignature(StabsParser.ClassMethodMangledSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#enumMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumMember(StabsParser.EnumMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#structUnionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructUnionType(StabsParser.StructUnionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#structUnionClassMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructUnionClassMember(StabsParser.StructUnionClassMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#structUnionClassMemberField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructUnionClassMemberField(StabsParser.StructUnionClassMemberFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#classVirtualInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassVirtualInfo(StabsParser.ClassVirtualInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#xrefType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXrefType(StabsParser.XrefTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(StabsParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#letter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetter(StabsParser.LetterContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#boolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(StabsParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(StabsParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(StabsParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#digit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDigit(StabsParser.DigitContext ctx);
}