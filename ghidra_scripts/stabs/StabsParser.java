// Generated from StabsParser.g4 by ANTLR 4.9.3
package stabs;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StabsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SymbolName=1, SymbolColon=2, SymbolDescStackVariable=3, SymbolDescReferenceParameter=4, 
		SymbolDescGlobalFunction=5, SymbolDescLocalFunction=6, SymbolDescGlobalVariable=7, 
		SymbolDescRegisterParameterOrFunctionPrototype=8, SymbolDescStackParameter=9, 
		SymbolDescRegisterVariable=10, SymbolDescStaticFileVariable=11, SymbolDescTaggedType=12, 
		SymbolDescTypedefedType=13, SymbolDescStaticLocalVariable=14, TypeNumLeftBrace=15, 
		TypeEquals=16, TypeDescArray=17, TypeDescEnum=18, TypeDescFunction=19, 
		TypeDescPointer=20, TypeDescRange=21, TypeDescStruct=22, TypeDescUnion=23, 
		TypeDescXref=24, RangeSemicolon=25, RangeInt=26, StrucOrNestedFunctiontFirstComma=27, 
		TypeNumInt=28, TypeNumComma=29, TypeNumRightBrace=30, EnumIdentifier=31, 
		EnumColon=32, EnumInt=33, EnumComma=34, EnumSemicolon=35, StructIdentifier=36, 
		StructColon=37, StructSecondComma=38, StructInt=39, StructSemicolon=40, 
		XrefDescEnum=41, XrefDescStruct=42, XrefDescUnion=43, XrefIdentifier=44, 
		XrefColon=45, StructFirstInt=46, NestedFunctionFirstIdentifier=47, NestedFunctionIdentifier=48, 
		NestedFunctionSecondComma=49;
	public static final int
		RULE_arrayType = 0, RULE_enumMember = 1, RULE_enumType = 2, RULE_functionType = 3, 
		RULE_nestedFunctionType = 4, RULE_pointerType = 5, RULE_rangeType = 6, 
		RULE_structMember = 7, RULE_structType = 8, RULE_xrefType = 9, RULE_typeDesc = 10, 
		RULE_typeNum = 11, RULE_type = 12, RULE_symbol = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"arrayType", "enumMember", "enumType", "functionType", "nestedFunctionType", 
			"pointerType", "rangeType", "structMember", "structType", "xrefType", 
			"typeDesc", "typeNum", "type", "symbol"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'F'", null, "'G'", "'P'", "'p'", null, 
			"'S'", "'T'", "'t'", "'V'", "'('", "'='", null, null, null, "'*'", null, 
			null, null, "'x'", null, null, null, null, null, "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SymbolName", "SymbolColon", "SymbolDescStackVariable", "SymbolDescReferenceParameter", 
			"SymbolDescGlobalFunction", "SymbolDescLocalFunction", "SymbolDescGlobalVariable", 
			"SymbolDescRegisterParameterOrFunctionPrototype", "SymbolDescStackParameter", 
			"SymbolDescRegisterVariable", "SymbolDescStaticFileVariable", "SymbolDescTaggedType", 
			"SymbolDescTypedefedType", "SymbolDescStaticLocalVariable", "TypeNumLeftBrace", 
			"TypeEquals", "TypeDescArray", "TypeDescEnum", "TypeDescFunction", "TypeDescPointer", 
			"TypeDescRange", "TypeDescStruct", "TypeDescUnion", "TypeDescXref", "RangeSemicolon", 
			"RangeInt", "StrucOrNestedFunctiontFirstComma", "TypeNumInt", "TypeNumComma", 
			"TypeNumRightBrace", "EnumIdentifier", "EnumColon", "EnumInt", "EnumComma", 
			"EnumSemicolon", "StructIdentifier", "StructColon", "StructSecondComma", 
			"StructInt", "StructSemicolon", "XrefDescEnum", "XrefDescStruct", "XrefDescUnion", 
			"XrefIdentifier", "XrefColon", "StructFirstInt", "NestedFunctionFirstIdentifier", 
			"NestedFunctionIdentifier", "NestedFunctionSecondComma"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "StabsParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public StabsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ArrayTypeContext extends ParserRuleContext {
		public TerminalNode TypeDescArray() { return getToken(StabsParser.TypeDescArray, 0); }
		public RangeTypeContext rangeType() {
			return getRuleContext(RangeTypeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(TypeDescArray);
			setState(29);
			rangeType();
			setState(30);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumMemberContext extends ParserRuleContext {
		public TerminalNode EnumIdentifier() { return getToken(StabsParser.EnumIdentifier, 0); }
		public TerminalNode EnumColon() { return getToken(StabsParser.EnumColon, 0); }
		public TerminalNode EnumInt() { return getToken(StabsParser.EnumInt, 0); }
		public TerminalNode EnumComma() { return getToken(StabsParser.EnumComma, 0); }
		public EnumMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumMember; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitEnumMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumMemberContext enumMember() throws RecognitionException {
		EnumMemberContext _localctx = new EnumMemberContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_enumMember);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(EnumIdentifier);
			setState(33);
			match(EnumColon);
			setState(34);
			match(EnumInt);
			setState(35);
			match(EnumComma);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumTypeContext extends ParserRuleContext {
		public TerminalNode TypeDescEnum() { return getToken(StabsParser.TypeDescEnum, 0); }
		public TerminalNode EnumSemicolon() { return getToken(StabsParser.EnumSemicolon, 0); }
		public List<EnumMemberContext> enumMember() {
			return getRuleContexts(EnumMemberContext.class);
		}
		public EnumMemberContext enumMember(int i) {
			return getRuleContext(EnumMemberContext.class,i);
		}
		public EnumTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitEnumType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumTypeContext enumType() throws RecognitionException {
		EnumTypeContext _localctx = new EnumTypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_enumType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(TypeDescEnum);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EnumIdentifier) {
				{
				{
				setState(38);
				enumMember();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44);
			match(EnumSemicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionTypeContext extends ParserRuleContext {
		public TerminalNode TypeDescFunction() { return getToken(StabsParser.TypeDescFunction, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FunctionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitFunctionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionTypeContext functionType() throws RecognitionException {
		FunctionTypeContext _localctx = new FunctionTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(TypeDescFunction);
			setState(47);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NestedFunctionTypeContext extends ParserRuleContext {
		public TerminalNode StrucOrNestedFunctiontFirstComma() { return getToken(StabsParser.StrucOrNestedFunctiontFirstComma, 0); }
		public TerminalNode NestedFunctionFirstIdentifier() { return getToken(StabsParser.NestedFunctionFirstIdentifier, 0); }
		public TerminalNode NestedFunctionSecondComma() { return getToken(StabsParser.NestedFunctionSecondComma, 0); }
		public TerminalNode NestedFunctionIdentifier() { return getToken(StabsParser.NestedFunctionIdentifier, 0); }
		public NestedFunctionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nestedFunctionType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitNestedFunctionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NestedFunctionTypeContext nestedFunctionType() throws RecognitionException {
		NestedFunctionTypeContext _localctx = new NestedFunctionTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_nestedFunctionType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(StrucOrNestedFunctiontFirstComma);
			setState(50);
			match(NestedFunctionFirstIdentifier);
			setState(51);
			match(NestedFunctionSecondComma);
			setState(52);
			match(NestedFunctionIdentifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PointerTypeContext extends ParserRuleContext {
		public TerminalNode TypeDescPointer() { return getToken(StabsParser.TypeDescPointer, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public PointerTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitPointerType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointerTypeContext pointerType() throws RecognitionException {
		PointerTypeContext _localctx = new PointerTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_pointerType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(TypeDescPointer);
			setState(55);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RangeTypeContext extends ParserRuleContext {
		public TerminalNode TypeDescRange() { return getToken(StabsParser.TypeDescRange, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> RangeSemicolon() { return getTokens(StabsParser.RangeSemicolon); }
		public TerminalNode RangeSemicolon(int i) {
			return getToken(StabsParser.RangeSemicolon, i);
		}
		public List<TerminalNode> RangeInt() { return getTokens(StabsParser.RangeInt); }
		public TerminalNode RangeInt(int i) {
			return getToken(StabsParser.RangeInt, i);
		}
		public RangeTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitRangeType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeTypeContext rangeType() throws RecognitionException {
		RangeTypeContext _localctx = new RangeTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_rangeType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(TypeDescRange);
			setState(58);
			type();
			setState(59);
			match(RangeSemicolon);
			setState(60);
			match(RangeInt);
			setState(61);
			match(RangeSemicolon);
			setState(62);
			match(RangeInt);
			setState(63);
			match(RangeSemicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructMemberContext extends ParserRuleContext {
		public TerminalNode StructIdentifier() { return getToken(StabsParser.StructIdentifier, 0); }
		public TerminalNode StructColon() { return getToken(StabsParser.StructColon, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode StrucOrNestedFunctiontFirstComma() { return getToken(StabsParser.StrucOrNestedFunctiontFirstComma, 0); }
		public TerminalNode StructFirstInt() { return getToken(StabsParser.StructFirstInt, 0); }
		public TerminalNode StructSecondComma() { return getToken(StabsParser.StructSecondComma, 0); }
		public TerminalNode StructInt() { return getToken(StabsParser.StructInt, 0); }
		public TerminalNode StructSemicolon() { return getToken(StabsParser.StructSemicolon, 0); }
		public StructMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structMember; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitStructMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructMemberContext structMember() throws RecognitionException {
		StructMemberContext _localctx = new StructMemberContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_structMember);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(StructIdentifier);
			setState(66);
			match(StructColon);
			setState(67);
			type();
			setState(68);
			match(StrucOrNestedFunctiontFirstComma);
			setState(69);
			match(StructFirstInt);
			setState(70);
			match(StructSecondComma);
			setState(71);
			match(StructInt);
			setState(72);
			match(StructSemicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructTypeContext extends ParserRuleContext {
		public TerminalNode StructInt() { return getToken(StabsParser.StructInt, 0); }
		public TerminalNode StructSemicolon() { return getToken(StabsParser.StructSemicolon, 0); }
		public TerminalNode TypeDescStruct() { return getToken(StabsParser.TypeDescStruct, 0); }
		public TerminalNode TypeDescUnion() { return getToken(StabsParser.TypeDescUnion, 0); }
		public List<StructMemberContext> structMember() {
			return getRuleContexts(StructMemberContext.class);
		}
		public StructMemberContext structMember(int i) {
			return getRuleContext(StructMemberContext.class,i);
		}
		public StructTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitStructType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructTypeContext structType() throws RecognitionException {
		StructTypeContext _localctx = new StructTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_structType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_la = _input.LA(1);
			if ( !(_la==TypeDescStruct || _la==TypeDescUnion) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(75);
			match(StructInt);
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==StructIdentifier) {
				{
				{
				setState(76);
				structMember();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
			match(StructSemicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class XrefTypeContext extends ParserRuleContext {
		public TerminalNode TypeDescXref() { return getToken(StabsParser.TypeDescXref, 0); }
		public TerminalNode XrefIdentifier() { return getToken(StabsParser.XrefIdentifier, 0); }
		public TerminalNode XrefColon() { return getToken(StabsParser.XrefColon, 0); }
		public TerminalNode XrefDescEnum() { return getToken(StabsParser.XrefDescEnum, 0); }
		public TerminalNode XrefDescStruct() { return getToken(StabsParser.XrefDescStruct, 0); }
		public TerminalNode XrefDescUnion() { return getToken(StabsParser.XrefDescUnion, 0); }
		public XrefTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xrefType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitXrefType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XrefTypeContext xrefType() throws RecognitionException {
		XrefTypeContext _localctx = new XrefTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_xrefType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(TypeDescXref);
			setState(85);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << XrefDescEnum) | (1L << XrefDescStruct) | (1L << XrefDescUnion))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(86);
			match(XrefIdentifier);
			setState(87);
			match(XrefColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDescContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public EnumTypeContext enumType() {
			return getRuleContext(EnumTypeContext.class,0);
		}
		public FunctionTypeContext functionType() {
			return getRuleContext(FunctionTypeContext.class,0);
		}
		public PointerTypeContext pointerType() {
			return getRuleContext(PointerTypeContext.class,0);
		}
		public RangeTypeContext rangeType() {
			return getRuleContext(RangeTypeContext.class,0);
		}
		public StructTypeContext structType() {
			return getRuleContext(StructTypeContext.class,0);
		}
		public XrefTypeContext xrefType() {
			return getRuleContext(XrefTypeContext.class,0);
		}
		public TypeDescContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDesc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitTypeDesc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDescContext typeDesc() throws RecognitionException {
		TypeDescContext _localctx = new TypeDescContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_typeDesc);
		try {
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TypeNumLeftBrace:
			case TypeNumInt:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				type();
				}
				break;
			case TypeDescArray:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				arrayType();
				}
				break;
			case TypeDescEnum:
				enterOuterAlt(_localctx, 3);
				{
				setState(91);
				enumType();
				}
				break;
			case TypeDescFunction:
				enterOuterAlt(_localctx, 4);
				{
				setState(92);
				functionType();
				}
				break;
			case TypeDescPointer:
				enterOuterAlt(_localctx, 5);
				{
				setState(93);
				pointerType();
				}
				break;
			case TypeDescRange:
				enterOuterAlt(_localctx, 6);
				{
				setState(94);
				rangeType();
				}
				break;
			case TypeDescStruct:
			case TypeDescUnion:
				enterOuterAlt(_localctx, 7);
				{
				setState(95);
				structType();
				}
				break;
			case TypeDescXref:
				enterOuterAlt(_localctx, 8);
				{
				setState(96);
				xrefType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeNumContext extends ParserRuleContext {
		public List<TerminalNode> TypeNumInt() { return getTokens(StabsParser.TypeNumInt); }
		public TerminalNode TypeNumInt(int i) {
			return getToken(StabsParser.TypeNumInt, i);
		}
		public TerminalNode TypeNumComma() { return getToken(StabsParser.TypeNumComma, 0); }
		public TerminalNode TypeNumRightBrace() { return getToken(StabsParser.TypeNumRightBrace, 0); }
		public TerminalNode TypeNumLeftBrace() { return getToken(StabsParser.TypeNumLeftBrace, 0); }
		public TypeNumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeNum; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitTypeNum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNumContext typeNum() throws RecognitionException {
		TypeNumContext _localctx = new TypeNumContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_typeNum);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TypeNumLeftBrace) {
				{
				setState(99);
				match(TypeNumLeftBrace);
				}
			}

			setState(102);
			match(TypeNumInt);
			setState(103);
			match(TypeNumComma);
			setState(104);
			match(TypeNumInt);
			setState(105);
			match(TypeNumRightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeNumContext typeNum() {
			return getRuleContext(TypeNumContext.class,0);
		}
		public NestedFunctionTypeContext nestedFunctionType() {
			return getRuleContext(NestedFunctionTypeContext.class,0);
		}
		public TerminalNode TypeEquals() { return getToken(StabsParser.TypeEquals, 0); }
		public TypeDescContext typeDesc() {
			return getRuleContext(TypeDescContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			typeNum();
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				{
				setState(108);
				match(TypeEquals);
				setState(109);
				typeDesc();
				}
				}
				break;
			case 2:
				{
				setState(110);
				nestedFunctionType();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SymbolContext extends ParserRuleContext {
		public TerminalNode SymbolName() { return getToken(StabsParser.SymbolName, 0); }
		public TerminalNode SymbolColon() { return getToken(StabsParser.SymbolColon, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode SymbolDescStackVariable() { return getToken(StabsParser.SymbolDescStackVariable, 0); }
		public TerminalNode SymbolDescReferenceParameter() { return getToken(StabsParser.SymbolDescReferenceParameter, 0); }
		public TerminalNode SymbolDescGlobalFunction() { return getToken(StabsParser.SymbolDescGlobalFunction, 0); }
		public TerminalNode SymbolDescLocalFunction() { return getToken(StabsParser.SymbolDescLocalFunction, 0); }
		public TerminalNode SymbolDescGlobalVariable() { return getToken(StabsParser.SymbolDescGlobalVariable, 0); }
		public TerminalNode SymbolDescRegisterParameterOrFunctionPrototype() { return getToken(StabsParser.SymbolDescRegisterParameterOrFunctionPrototype, 0); }
		public TerminalNode SymbolDescStackParameter() { return getToken(StabsParser.SymbolDescStackParameter, 0); }
		public TerminalNode SymbolDescRegisterVariable() { return getToken(StabsParser.SymbolDescRegisterVariable, 0); }
		public TerminalNode SymbolDescStaticFileVariable() { return getToken(StabsParser.SymbolDescStaticFileVariable, 0); }
		public TerminalNode SymbolDescTaggedType() { return getToken(StabsParser.SymbolDescTaggedType, 0); }
		public TerminalNode SymbolDescTypedefedType() { return getToken(StabsParser.SymbolDescTypedefedType, 0); }
		public TerminalNode SymbolDescStaticLocalVariable() { return getToken(StabsParser.SymbolDescStaticLocalVariable, 0); }
		public SymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbol; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitSymbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolContext symbol() throws RecognitionException {
		SymbolContext _localctx = new SymbolContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_symbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(SymbolName);
			setState(114);
			match(SymbolColon);
			setState(115);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SymbolDescStackVariable) | (1L << SymbolDescReferenceParameter) | (1L << SymbolDescGlobalFunction) | (1L << SymbolDescLocalFunction) | (1L << SymbolDescGlobalVariable) | (1L << SymbolDescRegisterParameterOrFunctionPrototype) | (1L << SymbolDescStackParameter) | (1L << SymbolDescRegisterVariable) | (1L << SymbolDescStaticFileVariable) | (1L << SymbolDescTaggedType) | (1L << SymbolDescTypedefedType) | (1L << SymbolDescStaticLocalVariable))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(116);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\63y\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\7\4*\n\4\f\4\16\4-\13\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\7\nP\n\n\f\n\16\nS\13\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\fd\n\f\3\r\5\rg\n\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\5\16r\n\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\5\3\2\30\31\3\2+-\3"+
		"\2\5\20\2v\2\36\3\2\2\2\4\"\3\2\2\2\6\'\3\2\2\2\b\60\3\2\2\2\n\63\3\2"+
		"\2\2\f8\3\2\2\2\16;\3\2\2\2\20C\3\2\2\2\22L\3\2\2\2\24V\3\2\2\2\26c\3"+
		"\2\2\2\30f\3\2\2\2\32m\3\2\2\2\34s\3\2\2\2\36\37\7\23\2\2\37 \5\16\b\2"+
		" !\5\32\16\2!\3\3\2\2\2\"#\7!\2\2#$\7\"\2\2$%\7#\2\2%&\7$\2\2&\5\3\2\2"+
		"\2\'+\7\24\2\2(*\5\4\3\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,.\3\2"+
		"\2\2-+\3\2\2\2./\7%\2\2/\7\3\2\2\2\60\61\7\25\2\2\61\62\5\32\16\2\62\t"+
		"\3\2\2\2\63\64\7\35\2\2\64\65\7\61\2\2\65\66\7\63\2\2\66\67\7\62\2\2\67"+
		"\13\3\2\2\289\7\26\2\29:\5\32\16\2:\r\3\2\2\2;<\7\27\2\2<=\5\32\16\2="+
		">\7\33\2\2>?\7\34\2\2?@\7\33\2\2@A\7\34\2\2AB\7\33\2\2B\17\3\2\2\2CD\7"+
		"&\2\2DE\7\'\2\2EF\5\32\16\2FG\7\35\2\2GH\7\60\2\2HI\7(\2\2IJ\7)\2\2JK"+
		"\7*\2\2K\21\3\2\2\2LM\t\2\2\2MQ\7)\2\2NP\5\20\t\2ON\3\2\2\2PS\3\2\2\2"+
		"QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SQ\3\2\2\2TU\7*\2\2U\23\3\2\2\2VW\7\32\2"+
		"\2WX\t\3\2\2XY\7.\2\2YZ\7/\2\2Z\25\3\2\2\2[d\5\32\16\2\\d\5\2\2\2]d\5"+
		"\6\4\2^d\5\b\5\2_d\5\f\7\2`d\5\16\b\2ad\5\22\n\2bd\5\24\13\2c[\3\2\2\2"+
		"c\\\3\2\2\2c]\3\2\2\2c^\3\2\2\2c_\3\2\2\2c`\3\2\2\2ca\3\2\2\2cb\3\2\2"+
		"\2d\27\3\2\2\2eg\7\21\2\2fe\3\2\2\2fg\3\2\2\2gh\3\2\2\2hi\7\36\2\2ij\7"+
		"\37\2\2jk\7\36\2\2kl\7 \2\2l\31\3\2\2\2mq\5\30\r\2no\7\22\2\2or\5\26\f"+
		"\2pr\5\n\6\2qn\3\2\2\2qp\3\2\2\2qr\3\2\2\2r\33\3\2\2\2st\7\3\2\2tu\7\4"+
		"\2\2uv\t\4\2\2vw\5\32\16\2w\35\3\2\2\2\7+Qcfq";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}