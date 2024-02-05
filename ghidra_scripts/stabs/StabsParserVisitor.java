// Generated from StabsParser.g4 by ANTLR 4.9.3
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
	 * Visit a parse tree produced by {@link StabsParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(StabsParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#enumMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumMember(StabsParser.EnumMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#enumType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumType(StabsParser.EnumTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#functionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionType(StabsParser.FunctionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#nestedFunctionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedFunctionType(StabsParser.NestedFunctionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#pointerType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointerType(StabsParser.PointerTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#rangeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeType(StabsParser.RangeTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#structMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructMember(StabsParser.StructMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#structType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructType(StabsParser.StructTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#xrefType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXrefType(StabsParser.XrefTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#typeDesc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDesc(StabsParser.TypeDescContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#typeNum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeNum(StabsParser.TypeNumContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(StabsParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link StabsParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbol(StabsParser.SymbolContext ctx);
}