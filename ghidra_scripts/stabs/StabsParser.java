// Generated from c:/Users/tiagocost/ghidra_scripts/stabs/StabsParser.g4 by ANTLR 4.13.1
package stabs;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class StabsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		UppercaseA=1, UppercaseB=2, UppercaseC=3, UppercaseD=4, UppercaseE=5, 
		UppercaseF=6, UppercaseG=7, UppercaseH=8, UppercaseI=9, UppercaseJ=10, 
		UppercaseK=11, UppercaseL=12, UppercaseM=13, UppercaseN=14, UppercaseO=15, 
		UppercaseP=16, UppercaseQ=17, UppercaseR=18, UppercaseS=19, UppercaseT=20, 
		UppercaseU=21, UppercaseV=22, UppercaseW=23, UppercaseX=24, UppercaseY=25, 
		UppercaseZ=26, LowercaseA=27, LowercaseB=28, LowercaseC=29, LowercaseD=30, 
		LowercaseE=31, LowercaseF=32, LowercaseG=33, LowercaseH=34, LowercaseI=35, 
		LowercaseJ=36, LowercaseK=37, LowercaseL=38, LowercaseM=39, LowercaseN=40, 
		LowercaseO=41, LowercaseP=42, LowercaseQ=43, LowercaseR=44, LowercaseS=45, 
		LowercaseT=46, LowercaseU=47, LowercaseV=48, LowercaseW=49, LowercaseX=50, 
		LowercaseY=51, LowercaseZ=52, Number0=53, Number1=54, Number2=55, Number3=56, 
		Number4=57, Number5=58, Number6=59, Number7=60, Number8=61, Number9=62, 
		Ampersand=63, AngleBracketLeft=64, AngleBracketRight=65, Asterisk=66, 
		At=67, Colon=68, Comma=69, Dot=70, Equals=71, Exclamation=72, Hash=73, 
		Minus=74, ParenthesisLeft=75, ParenthesisRight=76, Percent=77, Plus=78, 
		Question=79, Semicolon=80, Slash=81, Space=82, Tilde=83, Underscore=84;
	public static final int
		RULE_symbol = 0, RULE_symbolType = 1, RULE_symbolTypeReferenceParameter = 2, 
		RULE_symbolTypeGlobalFunction = 3, RULE_symbolTypeLocalFunction = 4, RULE_symbolTypeGlobalVariable = 5, 
		RULE_symbolTypeParameterOrFunctionPrototype = 6, RULE_symbolTypeStackParameter = 7, 
		RULE_symbolTypeRegisterVariable = 8, RULE_symbolTypeStaticFileVariable = 9, 
		RULE_symbolTypeTaggedTypedef = 10, RULE_symbolTypeTagged = 11, RULE_symbolTypeTypedef = 12, 
		RULE_symbolTypeStaticLocalVariable = 13, RULE_type = 14, RULE_typeID = 15, 
		RULE_simpleTypeID = 16, RULE_compositeTypeID = 17, RULE_typeDescription = 18, 
		RULE_typeDescriptionArray = 19, RULE_typeDescriptionAttribute = 20, RULE_typeDescriptionClassMethod = 21, 
		RULE_typeDescriptionEnum = 22, RULE_typeDescriptionFunction = 23, RULE_typeDescriptionNestedFunction = 24, 
		RULE_typeDescriptionPointer = 25, RULE_typeDescriptionRange = 26, RULE_typeDescriptionReference = 27, 
		RULE_typeDescriptionStructUnionClass = 28, RULE_typeDescriptionXref = 29, 
		RULE_attributeBoundary = 30, RULE_attributePacked = 31, RULE_attributePointer = 32, 
		RULE_attributeSize = 33, RULE_attributeString = 34, RULE_attributeVector = 35, 
		RULE_classInheritanceInfo = 36, RULE_classInheritanceData = 37, RULE_classAccessibility = 38, 
		RULE_classMemberMethod = 39, RULE_classMemberMethodOverload = 40, RULE_classMemberMethodInfo = 41, 
		RULE_classMemberMethodModifier = 42, RULE_classMemberMethodStatic = 43, 
		RULE_classMemberMethodVirtualInfo = 44, RULE_classMemberStaticField = 45, 
		RULE_classMemberVirtualTable = 46, RULE_classMethodMangledSignature = 47, 
		RULE_enumMember = 48, RULE_structUnionType = 49, RULE_structUnionClassMember = 50, 
		RULE_structUnionClassMemberField = 51, RULE_classVirtualInfo = 52, RULE_xrefType = 53, 
		RULE_identifier = 54, RULE_letter = 55, RULE_boolean = 56, RULE_integer = 57, 
		RULE_number = 58, RULE_digit = 59;
	private static String[] makeRuleNames() {
		return new String[] {
			"symbol", "symbolType", "symbolTypeReferenceParameter", "symbolTypeGlobalFunction", 
			"symbolTypeLocalFunction", "symbolTypeGlobalVariable", "symbolTypeParameterOrFunctionPrototype", 
			"symbolTypeStackParameter", "symbolTypeRegisterVariable", "symbolTypeStaticFileVariable", 
			"symbolTypeTaggedTypedef", "symbolTypeTagged", "symbolTypeTypedef", "symbolTypeStaticLocalVariable", 
			"type", "typeID", "simpleTypeID", "compositeTypeID", "typeDescription", 
			"typeDescriptionArray", "typeDescriptionAttribute", "typeDescriptionClassMethod", 
			"typeDescriptionEnum", "typeDescriptionFunction", "typeDescriptionNestedFunction", 
			"typeDescriptionPointer", "typeDescriptionRange", "typeDescriptionReference", 
			"typeDescriptionStructUnionClass", "typeDescriptionXref", "attributeBoundary", 
			"attributePacked", "attributePointer", "attributeSize", "attributeString", 
			"attributeVector", "classInheritanceInfo", "classInheritanceData", "classAccessibility", 
			"classMemberMethod", "classMemberMethodOverload", "classMemberMethodInfo", 
			"classMemberMethodModifier", "classMemberMethodStatic", "classMemberMethodVirtualInfo", 
			"classMemberStaticField", "classMemberVirtualTable", "classMethodMangledSignature", 
			"enumMember", "structUnionType", "structUnionClassMember", "structUnionClassMemberField", 
			"classVirtualInfo", "xrefType", "identifier", "letter", "boolean", "integer", 
			"number", "digit"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'A'", "'B'", "'C'", "'D'", "'E'", "'F'", "'G'", "'H'", "'I'", 
			"'J'", "'K'", "'L'", "'M'", "'N'", "'O'", "'P'", "'Q'", "'R'", "'S'", 
			"'T'", "'U'", "'V'", "'W'", "'X'", "'Y'", "'Z'", "'a'", "'b'", "'c'", 
			"'d'", "'e'", "'f'", "'g'", "'h'", "'i'", "'j'", "'k'", "'l'", "'m'", 
			"'n'", "'o'", "'p'", "'q'", "'r'", "'s'", "'t'", "'u'", "'v'", "'w'", 
			"'x'", "'y'", "'z'", "'0'", "'1'", "'2'", "'3'", "'4'", "'5'", "'6'", 
			"'7'", "'8'", "'9'", "'&'", "'<'", "'>'", "'*'", "'@'", "':'", "','", 
			"'.'", "'='", "'!'", "'#'", "'-'", "'('", "')'", "'%'", "'+'", "'?'", 
			"';'", "'/'", "' '", "'~'", "'_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "UppercaseA", "UppercaseB", "UppercaseC", "UppercaseD", "UppercaseE", 
			"UppercaseF", "UppercaseG", "UppercaseH", "UppercaseI", "UppercaseJ", 
			"UppercaseK", "UppercaseL", "UppercaseM", "UppercaseN", "UppercaseO", 
			"UppercaseP", "UppercaseQ", "UppercaseR", "UppercaseS", "UppercaseT", 
			"UppercaseU", "UppercaseV", "UppercaseW", "UppercaseX", "UppercaseY", 
			"UppercaseZ", "LowercaseA", "LowercaseB", "LowercaseC", "LowercaseD", 
			"LowercaseE", "LowercaseF", "LowercaseG", "LowercaseH", "LowercaseI", 
			"LowercaseJ", "LowercaseK", "LowercaseL", "LowercaseM", "LowercaseN", 
			"LowercaseO", "LowercaseP", "LowercaseQ", "LowercaseR", "LowercaseS", 
			"LowercaseT", "LowercaseU", "LowercaseV", "LowercaseW", "LowercaseX", 
			"LowercaseY", "LowercaseZ", "Number0", "Number1", "Number2", "Number3", 
			"Number4", "Number5", "Number6", "Number7", "Number8", "Number9", "Ampersand", 
			"AngleBracketLeft", "AngleBracketRight", "Asterisk", "At", "Colon", "Comma", 
			"Dot", "Equals", "Exclamation", "Hash", "Minus", "ParenthesisLeft", "ParenthesisRight", 
			"Percent", "Plus", "Question", "Semicolon", "Slash", "Space", "Tilde", 
			"Underscore"
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

	@SuppressWarnings("CheckReturnValue")
	public static class SymbolContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Colon() { return getToken(StabsParser.Colon, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public SymbolTypeContext symbolType() {
			return getRuleContext(SymbolTypeContext.class,0);
		}
		public SymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitSymbol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitSymbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolContext symbol() throws RecognitionException {
		SymbolContext _localctx = new SymbolContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_symbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			identifier();
			setState(121);
			match(Colon);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 92363411751104L) != 0)) {
				{
				setState(122);
				symbolType();
				}
			}

			setState(125);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SymbolTypeContext extends ParserRuleContext {
		public SymbolTypeReferenceParameterContext symbolTypeReferenceParameter() {
			return getRuleContext(SymbolTypeReferenceParameterContext.class,0);
		}
		public SymbolTypeGlobalFunctionContext symbolTypeGlobalFunction() {
			return getRuleContext(SymbolTypeGlobalFunctionContext.class,0);
		}
		public SymbolTypeLocalFunctionContext symbolTypeLocalFunction() {
			return getRuleContext(SymbolTypeLocalFunctionContext.class,0);
		}
		public SymbolTypeGlobalVariableContext symbolTypeGlobalVariable() {
			return getRuleContext(SymbolTypeGlobalVariableContext.class,0);
		}
		public SymbolTypeParameterOrFunctionPrototypeContext symbolTypeParameterOrFunctionPrototype() {
			return getRuleContext(SymbolTypeParameterOrFunctionPrototypeContext.class,0);
		}
		public SymbolTypeStackParameterContext symbolTypeStackParameter() {
			return getRuleContext(SymbolTypeStackParameterContext.class,0);
		}
		public SymbolTypeRegisterVariableContext symbolTypeRegisterVariable() {
			return getRuleContext(SymbolTypeRegisterVariableContext.class,0);
		}
		public SymbolTypeStaticFileVariableContext symbolTypeStaticFileVariable() {
			return getRuleContext(SymbolTypeStaticFileVariableContext.class,0);
		}
		public SymbolTypeTaggedTypedefContext symbolTypeTaggedTypedef() {
			return getRuleContext(SymbolTypeTaggedTypedefContext.class,0);
		}
		public SymbolTypeTaggedContext symbolTypeTagged() {
			return getRuleContext(SymbolTypeTaggedContext.class,0);
		}
		public SymbolTypeTypedefContext symbolTypeTypedef() {
			return getRuleContext(SymbolTypeTypedefContext.class,0);
		}
		public SymbolTypeStaticLocalVariableContext symbolTypeStaticLocalVariable() {
			return getRuleContext(SymbolTypeStaticLocalVariableContext.class,0);
		}
		public SymbolTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterSymbolType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitSymbolType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitSymbolType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolTypeContext symbolType() throws RecognitionException {
		SymbolTypeContext _localctx = new SymbolTypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_symbolType);
		try {
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				symbolTypeReferenceParameter();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				symbolTypeGlobalFunction();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(129);
				symbolTypeLocalFunction();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(130);
				symbolTypeGlobalVariable();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(131);
				symbolTypeParameterOrFunctionPrototype();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(132);
				symbolTypeStackParameter();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(133);
				symbolTypeRegisterVariable();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(134);
				symbolTypeStaticFileVariable();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(135);
				symbolTypeTaggedTypedef();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(136);
				symbolTypeTagged();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(137);
				symbolTypeTypedef();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(138);
				symbolTypeStaticLocalVariable();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class SymbolTypeReferenceParameterContext extends ParserRuleContext {
		public TerminalNode LowercaseA() { return getToken(StabsParser.LowercaseA, 0); }
		public SymbolTypeReferenceParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolTypeReferenceParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterSymbolTypeReferenceParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitSymbolTypeReferenceParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitSymbolTypeReferenceParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolTypeReferenceParameterContext symbolTypeReferenceParameter() throws RecognitionException {
		SymbolTypeReferenceParameterContext _localctx = new SymbolTypeReferenceParameterContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_symbolTypeReferenceParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(LowercaseA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SymbolTypeGlobalFunctionContext extends ParserRuleContext {
		public TerminalNode UppercaseF() { return getToken(StabsParser.UppercaseF, 0); }
		public SymbolTypeGlobalFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolTypeGlobalFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterSymbolTypeGlobalFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitSymbolTypeGlobalFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitSymbolTypeGlobalFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolTypeGlobalFunctionContext symbolTypeGlobalFunction() throws RecognitionException {
		SymbolTypeGlobalFunctionContext _localctx = new SymbolTypeGlobalFunctionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_symbolTypeGlobalFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(UppercaseF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SymbolTypeLocalFunctionContext extends ParserRuleContext {
		public TerminalNode LowercaseF() { return getToken(StabsParser.LowercaseF, 0); }
		public SymbolTypeLocalFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolTypeLocalFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterSymbolTypeLocalFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitSymbolTypeLocalFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitSymbolTypeLocalFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolTypeLocalFunctionContext symbolTypeLocalFunction() throws RecognitionException {
		SymbolTypeLocalFunctionContext _localctx = new SymbolTypeLocalFunctionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_symbolTypeLocalFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(LowercaseF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SymbolTypeGlobalVariableContext extends ParserRuleContext {
		public TerminalNode UppercaseG() { return getToken(StabsParser.UppercaseG, 0); }
		public SymbolTypeGlobalVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolTypeGlobalVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterSymbolTypeGlobalVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitSymbolTypeGlobalVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitSymbolTypeGlobalVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolTypeGlobalVariableContext symbolTypeGlobalVariable() throws RecognitionException {
		SymbolTypeGlobalVariableContext _localctx = new SymbolTypeGlobalVariableContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_symbolTypeGlobalVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(UppercaseG);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SymbolTypeParameterOrFunctionPrototypeContext extends ParserRuleContext {
		public TerminalNode UppercaseP() { return getToken(StabsParser.UppercaseP, 0); }
		public SymbolTypeParameterOrFunctionPrototypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolTypeParameterOrFunctionPrototype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterSymbolTypeParameterOrFunctionPrototype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitSymbolTypeParameterOrFunctionPrototype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitSymbolTypeParameterOrFunctionPrototype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolTypeParameterOrFunctionPrototypeContext symbolTypeParameterOrFunctionPrototype() throws RecognitionException {
		SymbolTypeParameterOrFunctionPrototypeContext _localctx = new SymbolTypeParameterOrFunctionPrototypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_symbolTypeParameterOrFunctionPrototype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(UppercaseP);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SymbolTypeStackParameterContext extends ParserRuleContext {
		public TerminalNode LowercaseP() { return getToken(StabsParser.LowercaseP, 0); }
		public SymbolTypeStackParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolTypeStackParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterSymbolTypeStackParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitSymbolTypeStackParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitSymbolTypeStackParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolTypeStackParameterContext symbolTypeStackParameter() throws RecognitionException {
		SymbolTypeStackParameterContext _localctx = new SymbolTypeStackParameterContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_symbolTypeStackParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(LowercaseP);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SymbolTypeRegisterVariableContext extends ParserRuleContext {
		public TerminalNode LowercaseR() { return getToken(StabsParser.LowercaseR, 0); }
		public SymbolTypeRegisterVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolTypeRegisterVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterSymbolTypeRegisterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitSymbolTypeRegisterVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitSymbolTypeRegisterVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolTypeRegisterVariableContext symbolTypeRegisterVariable() throws RecognitionException {
		SymbolTypeRegisterVariableContext _localctx = new SymbolTypeRegisterVariableContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_symbolTypeRegisterVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(LowercaseR);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SymbolTypeStaticFileVariableContext extends ParserRuleContext {
		public TerminalNode UppercaseS() { return getToken(StabsParser.UppercaseS, 0); }
		public SymbolTypeStaticFileVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolTypeStaticFileVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterSymbolTypeStaticFileVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitSymbolTypeStaticFileVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitSymbolTypeStaticFileVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolTypeStaticFileVariableContext symbolTypeStaticFileVariable() throws RecognitionException {
		SymbolTypeStaticFileVariableContext _localctx = new SymbolTypeStaticFileVariableContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_symbolTypeStaticFileVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(UppercaseS);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SymbolTypeTaggedTypedefContext extends ParserRuleContext {
		public TerminalNode UppercaseT() { return getToken(StabsParser.UppercaseT, 0); }
		public TerminalNode LowercaseT() { return getToken(StabsParser.LowercaseT, 0); }
		public SymbolTypeTaggedTypedefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolTypeTaggedTypedef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterSymbolTypeTaggedTypedef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitSymbolTypeTaggedTypedef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitSymbolTypeTaggedTypedef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolTypeTaggedTypedefContext symbolTypeTaggedTypedef() throws RecognitionException {
		SymbolTypeTaggedTypedefContext _localctx = new SymbolTypeTaggedTypedefContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_symbolTypeTaggedTypedef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(UppercaseT);
			setState(158);
			match(LowercaseT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SymbolTypeTaggedContext extends ParserRuleContext {
		public TerminalNode UppercaseT() { return getToken(StabsParser.UppercaseT, 0); }
		public SymbolTypeTaggedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolTypeTagged; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterSymbolTypeTagged(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitSymbolTypeTagged(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitSymbolTypeTagged(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolTypeTaggedContext symbolTypeTagged() throws RecognitionException {
		SymbolTypeTaggedContext _localctx = new SymbolTypeTaggedContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_symbolTypeTagged);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(UppercaseT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SymbolTypeTypedefContext extends ParserRuleContext {
		public TerminalNode LowercaseT() { return getToken(StabsParser.LowercaseT, 0); }
		public SymbolTypeTypedefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolTypeTypedef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterSymbolTypeTypedef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitSymbolTypeTypedef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitSymbolTypeTypedef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolTypeTypedefContext symbolTypeTypedef() throws RecognitionException {
		SymbolTypeTypedefContext _localctx = new SymbolTypeTypedefContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_symbolTypeTypedef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(LowercaseT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SymbolTypeStaticLocalVariableContext extends ParserRuleContext {
		public TerminalNode UppercaseV() { return getToken(StabsParser.UppercaseV, 0); }
		public SymbolTypeStaticLocalVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolTypeStaticLocalVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterSymbolTypeStaticLocalVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitSymbolTypeStaticLocalVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitSymbolTypeStaticLocalVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolTypeStaticLocalVariableContext symbolTypeStaticLocalVariable() throws RecognitionException {
		SymbolTypeStaticLocalVariableContext _localctx = new SymbolTypeStaticLocalVariableContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_symbolTypeStaticLocalVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(UppercaseV);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeIDContext typeID() {
			return getRuleContext(TypeIDContext.class,0);
		}
		public TypeDescriptionContext typeDescription() {
			return getRuleContext(TypeDescriptionContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			typeID();
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Equals) {
				{
				setState(167);
				typeDescription();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeIDContext extends ParserRuleContext {
		public SimpleTypeIDContext simpleTypeID() {
			return getRuleContext(SimpleTypeIDContext.class,0);
		}
		public CompositeTypeIDContext compositeTypeID() {
			return getRuleContext(CompositeTypeIDContext.class,0);
		}
		public TypeIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterTypeID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitTypeID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitTypeID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeIDContext typeID() throws RecognitionException {
		TypeIDContext _localctx = new TypeIDContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_typeID);
		try {
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Number0:
			case Number1:
			case Number2:
			case Number3:
			case Number4:
			case Number5:
			case Number6:
			case Number7:
			case Number8:
			case Number9:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				simpleTypeID();
				}
				break;
			case ParenthesisLeft:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				compositeTypeID();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleTypeIDContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public SimpleTypeIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleTypeID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterSimpleTypeID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitSimpleTypeID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitSimpleTypeID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleTypeIDContext simpleTypeID() throws RecognitionException {
		SimpleTypeIDContext _localctx = new SimpleTypeIDContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_simpleTypeID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			number();
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

	@SuppressWarnings("CheckReturnValue")
	public static class CompositeTypeIDContext extends ParserRuleContext {
		public TerminalNode ParenthesisLeft() { return getToken(StabsParser.ParenthesisLeft, 0); }
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public TerminalNode Comma() { return getToken(StabsParser.Comma, 0); }
		public TerminalNode ParenthesisRight() { return getToken(StabsParser.ParenthesisRight, 0); }
		public CompositeTypeIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compositeTypeID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterCompositeTypeID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitCompositeTypeID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitCompositeTypeID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompositeTypeIDContext compositeTypeID() throws RecognitionException {
		CompositeTypeIDContext _localctx = new CompositeTypeIDContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_compositeTypeID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(ParenthesisLeft);
			setState(177);
			number();
			setState(178);
			match(Comma);
			setState(179);
			number();
			setState(180);
			match(ParenthesisRight);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDescriptionContext extends ParserRuleContext {
		public TerminalNode Equals() { return getToken(StabsParser.Equals, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeDescriptionArrayContext typeDescriptionArray() {
			return getRuleContext(TypeDescriptionArrayContext.class,0);
		}
		public TypeDescriptionAttributeContext typeDescriptionAttribute() {
			return getRuleContext(TypeDescriptionAttributeContext.class,0);
		}
		public TypeDescriptionClassMethodContext typeDescriptionClassMethod() {
			return getRuleContext(TypeDescriptionClassMethodContext.class,0);
		}
		public TypeDescriptionEnumContext typeDescriptionEnum() {
			return getRuleContext(TypeDescriptionEnumContext.class,0);
		}
		public TypeDescriptionFunctionContext typeDescriptionFunction() {
			return getRuleContext(TypeDescriptionFunctionContext.class,0);
		}
		public TypeDescriptionPointerContext typeDescriptionPointer() {
			return getRuleContext(TypeDescriptionPointerContext.class,0);
		}
		public TypeDescriptionRangeContext typeDescriptionRange() {
			return getRuleContext(TypeDescriptionRangeContext.class,0);
		}
		public TypeDescriptionReferenceContext typeDescriptionReference() {
			return getRuleContext(TypeDescriptionReferenceContext.class,0);
		}
		public TypeDescriptionStructUnionClassContext typeDescriptionStructUnionClass() {
			return getRuleContext(TypeDescriptionStructUnionClassContext.class,0);
		}
		public TypeDescriptionXrefContext typeDescriptionXref() {
			return getRuleContext(TypeDescriptionXrefContext.class,0);
		}
		public TypeDescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDescription; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterTypeDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitTypeDescription(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitTypeDescription(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDescriptionContext typeDescription() throws RecognitionException {
		TypeDescriptionContext _localctx = new TypeDescriptionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_typeDescription);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(Equals);
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Number0:
			case Number1:
			case Number2:
			case Number3:
			case Number4:
			case Number5:
			case Number6:
			case Number7:
			case Number8:
			case Number9:
			case ParenthesisLeft:
				{
				setState(183);
				type();
				}
				break;
			case LowercaseA:
				{
				setState(184);
				typeDescriptionArray();
				}
				break;
			case At:
				{
				setState(185);
				typeDescriptionAttribute();
				}
				break;
			case Hash:
				{
				setState(186);
				typeDescriptionClassMethod();
				}
				break;
			case LowercaseE:
				{
				setState(187);
				typeDescriptionEnum();
				}
				break;
			case LowercaseF:
				{
				setState(188);
				typeDescriptionFunction();
				}
				break;
			case Asterisk:
				{
				setState(189);
				typeDescriptionPointer();
				}
				break;
			case LowercaseR:
				{
				setState(190);
				typeDescriptionRange();
				}
				break;
			case Ampersand:
				{
				setState(191);
				typeDescriptionReference();
				}
				break;
			case LowercaseS:
			case LowercaseU:
				{
				setState(192);
				typeDescriptionStructUnionClass();
				}
				break;
			case LowercaseX:
				{
				setState(193);
				typeDescriptionXref();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDescriptionArrayContext extends ParserRuleContext {
		public TerminalNode LowercaseA() { return getToken(StabsParser.LowercaseA, 0); }
		public TypeDescriptionRangeContext typeDescriptionRange() {
			return getRuleContext(TypeDescriptionRangeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeDescriptionArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDescriptionArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterTypeDescriptionArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitTypeDescriptionArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitTypeDescriptionArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDescriptionArrayContext typeDescriptionArray() throws RecognitionException {
		TypeDescriptionArrayContext _localctx = new TypeDescriptionArrayContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_typeDescriptionArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(LowercaseA);
			setState(197);
			typeDescriptionRange();
			setState(198);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDescriptionAttributeContext extends ParserRuleContext {
		public TerminalNode At() { return getToken(StabsParser.At, 0); }
		public List<TerminalNode> Semicolon() { return getTokens(StabsParser.Semicolon); }
		public TerminalNode Semicolon(int i) {
			return getToken(StabsParser.Semicolon, i);
		}
		public TerminalNode Minus() { return getToken(StabsParser.Minus, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public AttributeBoundaryContext attributeBoundary() {
			return getRuleContext(AttributeBoundaryContext.class,0);
		}
		public AttributePackedContext attributePacked() {
			return getRuleContext(AttributePackedContext.class,0);
		}
		public AttributePointerContext attributePointer() {
			return getRuleContext(AttributePointerContext.class,0);
		}
		public AttributeSizeContext attributeSize() {
			return getRuleContext(AttributeSizeContext.class,0);
		}
		public AttributeStringContext attributeString() {
			return getRuleContext(AttributeStringContext.class,0);
		}
		public AttributeVectorContext attributeVector() {
			return getRuleContext(AttributeVectorContext.class,0);
		}
		public TypeDescriptionAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDescriptionAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterTypeDescriptionAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitTypeDescriptionAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitTypeDescriptionAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDescriptionAttributeContext typeDescriptionAttribute() throws RecognitionException {
		TypeDescriptionAttributeContext _localctx = new TypeDescriptionAttributeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_typeDescriptionAttribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(At);
			setState(207);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LowercaseA:
				{
				setState(201);
				attributeBoundary();
				}
				break;
			case UppercaseP:
				{
				setState(202);
				attributePacked();
				}
				break;
			case LowercaseP:
				{
				setState(203);
				attributePointer();
				}
				break;
			case LowercaseS:
				{
				setState(204);
				attributeSize();
				}
				break;
			case UppercaseS:
				{
				setState(205);
				attributeString();
				}
				break;
			case UppercaseV:
				{
				setState(206);
				attributeVector();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(209);
			match(Semicolon);
			setState(210);
			match(Minus);
			setState(211);
			number();
			setState(212);
			match(Semicolon);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDescriptionClassMethodContext extends ParserRuleContext {
		public TerminalNode Hash() { return getToken(StabsParser.Hash, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode Semicolon() { return getToken(StabsParser.Semicolon, 0); }
		public ClassMethodMangledSignatureContext classMethodMangledSignature() {
			return getRuleContext(ClassMethodMangledSignatureContext.class,0);
		}
		public List<TerminalNode> Comma() { return getTokens(StabsParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(StabsParser.Comma, i);
		}
		public TypeDescriptionClassMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDescriptionClassMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterTypeDescriptionClassMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitTypeDescriptionClassMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitTypeDescriptionClassMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDescriptionClassMethodContext typeDescriptionClassMethod() throws RecognitionException {
		TypeDescriptionClassMethodContext _localctx = new TypeDescriptionClassMethodContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_typeDescriptionClassMethod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(Hash);
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Hash) {
				{
				setState(215);
				classMethodMangledSignature();
				}
			}

			setState(218);
			type();
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(219);
				match(Comma);
				setState(220);
				type();
				}
				}
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(226);
			match(Semicolon);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDescriptionEnumContext extends ParserRuleContext {
		public TerminalNode LowercaseE() { return getToken(StabsParser.LowercaseE, 0); }
		public TerminalNode Semicolon() { return getToken(StabsParser.Semicolon, 0); }
		public List<EnumMemberContext> enumMember() {
			return getRuleContexts(EnumMemberContext.class);
		}
		public EnumMemberContext enumMember(int i) {
			return getRuleContext(EnumMemberContext.class,i);
		}
		public TypeDescriptionEnumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDescriptionEnum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterTypeDescriptionEnum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitTypeDescriptionEnum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitTypeDescriptionEnum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDescriptionEnumContext typeDescriptionEnum() throws RecognitionException {
		TypeDescriptionEnumContext _localctx = new TypeDescriptionEnumContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_typeDescriptionEnum);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(LowercaseE);
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1310823L) != 0)) {
				{
				{
				setState(229);
				enumMember();
				}
				}
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(235);
			match(Semicolon);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDescriptionFunctionContext extends ParserRuleContext {
		public TerminalNode LowercaseF() { return getToken(StabsParser.LowercaseF, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeDescriptionFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDescriptionFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterTypeDescriptionFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitTypeDescriptionFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitTypeDescriptionFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDescriptionFunctionContext typeDescriptionFunction() throws RecognitionException {
		TypeDescriptionFunctionContext _localctx = new TypeDescriptionFunctionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_typeDescriptionFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(LowercaseF);
			setState(238);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDescriptionNestedFunctionContext extends ParserRuleContext {
		public TerminalNode LowercaseF() { return getToken(StabsParser.LowercaseF, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> Comma() { return getTokens(StabsParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(StabsParser.Comma, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TypeDescriptionNestedFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDescriptionNestedFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterTypeDescriptionNestedFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitTypeDescriptionNestedFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitTypeDescriptionNestedFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDescriptionNestedFunctionContext typeDescriptionNestedFunction() throws RecognitionException {
		TypeDescriptionNestedFunctionContext _localctx = new TypeDescriptionNestedFunctionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_typeDescriptionNestedFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(LowercaseF);
			setState(241);
			type();
			setState(242);
			match(Comma);
			setState(243);
			identifier();
			setState(244);
			match(Comma);
			setState(245);
			identifier();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDescriptionPointerContext extends ParserRuleContext {
		public TerminalNode Asterisk() { return getToken(StabsParser.Asterisk, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeDescriptionPointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDescriptionPointer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterTypeDescriptionPointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitTypeDescriptionPointer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitTypeDescriptionPointer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDescriptionPointerContext typeDescriptionPointer() throws RecognitionException {
		TypeDescriptionPointerContext _localctx = new TypeDescriptionPointerContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_typeDescriptionPointer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(Asterisk);
			setState(248);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDescriptionRangeContext extends ParserRuleContext {
		public TerminalNode LowercaseR() { return getToken(StabsParser.LowercaseR, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> Semicolon() { return getTokens(StabsParser.Semicolon); }
		public TerminalNode Semicolon(int i) {
			return getToken(StabsParser.Semicolon, i);
		}
		public List<IntegerContext> integer() {
			return getRuleContexts(IntegerContext.class);
		}
		public IntegerContext integer(int i) {
			return getRuleContext(IntegerContext.class,i);
		}
		public TypeDescriptionRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDescriptionRange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterTypeDescriptionRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitTypeDescriptionRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitTypeDescriptionRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDescriptionRangeContext typeDescriptionRange() throws RecognitionException {
		TypeDescriptionRangeContext _localctx = new TypeDescriptionRangeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_typeDescriptionRange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(LowercaseR);
			setState(251);
			type();
			setState(252);
			match(Semicolon);
			setState(253);
			integer();
			setState(254);
			match(Semicolon);
			setState(255);
			integer();
			setState(256);
			match(Semicolon);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDescriptionReferenceContext extends ParserRuleContext {
		public TerminalNode Ampersand() { return getToken(StabsParser.Ampersand, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeDescriptionReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDescriptionReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterTypeDescriptionReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitTypeDescriptionReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitTypeDescriptionReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDescriptionReferenceContext typeDescriptionReference() throws RecognitionException {
		TypeDescriptionReferenceContext _localctx = new TypeDescriptionReferenceContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_typeDescriptionReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(Ampersand);
			setState(259);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDescriptionStructUnionClassContext extends ParserRuleContext {
		public StructUnionTypeContext structUnionType() {
			return getRuleContext(StructUnionTypeContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(StabsParser.Semicolon, 0); }
		public ClassInheritanceInfoContext classInheritanceInfo() {
			return getRuleContext(ClassInheritanceInfoContext.class,0);
		}
		public List<StructUnionClassMemberContext> structUnionClassMember() {
			return getRuleContexts(StructUnionClassMemberContext.class);
		}
		public StructUnionClassMemberContext structUnionClassMember(int i) {
			return getRuleContext(StructUnionClassMemberContext.class,i);
		}
		public ClassVirtualInfoContext classVirtualInfo() {
			return getRuleContext(ClassVirtualInfoContext.class,0);
		}
		public TypeDescriptionStructUnionClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDescriptionStructUnionClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterTypeDescriptionStructUnionClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitTypeDescriptionStructUnionClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitTypeDescriptionStructUnionClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDescriptionStructUnionClassContext typeDescriptionStructUnionClass() throws RecognitionException {
		TypeDescriptionStructUnionClassContext _localctx = new TypeDescriptionStructUnionClassContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_typeDescriptionStructUnionClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			structUnionType();
			setState(262);
			number();
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Exclamation) {
				{
				setState(263);
				classInheritanceInfo();
				}
			}

			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1310823L) != 0)) {
				{
				{
				setState(266);
				structUnionClassMember();
				}
				}
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(272);
				classVirtualInfo();
				}
				break;
			}
			setState(275);
			match(Semicolon);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDescriptionXrefContext extends ParserRuleContext {
		public TerminalNode LowercaseX() { return getToken(StabsParser.LowercaseX, 0); }
		public XrefTypeContext xrefType() {
			return getRuleContext(XrefTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Colon() { return getToken(StabsParser.Colon, 0); }
		public TypeDescriptionXrefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDescriptionXref; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterTypeDescriptionXref(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitTypeDescriptionXref(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitTypeDescriptionXref(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDescriptionXrefContext typeDescriptionXref() throws RecognitionException {
		TypeDescriptionXrefContext _localctx = new TypeDescriptionXrefContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_typeDescriptionXref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(LowercaseX);
			setState(278);
			xrefType();
			setState(279);
			identifier();
			setState(280);
			match(Colon);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeBoundaryContext extends ParserRuleContext {
		public TerminalNode LowercaseA() { return getToken(StabsParser.LowercaseA, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public AttributeBoundaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeBoundary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterAttributeBoundary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitAttributeBoundary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitAttributeBoundary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeBoundaryContext attributeBoundary() throws RecognitionException {
		AttributeBoundaryContext _localctx = new AttributeBoundaryContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_attributeBoundary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			match(LowercaseA);
			setState(283);
			integer();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AttributePackedContext extends ParserRuleContext {
		public TerminalNode UppercaseP() { return getToken(StabsParser.UppercaseP, 0); }
		public AttributePackedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributePacked; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterAttributePacked(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitAttributePacked(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitAttributePacked(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributePackedContext attributePacked() throws RecognitionException {
		AttributePackedContext _localctx = new AttributePackedContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_attributePacked);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(UppercaseP);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AttributePointerContext extends ParserRuleContext {
		public TerminalNode LowercaseP() { return getToken(StabsParser.LowercaseP, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public AttributePointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributePointer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterAttributePointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitAttributePointer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitAttributePointer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributePointerContext attributePointer() throws RecognitionException {
		AttributePointerContext _localctx = new AttributePointerContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_attributePointer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(LowercaseP);
			setState(288);
			integer();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeSizeContext extends ParserRuleContext {
		public TerminalNode LowercaseS() { return getToken(StabsParser.LowercaseS, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public AttributeSizeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeSize; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterAttributeSize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitAttributeSize(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitAttributeSize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeSizeContext attributeSize() throws RecognitionException {
		AttributeSizeContext _localctx = new AttributeSizeContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_attributeSize);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(LowercaseS);
			setState(291);
			number();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeStringContext extends ParserRuleContext {
		public TerminalNode UppercaseS() { return getToken(StabsParser.UppercaseS, 0); }
		public AttributeStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterAttributeString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitAttributeString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitAttributeString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeStringContext attributeString() throws RecognitionException {
		AttributeStringContext _localctx = new AttributeStringContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_attributeString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(UppercaseS);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeVectorContext extends ParserRuleContext {
		public TerminalNode UppercaseV() { return getToken(StabsParser.UppercaseV, 0); }
		public AttributeVectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeVector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterAttributeVector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitAttributeVector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitAttributeVector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeVectorContext attributeVector() throws RecognitionException {
		AttributeVectorContext _localctx = new AttributeVectorContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_attributeVector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(UppercaseV);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassInheritanceInfoContext extends ParserRuleContext {
		public TerminalNode Exclamation() { return getToken(StabsParser.Exclamation, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode Comma() { return getToken(StabsParser.Comma, 0); }
		public List<ClassInheritanceDataContext> classInheritanceData() {
			return getRuleContexts(ClassInheritanceDataContext.class);
		}
		public ClassInheritanceDataContext classInheritanceData(int i) {
			return getRuleContext(ClassInheritanceDataContext.class,i);
		}
		public ClassInheritanceInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classInheritanceInfo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterClassInheritanceInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitClassInheritanceInfo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitClassInheritanceInfo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassInheritanceInfoContext classInheritanceInfo() throws RecognitionException {
		ClassInheritanceInfoContext _localctx = new ClassInheritanceInfoContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_classInheritanceInfo);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(Exclamation);
			setState(298);
			number();
			setState(299);
			match(Comma);
			setState(301); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(300);
					classInheritanceData();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(303); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassInheritanceDataContext extends ParserRuleContext {
		public BooleanContext boolean_() {
			return getRuleContext(BooleanContext.class,0);
		}
		public ClassAccessibilityContext classAccessibility() {
			return getRuleContext(ClassAccessibilityContext.class,0);
		}
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TerminalNode Comma() { return getToken(StabsParser.Comma, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(StabsParser.Semicolon, 0); }
		public ClassInheritanceDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classInheritanceData; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterClassInheritanceData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitClassInheritanceData(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitClassInheritanceData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassInheritanceDataContext classInheritanceData() throws RecognitionException {
		ClassInheritanceDataContext _localctx = new ClassInheritanceDataContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_classInheritanceData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			boolean_();
			setState(306);
			classAccessibility();
			setState(307);
			integer();
			setState(308);
			match(Comma);
			setState(309);
			type();
			setState(310);
			match(Semicolon);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassAccessibilityContext extends ParserRuleContext {
		public TerminalNode Number0() { return getToken(StabsParser.Number0, 0); }
		public TerminalNode Number1() { return getToken(StabsParser.Number1, 0); }
		public TerminalNode Number2() { return getToken(StabsParser.Number2, 0); }
		public ClassAccessibilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classAccessibility; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterClassAccessibility(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitClassAccessibility(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitClassAccessibility(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassAccessibilityContext classAccessibility() throws RecognitionException {
		ClassAccessibilityContext _localctx = new ClassAccessibilityContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_classAccessibility);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 63050394783186944L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassMemberMethodContext extends ParserRuleContext {
		public List<TerminalNode> Colon() { return getTokens(StabsParser.Colon); }
		public TerminalNode Colon(int i) {
			return getToken(StabsParser.Colon, i);
		}
		public TerminalNode Semicolon() { return getToken(StabsParser.Semicolon, 0); }
		public List<ClassMemberMethodOverloadContext> classMemberMethodOverload() {
			return getRuleContexts(ClassMemberMethodOverloadContext.class);
		}
		public ClassMemberMethodOverloadContext classMemberMethodOverload(int i) {
			return getRuleContext(ClassMemberMethodOverloadContext.class,i);
		}
		public ClassMemberMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMemberMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterClassMemberMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitClassMemberMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitClassMemberMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMemberMethodContext classMemberMethod() throws RecognitionException {
		ClassMemberMethodContext _localctx = new ClassMemberMethodContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_classMemberMethod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(Colon);
			setState(315);
			match(Colon);
			setState(317); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(316);
				classMemberMethodOverload();
				}
				}
				setState(319); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 53)) & ~0x3f) == 0 && ((1L << (_la - 53)) & 4195327L) != 0) );
			setState(321);
			match(Semicolon);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassMemberMethodOverloadContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Colon() { return getToken(StabsParser.Colon, 0); }
		public TerminalNode Semicolon() { return getToken(StabsParser.Semicolon, 0); }
		public ClassMemberMethodInfoContext classMemberMethodInfo() {
			return getRuleContext(ClassMemberMethodInfoContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ClassMemberMethodOverloadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMemberMethodOverload; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterClassMemberMethodOverload(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitClassMemberMethodOverload(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitClassMemberMethodOverload(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMemberMethodOverloadContext classMemberMethodOverload() throws RecognitionException {
		ClassMemberMethodOverloadContext _localctx = new ClassMemberMethodOverloadContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_classMemberMethodOverload);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			type();
			setState(324);
			match(Colon);
			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1310823L) != 0)) {
				{
				setState(325);
				identifier();
				}
			}

			setState(328);
			match(Semicolon);
			setState(329);
			classMemberMethodInfo();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassMemberMethodInfoContext extends ParserRuleContext {
		public ClassAccessibilityContext classAccessibility() {
			return getRuleContext(ClassAccessibilityContext.class,0);
		}
		public ClassMemberMethodModifierContext classMemberMethodModifier() {
			return getRuleContext(ClassMemberMethodModifierContext.class,0);
		}
		public TerminalNode Dot() { return getToken(StabsParser.Dot, 0); }
		public ClassMemberMethodStaticContext classMemberMethodStatic() {
			return getRuleContext(ClassMemberMethodStaticContext.class,0);
		}
		public TerminalNode Asterisk() { return getToken(StabsParser.Asterisk, 0); }
		public ClassMemberMethodVirtualInfoContext classMemberMethodVirtualInfo() {
			return getRuleContext(ClassMemberMethodVirtualInfoContext.class,0);
		}
		public ClassMemberMethodInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMemberMethodInfo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterClassMemberMethodInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitClassMemberMethodInfo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitClassMemberMethodInfo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMemberMethodInfoContext classMemberMethodInfo() throws RecognitionException {
		ClassMemberMethodInfoContext _localctx = new ClassMemberMethodInfoContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_classMemberMethodInfo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			classAccessibility();
			setState(332);
			classMemberMethodModifier();
			setState(337);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Dot:
				{
				setState(333);
				match(Dot);
				}
				break;
			case Question:
				{
				setState(334);
				classMemberMethodStatic();
				}
				break;
			case Asterisk:
				{
				setState(335);
				match(Asterisk);
				setState(336);
				classMemberMethodVirtualInfo();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassMemberMethodModifierContext extends ParserRuleContext {
		public TerminalNode UppercaseA() { return getToken(StabsParser.UppercaseA, 0); }
		public TerminalNode UppercaseB() { return getToken(StabsParser.UppercaseB, 0); }
		public TerminalNode UppercaseC() { return getToken(StabsParser.UppercaseC, 0); }
		public TerminalNode UppercaseD() { return getToken(StabsParser.UppercaseD, 0); }
		public ClassMemberMethodModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMemberMethodModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterClassMemberMethodModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitClassMemberMethodModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitClassMemberMethodModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMemberMethodModifierContext classMemberMethodModifier() throws RecognitionException {
		ClassMemberMethodModifierContext _localctx = new ClassMemberMethodModifierContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_classMemberMethodModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassMemberMethodStaticContext extends ParserRuleContext {
		public TerminalNode Question() { return getToken(StabsParser.Question, 0); }
		public ClassMemberMethodStaticContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMemberMethodStatic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterClassMemberMethodStatic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitClassMemberMethodStatic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitClassMemberMethodStatic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMemberMethodStaticContext classMemberMethodStatic() throws RecognitionException {
		ClassMemberMethodStaticContext _localctx = new ClassMemberMethodStaticContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_classMemberMethodStatic);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			match(Question);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassMemberMethodVirtualInfoContext extends ParserRuleContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public List<TerminalNode> Semicolon() { return getTokens(StabsParser.Semicolon); }
		public TerminalNode Semicolon(int i) {
			return getToken(StabsParser.Semicolon, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ClassMemberMethodVirtualInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMemberMethodVirtualInfo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterClassMemberMethodVirtualInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitClassMemberMethodVirtualInfo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitClassMemberMethodVirtualInfo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMemberMethodVirtualInfoContext classMemberMethodVirtualInfo() throws RecognitionException {
		ClassMemberMethodVirtualInfoContext _localctx = new ClassMemberMethodVirtualInfoContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_classMemberMethodVirtualInfo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			integer();
			setState(344);
			match(Semicolon);
			setState(345);
			type();
			setState(346);
			match(Semicolon);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassMemberStaticFieldContext extends ParserRuleContext {
		public List<TerminalNode> Colon() { return getTokens(StabsParser.Colon); }
		public TerminalNode Colon(int i) {
			return getToken(StabsParser.Colon, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(StabsParser.Semicolon, 0); }
		public TerminalNode Slash() { return getToken(StabsParser.Slash, 0); }
		public ClassAccessibilityContext classAccessibility() {
			return getRuleContext(ClassAccessibilityContext.class,0);
		}
		public ClassMemberStaticFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMemberStaticField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterClassMemberStaticField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitClassMemberStaticField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitClassMemberStaticField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMemberStaticFieldContext classMemberStaticField() throws RecognitionException {
		ClassMemberStaticFieldContext _localctx = new ClassMemberStaticFieldContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_classMemberStaticField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			match(Colon);
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Slash) {
				{
				setState(349);
				match(Slash);
				setState(350);
				classAccessibility();
				}
			}

			setState(353);
			type();
			setState(354);
			match(Colon);
			setState(355);
			identifier();
			setState(356);
			match(Semicolon);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassMemberVirtualTableContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode Colon() { return getToken(StabsParser.Colon, 0); }
		public TerminalNode Comma() { return getToken(StabsParser.Comma, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(StabsParser.Semicolon, 0); }
		public ClassMemberVirtualTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMemberVirtualTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterClassMemberVirtualTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitClassMemberVirtualTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitClassMemberVirtualTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMemberVirtualTableContext classMemberVirtualTable() throws RecognitionException {
		ClassMemberVirtualTableContext _localctx = new ClassMemberVirtualTableContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_classMemberVirtualTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			type();
			setState(359);
			match(Colon);
			setState(360);
			type();
			setState(361);
			match(Comma);
			setState(362);
			integer();
			setState(363);
			match(Semicolon);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassMethodMangledSignatureContext extends ParserRuleContext {
		public TerminalNode Hash() { return getToken(StabsParser.Hash, 0); }
		public ClassMethodMangledSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMethodMangledSignature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterClassMethodMangledSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitClassMethodMangledSignature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitClassMethodMangledSignature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMethodMangledSignatureContext classMethodMangledSignature() throws RecognitionException {
		ClassMethodMangledSignatureContext _localctx = new ClassMethodMangledSignatureContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_classMethodMangledSignature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			match(Hash);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EnumMemberContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Colon() { return getToken(StabsParser.Colon, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TerminalNode Comma() { return getToken(StabsParser.Comma, 0); }
		public EnumMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterEnumMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitEnumMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitEnumMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumMemberContext enumMember() throws RecognitionException {
		EnumMemberContext _localctx = new EnumMemberContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_enumMember);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			identifier();
			setState(368);
			match(Colon);
			setState(369);
			integer();
			setState(370);
			match(Comma);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructUnionTypeContext extends ParserRuleContext {
		public TerminalNode LowercaseS() { return getToken(StabsParser.LowercaseS, 0); }
		public TerminalNode LowercaseU() { return getToken(StabsParser.LowercaseU, 0); }
		public StructUnionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structUnionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterStructUnionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitStructUnionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitStructUnionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructUnionTypeContext structUnionType() throws RecognitionException {
		StructUnionTypeContext _localctx = new StructUnionTypeContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_structUnionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			_la = _input.LA(1);
			if ( !(_la==LowercaseS || _la==LowercaseU) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructUnionClassMemberContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public StructUnionClassMemberFieldContext structUnionClassMemberField() {
			return getRuleContext(StructUnionClassMemberFieldContext.class,0);
		}
		public ClassMemberMethodContext classMemberMethod() {
			return getRuleContext(ClassMemberMethodContext.class,0);
		}
		public ClassMemberStaticFieldContext classMemberStaticField() {
			return getRuleContext(ClassMemberStaticFieldContext.class,0);
		}
		public ClassMemberVirtualTableContext classMemberVirtualTable() {
			return getRuleContext(ClassMemberVirtualTableContext.class,0);
		}
		public StructUnionClassMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structUnionClassMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterStructUnionClassMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitStructUnionClassMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitStructUnionClassMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructUnionClassMemberContext structUnionClassMember() throws RecognitionException {
		StructUnionClassMemberContext _localctx = new StructUnionClassMemberContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_structUnionClassMember);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			identifier();
			setState(379);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(375);
				structUnionClassMemberField();
				}
				break;
			case 2:
				{
				setState(376);
				classMemberMethod();
				}
				break;
			case 3:
				{
				setState(377);
				classMemberStaticField();
				}
				break;
			case 4:
				{
				setState(378);
				classMemberVirtualTable();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructUnionClassMemberFieldContext extends ParserRuleContext {
		public TerminalNode Colon() { return getToken(StabsParser.Colon, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> Comma() { return getTokens(StabsParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(StabsParser.Comma, i);
		}
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public TerminalNode Semicolon() { return getToken(StabsParser.Semicolon, 0); }
		public TerminalNode Slash() { return getToken(StabsParser.Slash, 0); }
		public ClassAccessibilityContext classAccessibility() {
			return getRuleContext(ClassAccessibilityContext.class,0);
		}
		public StructUnionClassMemberFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structUnionClassMemberField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterStructUnionClassMemberField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitStructUnionClassMemberField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitStructUnionClassMemberField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructUnionClassMemberFieldContext structUnionClassMemberField() throws RecognitionException {
		StructUnionClassMemberFieldContext _localctx = new StructUnionClassMemberFieldContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_structUnionClassMemberField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			match(Colon);
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Slash) {
				{
				setState(382);
				match(Slash);
				setState(383);
				classAccessibility();
				}
			}

			setState(386);
			type();
			setState(387);
			match(Comma);
			setState(388);
			number();
			setState(389);
			match(Comma);
			setState(390);
			number();
			setState(391);
			match(Semicolon);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassVirtualInfoContext extends ParserRuleContext {
		public TerminalNode Semicolon() { return getToken(StabsParser.Semicolon, 0); }
		public TerminalNode Tilde() { return getToken(StabsParser.Tilde, 0); }
		public TerminalNode Percent() { return getToken(StabsParser.Percent, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ClassVirtualInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classVirtualInfo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterClassVirtualInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitClassVirtualInfo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitClassVirtualInfo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassVirtualInfoContext classVirtualInfo() throws RecognitionException {
		ClassVirtualInfoContext _localctx = new ClassVirtualInfoContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_classVirtualInfo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			match(Semicolon);
			setState(394);
			match(Tilde);
			setState(395);
			match(Percent);
			setState(396);
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

	@SuppressWarnings("CheckReturnValue")
	public static class XrefTypeContext extends ParserRuleContext {
		public TerminalNode LowercaseE() { return getToken(StabsParser.LowercaseE, 0); }
		public TerminalNode LowercaseS() { return getToken(StabsParser.LowercaseS, 0); }
		public TerminalNode LowercaseU() { return getToken(StabsParser.LowercaseU, 0); }
		public XrefTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xrefType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterXrefType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitXrefType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitXrefType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XrefTypeContext xrefType() throws RecognitionException {
		XrefTypeContext _localctx = new XrefTypeContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_xrefType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 175924007927808L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public List<LetterContext> letter() {
			return getRuleContexts(LetterContext.class);
		}
		public LetterContext letter(int i) {
			return getRuleContext(LetterContext.class,i);
		}
		public List<DigitContext> digit() {
			return getRuleContexts(DigitContext.class);
		}
		public DigitContext digit(int i) {
			return getRuleContext(DigitContext.class,i);
		}
		public List<TerminalNode> Ampersand() { return getTokens(StabsParser.Ampersand); }
		public TerminalNode Ampersand(int i) {
			return getToken(StabsParser.Ampersand, i);
		}
		public List<TerminalNode> AngleBracketLeft() { return getTokens(StabsParser.AngleBracketLeft); }
		public TerminalNode AngleBracketLeft(int i) {
			return getToken(StabsParser.AngleBracketLeft, i);
		}
		public List<TerminalNode> AngleBracketRight() { return getTokens(StabsParser.AngleBracketRight); }
		public TerminalNode AngleBracketRight(int i) {
			return getToken(StabsParser.AngleBracketRight, i);
		}
		public List<TerminalNode> Asterisk() { return getTokens(StabsParser.Asterisk); }
		public TerminalNode Asterisk(int i) {
			return getToken(StabsParser.Asterisk, i);
		}
		public List<TerminalNode> Comma() { return getTokens(StabsParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(StabsParser.Comma, i);
		}
		public List<TerminalNode> Dot() { return getTokens(StabsParser.Dot); }
		public TerminalNode Dot(int i) {
			return getToken(StabsParser.Dot, i);
		}
		public List<TerminalNode> Space() { return getTokens(StabsParser.Space); }
		public TerminalNode Space(int i) {
			return getToken(StabsParser.Space, i);
		}
		public List<TerminalNode> Underscore() { return getTokens(StabsParser.Underscore); }
		public TerminalNode Underscore(int i) {
			return getToken(StabsParser.Underscore, i);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_identifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(410); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(410);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case UppercaseA:
					case UppercaseB:
					case UppercaseC:
					case UppercaseD:
					case UppercaseE:
					case UppercaseF:
					case UppercaseG:
					case UppercaseH:
					case UppercaseI:
					case UppercaseJ:
					case UppercaseK:
					case UppercaseL:
					case UppercaseM:
					case UppercaseN:
					case UppercaseO:
					case UppercaseP:
					case UppercaseQ:
					case UppercaseR:
					case UppercaseS:
					case UppercaseT:
					case UppercaseU:
					case UppercaseV:
					case UppercaseW:
					case UppercaseX:
					case UppercaseY:
					case UppercaseZ:
					case LowercaseA:
					case LowercaseB:
					case LowercaseC:
					case LowercaseD:
					case LowercaseE:
					case LowercaseF:
					case LowercaseG:
					case LowercaseH:
					case LowercaseI:
					case LowercaseJ:
					case LowercaseK:
					case LowercaseL:
					case LowercaseM:
					case LowercaseN:
					case LowercaseO:
					case LowercaseP:
					case LowercaseQ:
					case LowercaseR:
					case LowercaseS:
					case LowercaseT:
					case LowercaseU:
					case LowercaseV:
					case LowercaseW:
					case LowercaseX:
					case LowercaseY:
					case LowercaseZ:
						{
						setState(400);
						letter();
						}
						break;
					case Number0:
					case Number1:
					case Number2:
					case Number3:
					case Number4:
					case Number5:
					case Number6:
					case Number7:
					case Number8:
					case Number9:
						{
						setState(401);
						digit();
						}
						break;
					case Ampersand:
						{
						setState(402);
						match(Ampersand);
						}
						break;
					case AngleBracketLeft:
						{
						setState(403);
						match(AngleBracketLeft);
						}
						break;
					case AngleBracketRight:
						{
						setState(404);
						match(AngleBracketRight);
						}
						break;
					case Asterisk:
						{
						setState(405);
						match(Asterisk);
						}
						break;
					case Comma:
						{
						setState(406);
						match(Comma);
						}
						break;
					case Dot:
						{
						setState(407);
						match(Dot);
						}
						break;
					case Space:
						{
						setState(408);
						match(Space);
						}
						break;
					case Underscore:
						{
						setState(409);
						match(Underscore);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(412); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	@SuppressWarnings("CheckReturnValue")
	public static class LetterContext extends ParserRuleContext {
		public TerminalNode UppercaseA() { return getToken(StabsParser.UppercaseA, 0); }
		public TerminalNode UppercaseB() { return getToken(StabsParser.UppercaseB, 0); }
		public TerminalNode UppercaseC() { return getToken(StabsParser.UppercaseC, 0); }
		public TerminalNode UppercaseD() { return getToken(StabsParser.UppercaseD, 0); }
		public TerminalNode UppercaseE() { return getToken(StabsParser.UppercaseE, 0); }
		public TerminalNode UppercaseF() { return getToken(StabsParser.UppercaseF, 0); }
		public TerminalNode UppercaseG() { return getToken(StabsParser.UppercaseG, 0); }
		public TerminalNode UppercaseH() { return getToken(StabsParser.UppercaseH, 0); }
		public TerminalNode UppercaseI() { return getToken(StabsParser.UppercaseI, 0); }
		public TerminalNode UppercaseJ() { return getToken(StabsParser.UppercaseJ, 0); }
		public TerminalNode UppercaseK() { return getToken(StabsParser.UppercaseK, 0); }
		public TerminalNode UppercaseL() { return getToken(StabsParser.UppercaseL, 0); }
		public TerminalNode UppercaseM() { return getToken(StabsParser.UppercaseM, 0); }
		public TerminalNode UppercaseN() { return getToken(StabsParser.UppercaseN, 0); }
		public TerminalNode UppercaseO() { return getToken(StabsParser.UppercaseO, 0); }
		public TerminalNode UppercaseP() { return getToken(StabsParser.UppercaseP, 0); }
		public TerminalNode UppercaseQ() { return getToken(StabsParser.UppercaseQ, 0); }
		public TerminalNode UppercaseR() { return getToken(StabsParser.UppercaseR, 0); }
		public TerminalNode UppercaseS() { return getToken(StabsParser.UppercaseS, 0); }
		public TerminalNode UppercaseT() { return getToken(StabsParser.UppercaseT, 0); }
		public TerminalNode UppercaseU() { return getToken(StabsParser.UppercaseU, 0); }
		public TerminalNode UppercaseV() { return getToken(StabsParser.UppercaseV, 0); }
		public TerminalNode UppercaseW() { return getToken(StabsParser.UppercaseW, 0); }
		public TerminalNode UppercaseX() { return getToken(StabsParser.UppercaseX, 0); }
		public TerminalNode UppercaseY() { return getToken(StabsParser.UppercaseY, 0); }
		public TerminalNode UppercaseZ() { return getToken(StabsParser.UppercaseZ, 0); }
		public TerminalNode LowercaseA() { return getToken(StabsParser.LowercaseA, 0); }
		public TerminalNode LowercaseB() { return getToken(StabsParser.LowercaseB, 0); }
		public TerminalNode LowercaseC() { return getToken(StabsParser.LowercaseC, 0); }
		public TerminalNode LowercaseD() { return getToken(StabsParser.LowercaseD, 0); }
		public TerminalNode LowercaseE() { return getToken(StabsParser.LowercaseE, 0); }
		public TerminalNode LowercaseF() { return getToken(StabsParser.LowercaseF, 0); }
		public TerminalNode LowercaseG() { return getToken(StabsParser.LowercaseG, 0); }
		public TerminalNode LowercaseH() { return getToken(StabsParser.LowercaseH, 0); }
		public TerminalNode LowercaseI() { return getToken(StabsParser.LowercaseI, 0); }
		public TerminalNode LowercaseJ() { return getToken(StabsParser.LowercaseJ, 0); }
		public TerminalNode LowercaseK() { return getToken(StabsParser.LowercaseK, 0); }
		public TerminalNode LowercaseL() { return getToken(StabsParser.LowercaseL, 0); }
		public TerminalNode LowercaseM() { return getToken(StabsParser.LowercaseM, 0); }
		public TerminalNode LowercaseN() { return getToken(StabsParser.LowercaseN, 0); }
		public TerminalNode LowercaseO() { return getToken(StabsParser.LowercaseO, 0); }
		public TerminalNode LowercaseP() { return getToken(StabsParser.LowercaseP, 0); }
		public TerminalNode LowercaseQ() { return getToken(StabsParser.LowercaseQ, 0); }
		public TerminalNode LowercaseR() { return getToken(StabsParser.LowercaseR, 0); }
		public TerminalNode LowercaseS() { return getToken(StabsParser.LowercaseS, 0); }
		public TerminalNode LowercaseT() { return getToken(StabsParser.LowercaseT, 0); }
		public TerminalNode LowercaseU() { return getToken(StabsParser.LowercaseU, 0); }
		public TerminalNode LowercaseV() { return getToken(StabsParser.LowercaseV, 0); }
		public TerminalNode LowercaseW() { return getToken(StabsParser.LowercaseW, 0); }
		public TerminalNode LowercaseX() { return getToken(StabsParser.LowercaseX, 0); }
		public TerminalNode LowercaseY() { return getToken(StabsParser.LowercaseY, 0); }
		public TerminalNode LowercaseZ() { return getToken(StabsParser.LowercaseZ, 0); }
		public LetterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterLetter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitLetter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitLetter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetterContext letter() throws RecognitionException {
		LetterContext _localctx = new LetterContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_letter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 9007199254740990L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends ParserRuleContext {
		public TerminalNode Number0() { return getToken(StabsParser.Number0, 0); }
		public TerminalNode Number1() { return getToken(StabsParser.Number1, 0); }
		public BooleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanContext boolean_() throws RecognitionException {
		BooleanContext _localctx = new BooleanContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_boolean);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			_la = _input.LA(1);
			if ( !(_la==Number0 || _la==Number1) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IntegerContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode Plus() { return getToken(StabsParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(StabsParser.Minus, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Minus || _la==Plus) {
				{
				setState(418);
				_la = _input.LA(1);
				if ( !(_la==Minus || _la==Plus) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(421);
			number();
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

	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ParserRuleContext {
		public List<DigitContext> digit() {
			return getRuleContexts(DigitContext.class);
		}
		public DigitContext digit(int i) {
			return getRuleContext(DigitContext.class,i);
		}
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_number);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(424); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(423);
					digit();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(426); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	@SuppressWarnings("CheckReturnValue")
	public static class DigitContext extends ParserRuleContext {
		public TerminalNode Number0() { return getToken(StabsParser.Number0, 0); }
		public TerminalNode Number1() { return getToken(StabsParser.Number1, 0); }
		public TerminalNode Number2() { return getToken(StabsParser.Number2, 0); }
		public TerminalNode Number3() { return getToken(StabsParser.Number3, 0); }
		public TerminalNode Number4() { return getToken(StabsParser.Number4, 0); }
		public TerminalNode Number5() { return getToken(StabsParser.Number5, 0); }
		public TerminalNode Number6() { return getToken(StabsParser.Number6, 0); }
		public TerminalNode Number7() { return getToken(StabsParser.Number7, 0); }
		public TerminalNode Number8() { return getToken(StabsParser.Number8, 0); }
		public TerminalNode Number9() { return getToken(StabsParser.Number9, 0); }
		public DigitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_digit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).enterDigit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StabsParserListener ) ((StabsParserListener)listener).exitDigit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StabsParserVisitor ) return ((StabsParserVisitor<? extends T>)visitor).visitDigit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DigitContext digit() throws RecognitionException {
		DigitContext _localctx = new DigitContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_digit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 9214364837600034816L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\u0004\u0001T\u01af\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0003\u0000|\b\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001\u008c\b\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0003\u000e\u00a9\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u00ad\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00c3"+
		"\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003"+
		"\u0014\u00d0\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0003\u0015\u00d9\b\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0005\u0015\u00de\b\u0015\n\u0015\f\u0015\u00e1\t\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0005\u0016\u00e7\b\u0016"+
		"\n\u0016\f\u0016\u00ea\t\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0003\u001c\u0109\b\u001c\u0001\u001c\u0005\u001c\u010c"+
		"\b\u001c\n\u001c\f\u001c\u010f\t\u001c\u0001\u001c\u0003\u001c\u0112\b"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001"+
		"\u001f\u0001 \u0001 \u0001 \u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001"+
		"#\u0001#\u0001$\u0001$\u0001$\u0001$\u0004$\u012e\b$\u000b$\f$\u012f\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001\'\u0001"+
		"\'\u0001\'\u0004\'\u013e\b\'\u000b\'\f\'\u013f\u0001\'\u0001\'\u0001("+
		"\u0001(\u0001(\u0003(\u0147\b(\u0001(\u0001(\u0001(\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0003)\u0152\b)\u0001*\u0001*\u0001+\u0001+\u0001"+
		",\u0001,\u0001,\u0001,\u0001,\u0001-\u0001-\u0001-\u0003-\u0160\b-\u0001"+
		"-\u0001-\u0001-\u0001-\u0001-\u0001.\u0001.\u0001.\u0001.\u0001.\u0001"+
		".\u0001.\u0001/\u0001/\u00010\u00010\u00010\u00010\u00010\u00011\u0001"+
		"1\u00012\u00012\u00012\u00012\u00012\u00032\u017c\b2\u00013\u00013\u0001"+
		"3\u00033\u0181\b3\u00013\u00013\u00013\u00013\u00013\u00013\u00013\u0001"+
		"4\u00014\u00014\u00014\u00014\u00015\u00015\u00016\u00016\u00016\u0001"+
		"6\u00016\u00016\u00016\u00016\u00016\u00016\u00046\u019b\b6\u000b6\f6"+
		"\u019c\u00017\u00017\u00018\u00018\u00019\u00039\u01a4\b9\u00019\u0001"+
		"9\u0001:\u0004:\u01a9\b:\u000b:\f:\u01aa\u0001;\u0001;\u0001;\u0000\u0000"+
		"<\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtv\u0000\b\u0001"+
		"\u000057\u0001\u0000\u0001\u0004\u0002\u0000--//\u0003\u0000\u001f\u001f"+
		"--//\u0001\u0000\u00014\u0001\u000056\u0002\u0000JJNN\u0001\u00005>\u01ab"+
		"\u0000x\u0001\u0000\u0000\u0000\u0002\u008b\u0001\u0000\u0000\u0000\u0004"+
		"\u008d\u0001\u0000\u0000\u0000\u0006\u008f\u0001\u0000\u0000\u0000\b\u0091"+
		"\u0001\u0000\u0000\u0000\n\u0093\u0001\u0000\u0000\u0000\f\u0095\u0001"+
		"\u0000\u0000\u0000\u000e\u0097\u0001\u0000\u0000\u0000\u0010\u0099\u0001"+
		"\u0000\u0000\u0000\u0012\u009b\u0001\u0000\u0000\u0000\u0014\u009d\u0001"+
		"\u0000\u0000\u0000\u0016\u00a0\u0001\u0000\u0000\u0000\u0018\u00a2\u0001"+
		"\u0000\u0000\u0000\u001a\u00a4\u0001\u0000\u0000\u0000\u001c\u00a6\u0001"+
		"\u0000\u0000\u0000\u001e\u00ac\u0001\u0000\u0000\u0000 \u00ae\u0001\u0000"+
		"\u0000\u0000\"\u00b0\u0001\u0000\u0000\u0000$\u00b6\u0001\u0000\u0000"+
		"\u0000&\u00c4\u0001\u0000\u0000\u0000(\u00c8\u0001\u0000\u0000\u0000*"+
		"\u00d6\u0001\u0000\u0000\u0000,\u00e4\u0001\u0000\u0000\u0000.\u00ed\u0001"+
		"\u0000\u0000\u00000\u00f0\u0001\u0000\u0000\u00002\u00f7\u0001\u0000\u0000"+
		"\u00004\u00fa\u0001\u0000\u0000\u00006\u0102\u0001\u0000\u0000\u00008"+
		"\u0105\u0001\u0000\u0000\u0000:\u0115\u0001\u0000\u0000\u0000<\u011a\u0001"+
		"\u0000\u0000\u0000>\u011d\u0001\u0000\u0000\u0000@\u011f\u0001\u0000\u0000"+
		"\u0000B\u0122\u0001\u0000\u0000\u0000D\u0125\u0001\u0000\u0000\u0000F"+
		"\u0127\u0001\u0000\u0000\u0000H\u0129\u0001\u0000\u0000\u0000J\u0131\u0001"+
		"\u0000\u0000\u0000L\u0138\u0001\u0000\u0000\u0000N\u013a\u0001\u0000\u0000"+
		"\u0000P\u0143\u0001\u0000\u0000\u0000R\u014b\u0001\u0000\u0000\u0000T"+
		"\u0153\u0001\u0000\u0000\u0000V\u0155\u0001\u0000\u0000\u0000X\u0157\u0001"+
		"\u0000\u0000\u0000Z\u015c\u0001\u0000\u0000\u0000\\\u0166\u0001\u0000"+
		"\u0000\u0000^\u016d\u0001\u0000\u0000\u0000`\u016f\u0001\u0000\u0000\u0000"+
		"b\u0174\u0001\u0000\u0000\u0000d\u0176\u0001\u0000\u0000\u0000f\u017d"+
		"\u0001\u0000\u0000\u0000h\u0189\u0001\u0000\u0000\u0000j\u018e\u0001\u0000"+
		"\u0000\u0000l\u019a\u0001\u0000\u0000\u0000n\u019e\u0001\u0000\u0000\u0000"+
		"p\u01a0\u0001\u0000\u0000\u0000r\u01a3\u0001\u0000\u0000\u0000t\u01a8"+
		"\u0001\u0000\u0000\u0000v\u01ac\u0001\u0000\u0000\u0000xy\u0003l6\u0000"+
		"y{\u0005D\u0000\u0000z|\u0003\u0002\u0001\u0000{z\u0001\u0000\u0000\u0000"+
		"{|\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0003\u001c\u000e"+
		"\u0000~\u0001\u0001\u0000\u0000\u0000\u007f\u008c\u0003\u0004\u0002\u0000"+
		"\u0080\u008c\u0003\u0006\u0003\u0000\u0081\u008c\u0003\b\u0004\u0000\u0082"+
		"\u008c\u0003\n\u0005\u0000\u0083\u008c\u0003\f\u0006\u0000\u0084\u008c"+
		"\u0003\u000e\u0007\u0000\u0085\u008c\u0003\u0010\b\u0000\u0086\u008c\u0003"+
		"\u0012\t\u0000\u0087\u008c\u0003\u0014\n\u0000\u0088\u008c\u0003\u0016"+
		"\u000b\u0000\u0089\u008c\u0003\u0018\f\u0000\u008a\u008c\u0003\u001a\r"+
		"\u0000\u008b\u007f\u0001\u0000\u0000\u0000\u008b\u0080\u0001\u0000\u0000"+
		"\u0000\u008b\u0081\u0001\u0000\u0000\u0000\u008b\u0082\u0001\u0000\u0000"+
		"\u0000\u008b\u0083\u0001\u0000\u0000\u0000\u008b\u0084\u0001\u0000\u0000"+
		"\u0000\u008b\u0085\u0001\u0000\u0000\u0000\u008b\u0086\u0001\u0000\u0000"+
		"\u0000\u008b\u0087\u0001\u0000\u0000\u0000\u008b\u0088\u0001\u0000\u0000"+
		"\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008a\u0001\u0000\u0000"+
		"\u0000\u008c\u0003\u0001\u0000\u0000\u0000\u008d\u008e\u0005\u001b\u0000"+
		"\u0000\u008e\u0005\u0001\u0000\u0000\u0000\u008f\u0090\u0005\u0006\u0000"+
		"\u0000\u0090\u0007\u0001\u0000\u0000\u0000\u0091\u0092\u0005 \u0000\u0000"+
		"\u0092\t\u0001\u0000\u0000\u0000\u0093\u0094\u0005\u0007\u0000\u0000\u0094"+
		"\u000b\u0001\u0000\u0000\u0000\u0095\u0096\u0005\u0010\u0000\u0000\u0096"+
		"\r\u0001\u0000\u0000\u0000\u0097\u0098\u0005*\u0000\u0000\u0098\u000f"+
		"\u0001\u0000\u0000\u0000\u0099\u009a\u0005,\u0000\u0000\u009a\u0011\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\u0005\u0013\u0000\u0000\u009c\u0013\u0001"+
		"\u0000\u0000\u0000\u009d\u009e\u0005\u0014\u0000\u0000\u009e\u009f\u0005"+
		".\u0000\u0000\u009f\u0015\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005\u0014"+
		"\u0000\u0000\u00a1\u0017\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005.\u0000"+
		"\u0000\u00a3\u0019\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005\u0016\u0000"+
		"\u0000\u00a5\u001b\u0001\u0000\u0000\u0000\u00a6\u00a8\u0003\u001e\u000f"+
		"\u0000\u00a7\u00a9\u0003$\u0012\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u001d\u0001\u0000\u0000\u0000"+
		"\u00aa\u00ad\u0003 \u0010\u0000\u00ab\u00ad\u0003\"\u0011\u0000\u00ac"+
		"\u00aa\u0001\u0000\u0000\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ad"+
		"\u001f\u0001\u0000\u0000\u0000\u00ae\u00af\u0003t:\u0000\u00af!\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b1\u0005K\u0000\u0000\u00b1\u00b2\u0003t:"+
		"\u0000\u00b2\u00b3\u0005E\u0000\u0000\u00b3\u00b4\u0003t:\u0000\u00b4"+
		"\u00b5\u0005L\u0000\u0000\u00b5#\u0001\u0000\u0000\u0000\u00b6\u00c2\u0005"+
		"G\u0000\u0000\u00b7\u00c3\u0003\u001c\u000e\u0000\u00b8\u00c3\u0003&\u0013"+
		"\u0000\u00b9\u00c3\u0003(\u0014\u0000\u00ba\u00c3\u0003*\u0015\u0000\u00bb"+
		"\u00c3\u0003,\u0016\u0000\u00bc\u00c3\u0003.\u0017\u0000\u00bd\u00c3\u0003"+
		"2\u0019\u0000\u00be\u00c3\u00034\u001a\u0000\u00bf\u00c3\u00036\u001b"+
		"\u0000\u00c0\u00c3\u00038\u001c\u0000\u00c1\u00c3\u0003:\u001d\u0000\u00c2"+
		"\u00b7\u0001\u0000\u0000\u0000\u00c2\u00b8\u0001\u0000\u0000\u0000\u00c2"+
		"\u00b9\u0001\u0000\u0000\u0000\u00c2\u00ba\u0001\u0000\u0000\u0000\u00c2"+
		"\u00bb\u0001\u0000\u0000\u0000\u00c2\u00bc\u0001\u0000\u0000\u0000\u00c2"+
		"\u00bd\u0001\u0000\u0000\u0000\u00c2\u00be\u0001\u0000\u0000\u0000\u00c2"+
		"\u00bf\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c3%\u0001\u0000\u0000\u0000\u00c4\u00c5"+
		"\u0005\u001b\u0000\u0000\u00c5\u00c6\u00034\u001a\u0000\u00c6\u00c7\u0003"+
		"\u001c\u000e\u0000\u00c7\'\u0001\u0000\u0000\u0000\u00c8\u00cf\u0005C"+
		"\u0000\u0000\u00c9\u00d0\u0003<\u001e\u0000\u00ca\u00d0\u0003>\u001f\u0000"+
		"\u00cb\u00d0\u0003@ \u0000\u00cc\u00d0\u0003B!\u0000\u00cd\u00d0\u0003"+
		"D\"\u0000\u00ce\u00d0\u0003F#\u0000\u00cf\u00c9\u0001\u0000\u0000\u0000"+
		"\u00cf\u00ca\u0001\u0000\u0000\u0000\u00cf\u00cb\u0001\u0000\u0000\u0000"+
		"\u00cf\u00cc\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000"+
		"\u00cf\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000"+
		"\u00d1\u00d2\u0005P\u0000\u0000\u00d2\u00d3\u0005J\u0000\u0000\u00d3\u00d4"+
		"\u0003t:\u0000\u00d4\u00d5\u0005P\u0000\u0000\u00d5)\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d8\u0005I\u0000\u0000\u00d7\u00d9\u0003^/\u0000\u00d8"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9"+
		"\u00da\u0001\u0000\u0000\u0000\u00da\u00df\u0003\u001c\u000e\u0000\u00db"+
		"\u00dc\u0005E\u0000\u0000\u00dc\u00de\u0003\u001c\u000e\u0000\u00dd\u00db"+
		"\u0001\u0000\u0000\u0000\u00de\u00e1\u0001\u0000\u0000\u0000\u00df\u00dd"+
		"\u0001\u0000\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e2"+
		"\u0001\u0000\u0000\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e2\u00e3"+
		"\u0005P\u0000\u0000\u00e3+\u0001\u0000\u0000\u0000\u00e4\u00e8\u0005\u001f"+
		"\u0000\u0000\u00e5\u00e7\u0003`0\u0000\u00e6\u00e5\u0001\u0000\u0000\u0000"+
		"\u00e7\u00ea\u0001\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000"+
		"\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u00eb\u0001\u0000\u0000\u0000"+
		"\u00ea\u00e8\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005P\u0000\u0000\u00ec"+
		"-\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005 \u0000\u0000\u00ee\u00ef\u0003"+
		"\u001c\u000e\u0000\u00ef/\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005 \u0000"+
		"\u0000\u00f1\u00f2\u0003\u001c\u000e\u0000\u00f2\u00f3\u0005E\u0000\u0000"+
		"\u00f3\u00f4\u0003l6\u0000\u00f4\u00f5\u0005E\u0000\u0000\u00f5\u00f6"+
		"\u0003l6\u0000\u00f61\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005B\u0000"+
		"\u0000\u00f8\u00f9\u0003\u001c\u000e\u0000\u00f93\u0001\u0000\u0000\u0000"+
		"\u00fa\u00fb\u0005,\u0000\u0000\u00fb\u00fc\u0003\u001c\u000e\u0000\u00fc"+
		"\u00fd\u0005P\u0000\u0000\u00fd\u00fe\u0003r9\u0000\u00fe\u00ff\u0005"+
		"P\u0000\u0000\u00ff\u0100\u0003r9\u0000\u0100\u0101\u0005P\u0000\u0000"+
		"\u01015\u0001\u0000\u0000\u0000\u0102\u0103\u0005?\u0000\u0000\u0103\u0104"+
		"\u0003\u001c\u000e\u0000\u01047\u0001\u0000\u0000\u0000\u0105\u0106\u0003"+
		"b1\u0000\u0106\u0108\u0003t:\u0000\u0107\u0109\u0003H$\u0000\u0108\u0107"+
		"\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\u010d"+
		"\u0001\u0000\u0000\u0000\u010a\u010c\u0003d2\u0000\u010b\u010a\u0001\u0000"+
		"\u0000\u0000\u010c\u010f\u0001\u0000\u0000\u0000\u010d\u010b\u0001\u0000"+
		"\u0000\u0000\u010d\u010e\u0001\u0000\u0000\u0000\u010e\u0111\u0001\u0000"+
		"\u0000\u0000\u010f\u010d\u0001\u0000\u0000\u0000\u0110\u0112\u0003h4\u0000"+
		"\u0111\u0110\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000"+
		"\u0112\u0113\u0001\u0000\u0000\u0000\u0113\u0114\u0005P\u0000\u0000\u0114"+
		"9\u0001\u0000\u0000\u0000\u0115\u0116\u00052\u0000\u0000\u0116\u0117\u0003"+
		"j5\u0000\u0117\u0118\u0003l6\u0000\u0118\u0119\u0005D\u0000\u0000\u0119"+
		";\u0001\u0000\u0000\u0000\u011a\u011b\u0005\u001b\u0000\u0000\u011b\u011c"+
		"\u0003r9\u0000\u011c=\u0001\u0000\u0000\u0000\u011d\u011e\u0005\u0010"+
		"\u0000\u0000\u011e?\u0001\u0000\u0000\u0000\u011f\u0120\u0005*\u0000\u0000"+
		"\u0120\u0121\u0003r9\u0000\u0121A\u0001\u0000\u0000\u0000\u0122\u0123"+
		"\u0005-\u0000\u0000\u0123\u0124\u0003t:\u0000\u0124C\u0001\u0000\u0000"+
		"\u0000\u0125\u0126\u0005\u0013\u0000\u0000\u0126E\u0001\u0000\u0000\u0000"+
		"\u0127\u0128\u0005\u0016\u0000\u0000\u0128G\u0001\u0000\u0000\u0000\u0129"+
		"\u012a\u0005H\u0000\u0000\u012a\u012b\u0003t:\u0000\u012b\u012d\u0005"+
		"E\u0000\u0000\u012c\u012e\u0003J%\u0000\u012d\u012c\u0001\u0000\u0000"+
		"\u0000\u012e\u012f\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000\u0000"+
		"\u0000\u012f\u0130\u0001\u0000\u0000\u0000\u0130I\u0001\u0000\u0000\u0000"+
		"\u0131\u0132\u0003p8\u0000\u0132\u0133\u0003L&\u0000\u0133\u0134\u0003"+
		"r9\u0000\u0134\u0135\u0005E\u0000\u0000\u0135\u0136\u0003\u001c\u000e"+
		"\u0000\u0136\u0137\u0005P\u0000\u0000\u0137K\u0001\u0000\u0000\u0000\u0138"+
		"\u0139\u0007\u0000\u0000\u0000\u0139M\u0001\u0000\u0000\u0000\u013a\u013b"+
		"\u0005D\u0000\u0000\u013b\u013d\u0005D\u0000\u0000\u013c\u013e\u0003P"+
		"(\u0000\u013d\u013c\u0001\u0000\u0000\u0000\u013e\u013f\u0001\u0000\u0000"+
		"\u0000\u013f\u013d\u0001\u0000\u0000\u0000\u013f\u0140\u0001\u0000\u0000"+
		"\u0000\u0140\u0141\u0001\u0000\u0000\u0000\u0141\u0142\u0005P\u0000\u0000"+
		"\u0142O\u0001\u0000\u0000\u0000\u0143\u0144\u0003\u001c\u000e\u0000\u0144"+
		"\u0146\u0005D\u0000\u0000\u0145\u0147\u0003l6\u0000\u0146\u0145\u0001"+
		"\u0000\u0000\u0000\u0146\u0147\u0001\u0000\u0000\u0000\u0147\u0148\u0001"+
		"\u0000\u0000\u0000\u0148\u0149\u0005P\u0000\u0000\u0149\u014a\u0003R)"+
		"\u0000\u014aQ\u0001\u0000\u0000\u0000\u014b\u014c\u0003L&\u0000\u014c"+
		"\u0151\u0003T*\u0000\u014d\u0152\u0005F\u0000\u0000\u014e\u0152\u0003"+
		"V+\u0000\u014f\u0150\u0005B\u0000\u0000\u0150\u0152\u0003X,\u0000\u0151"+
		"\u014d\u0001\u0000\u0000\u0000\u0151\u014e\u0001\u0000\u0000\u0000\u0151"+
		"\u014f\u0001\u0000\u0000\u0000\u0152S\u0001\u0000\u0000\u0000\u0153\u0154"+
		"\u0007\u0001\u0000\u0000\u0154U\u0001\u0000\u0000\u0000\u0155\u0156\u0005"+
		"O\u0000\u0000\u0156W\u0001\u0000\u0000\u0000\u0157\u0158\u0003r9\u0000"+
		"\u0158\u0159\u0005P\u0000\u0000\u0159\u015a\u0003\u001c\u000e\u0000\u015a"+
		"\u015b\u0005P\u0000\u0000\u015bY\u0001\u0000\u0000\u0000\u015c\u015f\u0005"+
		"D\u0000\u0000\u015d\u015e\u0005Q\u0000\u0000\u015e\u0160\u0003L&\u0000"+
		"\u015f\u015d\u0001\u0000\u0000\u0000\u015f\u0160\u0001\u0000\u0000\u0000"+
		"\u0160\u0161\u0001\u0000\u0000\u0000\u0161\u0162\u0003\u001c\u000e\u0000"+
		"\u0162\u0163\u0005D\u0000\u0000\u0163\u0164\u0003l6\u0000\u0164\u0165"+
		"\u0005P\u0000\u0000\u0165[\u0001\u0000\u0000\u0000\u0166\u0167\u0003\u001c"+
		"\u000e\u0000\u0167\u0168\u0005D\u0000\u0000\u0168\u0169\u0003\u001c\u000e"+
		"\u0000\u0169\u016a\u0005E\u0000\u0000\u016a\u016b\u0003r9\u0000\u016b"+
		"\u016c\u0005P\u0000\u0000\u016c]\u0001\u0000\u0000\u0000\u016d\u016e\u0005"+
		"I\u0000\u0000\u016e_\u0001\u0000\u0000\u0000\u016f\u0170\u0003l6\u0000"+
		"\u0170\u0171\u0005D\u0000\u0000\u0171\u0172\u0003r9\u0000\u0172\u0173"+
		"\u0005E\u0000\u0000\u0173a\u0001\u0000\u0000\u0000\u0174\u0175\u0007\u0002"+
		"\u0000\u0000\u0175c\u0001\u0000\u0000\u0000\u0176\u017b\u0003l6\u0000"+
		"\u0177\u017c\u0003f3\u0000\u0178\u017c\u0003N\'\u0000\u0179\u017c\u0003"+
		"Z-\u0000\u017a\u017c\u0003\\.\u0000\u017b\u0177\u0001\u0000\u0000\u0000"+
		"\u017b\u0178\u0001\u0000\u0000\u0000\u017b\u0179\u0001\u0000\u0000\u0000"+
		"\u017b\u017a\u0001\u0000\u0000\u0000\u017ce\u0001\u0000\u0000\u0000\u017d"+
		"\u0180\u0005D\u0000\u0000\u017e\u017f\u0005Q\u0000\u0000\u017f\u0181\u0003"+
		"L&\u0000\u0180\u017e\u0001\u0000\u0000\u0000\u0180\u0181\u0001\u0000\u0000"+
		"\u0000\u0181\u0182\u0001\u0000\u0000\u0000\u0182\u0183\u0003\u001c\u000e"+
		"\u0000\u0183\u0184\u0005E\u0000\u0000\u0184\u0185\u0003t:\u0000\u0185"+
		"\u0186\u0005E\u0000\u0000\u0186\u0187\u0003t:\u0000\u0187\u0188\u0005"+
		"P\u0000\u0000\u0188g\u0001\u0000\u0000\u0000\u0189\u018a\u0005P\u0000"+
		"\u0000\u018a\u018b\u0005S\u0000\u0000\u018b\u018c\u0005M\u0000\u0000\u018c"+
		"\u018d\u0003\u001c\u000e\u0000\u018di\u0001\u0000\u0000\u0000\u018e\u018f"+
		"\u0007\u0003\u0000\u0000\u018fk\u0001\u0000\u0000\u0000\u0190\u019b\u0003"+
		"n7\u0000\u0191\u019b\u0003v;\u0000\u0192\u019b\u0005?\u0000\u0000\u0193"+
		"\u019b\u0005@\u0000\u0000\u0194\u019b\u0005A\u0000\u0000\u0195\u019b\u0005"+
		"B\u0000\u0000\u0196\u019b\u0005E\u0000\u0000\u0197\u019b\u0005F\u0000"+
		"\u0000\u0198\u019b\u0005R\u0000\u0000\u0199\u019b\u0005T\u0000\u0000\u019a"+
		"\u0190\u0001\u0000\u0000\u0000\u019a\u0191\u0001\u0000\u0000\u0000\u019a"+
		"\u0192\u0001\u0000\u0000\u0000\u019a\u0193\u0001\u0000\u0000\u0000\u019a"+
		"\u0194\u0001\u0000\u0000\u0000\u019a\u0195\u0001\u0000\u0000\u0000\u019a"+
		"\u0196\u0001\u0000\u0000\u0000\u019a\u0197\u0001\u0000\u0000\u0000\u019a"+
		"\u0198\u0001\u0000\u0000\u0000\u019a\u0199\u0001\u0000\u0000\u0000\u019b"+
		"\u019c\u0001\u0000\u0000\u0000\u019c\u019a\u0001\u0000\u0000\u0000\u019c"+
		"\u019d\u0001\u0000\u0000\u0000\u019dm\u0001\u0000\u0000\u0000\u019e\u019f"+
		"\u0007\u0004\u0000\u0000\u019fo\u0001\u0000\u0000\u0000\u01a0\u01a1\u0007"+
		"\u0005\u0000\u0000\u01a1q\u0001\u0000\u0000\u0000\u01a2\u01a4\u0007\u0006"+
		"\u0000\u0000\u01a3\u01a2\u0001\u0000\u0000\u0000\u01a3\u01a4\u0001\u0000"+
		"\u0000\u0000\u01a4\u01a5\u0001\u0000\u0000\u0000\u01a5\u01a6\u0003t:\u0000"+
		"\u01a6s\u0001\u0000\u0000\u0000\u01a7\u01a9\u0003v;\u0000\u01a8\u01a7"+
		"\u0001\u0000\u0000\u0000\u01a9\u01aa\u0001\u0000\u0000\u0000\u01aa\u01a8"+
		"\u0001\u0000\u0000\u0000\u01aa\u01ab\u0001\u0000\u0000\u0000\u01abu\u0001"+
		"\u0000\u0000\u0000\u01ac\u01ad\u0007\u0007\u0000\u0000\u01adw\u0001\u0000"+
		"\u0000\u0000\u0017{\u008b\u00a8\u00ac\u00c2\u00cf\u00d8\u00df\u00e8\u0108"+
		"\u010d\u0111\u012f\u013f\u0146\u0151\u015f\u017b\u0180\u019a\u019c\u01a3"+
		"\u01aa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}