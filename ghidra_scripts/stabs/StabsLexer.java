// Generated from StabsLexer.g4 by ANTLR 4.9.3
package stabs;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StabsLexer extends Lexer {
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
		ModeSymbolDesc=1, ModeTypeDesc=2, ModeTypeNum=3, ModeEnumType=4, ModeStructType=5, 
		ModeXrefDesc=6, ModeXrefType=7, ModeStructOrNestedFunction=8, ModeNestedFunction=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "ModeSymbolDesc", "ModeTypeDesc", "ModeTypeNum", "ModeEnumType", 
		"ModeStructType", "ModeXrefDesc", "ModeXrefType", "ModeStructOrNestedFunction", 
		"ModeNestedFunction"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SymbolName", "SymbolColon", "SymbolDescStackVariable", "SymbolDescReferenceParameter", 
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
			"NestedFunctionIdentifier", "NestedFunctionSecondComma", "IDStart", "ID", 
			"INT"
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


	public StabsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "StabsLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\63\u0127\b\1\b\1"+
		"\b\1\b\1\b\1\b\1\b\1\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t"+
		"\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16"+
		"\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25"+
		"\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34"+
		"\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4"+
		"&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60"+
		"\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t\64\4\65\t\65\3\2\6\2v\n\2\r\2\16"+
		"\2w\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3"+
		"\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3"+
		"\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3"+
		"$\3$\3$\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3)\3)\3)\3)\3*\3*\3*\3"+
		"*\3+\3+\3+\3+\3,\3,\3,\3,\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\3\60"+
		"\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\7\64\u011b\n\64\f\64\16"+
		"\64\u011e\13\64\3\65\5\65\u0121\n\65\3\65\6\65\u0124\n\65\r\65\16\65\u0125"+
		"\2\2\66\f\3\16\4\20\5\22\6\24\7\26\b\30\t\32\n\34\13\36\f \r\"\16$\17"+
		"&\20(\21*\22,\23.\24\60\25\62\26\64\27\66\308\31:\32<\33>\34@\35B\36D"+
		"\37F H!J\"L#N$P%R&T\'V(X)Z*\\+^,`-b.d/f\60h\61j\62l\63n\2p\2r\2\f\2\3"+
		"\4\5\6\7\b\t\n\13\6\3\2<<\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\2\u011e\2"+
		"\f\3\2\2\2\2\16\3\2\2\2\3\20\3\2\2\2\3\22\3\2\2\2\3\24\3\2\2\2\3\26\3"+
		"\2\2\2\3\30\3\2\2\2\3\32\3\2\2\2\3\34\3\2\2\2\3\36\3\2\2\2\3 \3\2\2\2"+
		"\3\"\3\2\2\2\3$\3\2\2\2\3&\3\2\2\2\4(\3\2\2\2\4*\3\2\2\2\4,\3\2\2\2\4"+
		".\3\2\2\2\4\60\3\2\2\2\4\62\3\2\2\2\4\64\3\2\2\2\4\66\3\2\2\2\48\3\2\2"+
		"\2\4:\3\2\2\2\4<\3\2\2\2\4>\3\2\2\2\4@\3\2\2\2\5B\3\2\2\2\5D\3\2\2\2\5"+
		"F\3\2\2\2\6H\3\2\2\2\6J\3\2\2\2\6L\3\2\2\2\6N\3\2\2\2\6P\3\2\2\2\7R\3"+
		"\2\2\2\7T\3\2\2\2\7V\3\2\2\2\7X\3\2\2\2\7Z\3\2\2\2\b\\\3\2\2\2\b^\3\2"+
		"\2\2\b`\3\2\2\2\tb\3\2\2\2\td\3\2\2\2\nf\3\2\2\2\nh\3\2\2\2\13j\3\2\2"+
		"\2\13l\3\2\2\2\fu\3\2\2\2\16y\3\2\2\2\20}\3\2\2\2\22\u0082\3\2\2\2\24"+
		"\u0086\3\2\2\2\26\u008a\3\2\2\2\30\u008e\3\2\2\2\32\u0092\3\2\2\2\34\u0096"+
		"\3\2\2\2\36\u009a\3\2\2\2 \u009e\3\2\2\2\"\u00a2\3\2\2\2$\u00a6\3\2\2"+
		"\2&\u00aa\3\2\2\2(\u00ae\3\2\2\2*\u00b2\3\2\2\2,\u00b4\3\2\2\2.\u00b6"+
		"\3\2\2\2\60\u00ba\3\2\2\2\62\u00bc\3\2\2\2\64\u00be\3\2\2\2\66\u00c0\3"+
		"\2\2\28\u00c4\3\2\2\2:\u00c8\3\2\2\2<\u00cc\3\2\2\2>\u00ce\3\2\2\2@\u00d0"+
		"\3\2\2\2B\u00d4\3\2\2\2D\u00d6\3\2\2\2F\u00d8\3\2\2\2H\u00dc\3\2\2\2J"+
		"\u00de\3\2\2\2L\u00e0\3\2\2\2N\u00e2\3\2\2\2P\u00e4\3\2\2\2R\u00e8\3\2"+
		"\2\2T\u00ea\3\2\2\2V\u00ee\3\2\2\2X\u00f2\3\2\2\2Z\u00f4\3\2\2\2\\\u00f8"+
		"\3\2\2\2^\u00fc\3\2\2\2`\u0100\3\2\2\2b\u0104\3\2\2\2d\u0106\3\2\2\2f"+
		"\u010a\3\2\2\2h\u010e\3\2\2\2j\u0112\3\2\2\2l\u0114\3\2\2\2n\u0116\3\2"+
		"\2\2p\u0118\3\2\2\2r\u0120\3\2\2\2tv\n\2\2\2ut\3\2\2\2vw\3\2\2\2wu\3\2"+
		"\2\2wx\3\2\2\2x\r\3\2\2\2yz\7<\2\2z{\3\2\2\2{|\b\3\2\2|\17\3\2\2\2}~\7"+
		"*\2\2~\177\3\2\2\2\177\u0080\b\4\3\2\u0080\u0081\b\4\4\2\u0081\21\3\2"+
		"\2\2\u0082\u0083\7c\2\2\u0083\u0084\3\2\2\2\u0084\u0085\b\5\3\2\u0085"+
		"\23\3\2\2\2\u0086\u0087\7H\2\2\u0087\u0088\3\2\2\2\u0088\u0089\b\6\3\2"+
		"\u0089\25\3\2\2\2\u008a\u008b\7h\2\2\u008b\u008c\3\2\2\2\u008c\u008d\b"+
		"\7\3\2\u008d\27\3\2\2\2\u008e\u008f\7I\2\2\u008f\u0090\3\2\2\2\u0090\u0091"+
		"\b\b\3\2\u0091\31\3\2\2\2\u0092\u0093\7R\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\u0095\b\t\3\2\u0095\33\3\2\2\2\u0096\u0097\7r\2\2\u0097\u0098\3\2\2\2"+
		"\u0098\u0099\b\n\3\2\u0099\35\3\2\2\2\u009a\u009b\7t\2\2\u009b\u009c\3"+
		"\2\2\2\u009c\u009d\b\13\3\2\u009d\37\3\2\2\2\u009e\u009f\7U\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a1\b\f\3\2\u00a1!\3\2\2\2\u00a2\u00a3\7V\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a5\b\r\3\2\u00a5#\3\2\2\2\u00a6\u00a7\7v\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00a9\b\16\3\2\u00a9%\3\2\2\2\u00aa\u00ab\7X\2\2"+
		"\u00ab\u00ac\3\2\2\2\u00ac\u00ad\b\17\3\2\u00ad\'\3\2\2\2\u00ae\u00af"+
		"\7*\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\b\20\4\2\u00b1)\3\2\2\2\u00b2"+
		"\u00b3\7?\2\2\u00b3+\3\2\2\2\u00b4\u00b5\7c\2\2\u00b5-\3\2\2\2\u00b6\u00b7"+
		"\7g\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\b\23\5\2\u00b9/\3\2\2\2\u00ba"+
		"\u00bb\7h\2\2\u00bb\61\3\2\2\2\u00bc\u00bd\7,\2\2\u00bd\63\3\2\2\2\u00be"+
		"\u00bf\7t\2\2\u00bf\65\3\2\2\2\u00c0\u00c1\7u\2\2\u00c1\u00c2\3\2\2\2"+
		"\u00c2\u00c3\b\27\6\2\u00c3\67\3\2\2\2\u00c4\u00c5\7w\2\2\u00c5\u00c6"+
		"\3\2\2\2\u00c6\u00c7\b\30\6\2\u00c79\3\2\2\2\u00c8\u00c9\7z\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00cb\b\31\7\2\u00cb;\3\2\2\2\u00cc\u00cd\7=\2\2"+
		"\u00cd=\3\2\2\2\u00ce\u00cf\5r\65\2\u00cf?\3\2\2\2\u00d0\u00d1\7.\2\2"+
		"\u00d1\u00d2\3\2\2\2\u00d2\u00d3\b\34\b\2\u00d3A\3\2\2\2\u00d4\u00d5\5"+
		"r\65\2\u00d5C\3\2\2\2\u00d6\u00d7\7.\2\2\u00d7E\3\2\2\2\u00d8\u00d9\7"+
		"+\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\b\37\t\2\u00dbG\3\2\2\2\u00dc\u00dd"+
		"\5p\64\2\u00ddI\3\2\2\2\u00de\u00df\7<\2\2\u00dfK\3\2\2\2\u00e0\u00e1"+
		"\5r\65\2\u00e1M\3\2\2\2\u00e2\u00e3\7.\2\2\u00e3O\3\2\2\2\u00e4\u00e5"+
		"\7=\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\b$\t\2\u00e7Q\3\2\2\2\u00e8\u00e9"+
		"\5p\64\2\u00e9S\3\2\2\2\u00ea\u00eb\7<\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed"+
		"\b&\n\2\u00edU\3\2\2\2\u00ee\u00ef\7.\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1"+
		"\b\'\6\2\u00f1W\3\2\2\2\u00f2\u00f3\5r\65\2\u00f3Y\3\2\2\2\u00f4\u00f5"+
		"\7=\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\b)\t\2\u00f7[\3\2\2\2\u00f8\u00f9"+
		"\7g\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\b*\13\2\u00fb]\3\2\2\2\u00fc\u00fd"+
		"\7u\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\b+\13\2\u00ff_\3\2\2\2\u0100\u0101"+
		"\7w\2\2\u0101\u0102\3\2\2\2\u0102\u0103\b,\13\2\u0103a\3\2\2\2\u0104\u0105"+
		"\5p\64\2\u0105c\3\2\2\2\u0106\u0107\7<\2\2\u0107\u0108\3\2\2\2\u0108\u0109"+
		"\b.\t\2\u0109e\3\2\2\2\u010a\u010b\5r\65\2\u010b\u010c\3\2\2\2\u010c\u010d"+
		"\b/\t\2\u010dg\3\2\2\2\u010e\u010f\5p\64\2\u010f\u0110\3\2\2\2\u0110\u0111"+
		"\b\60\f\2\u0111i\3\2\2\2\u0112\u0113\5p\64\2\u0113k\3\2\2\2\u0114\u0115"+
		"\7.\2\2\u0115m\3\2\2\2\u0116\u0117\t\3\2\2\u0117o\3\2\2\2\u0118\u011c"+
		"\t\3\2\2\u0119\u011b\t\4\2\2\u011a\u0119\3\2\2\2\u011b\u011e\3\2\2\2\u011c"+
		"\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011dq\3\2\2\2\u011e\u011c\3\2\2\2"+
		"\u011f\u0121\7/\2\2\u0120\u011f\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0123"+
		"\3\2\2\2\u0122\u0124\t\5\2\2\u0123\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125"+
		"\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126s\3\2\2\2\20\2\3\4\5\6\7\b\t\n"+
		"\13w\u011c\u0120\u0125\r\4\3\2\4\4\2\7\5\2\7\6\2\7\7\2\7\b\2\4\n\2\6\2"+
		"\2\7\4\2\4\t\2\4\13\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}