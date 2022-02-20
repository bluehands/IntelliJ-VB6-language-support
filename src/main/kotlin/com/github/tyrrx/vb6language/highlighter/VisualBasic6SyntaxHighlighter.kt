package com.github.tyrrx.vb6language.highlighter

import com.github.tyrrx.vb6language.VisualBasic6Language
import com.github.tyrrx.vb6language.parser.VisualBasic6Lexer
import com.github.tyrrx.vb6language.parser.VisualBasic6Parser
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory

class VisualBasic6SyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer(): Lexer {
        val lexer = VisualBasic6Lexer(null)
        return ANTLRLexerAdaptor(VisualBasic6Language.INSTANCE, lexer)
    }

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return pack(elementTypeTextAttributeKeyMap[tokenType])
    }

    private fun mergeAll(vararg maps: Map<IElementType, TextAttributesKey>): HashMap<IElementType, TextAttributesKey> {
        val resultHashMap = HashMap<IElementType, TextAttributesKey>()
        maps
            .flatMap { it.entries }
            .forEach { safeMap(resultHashMap, it.key, it.value) }
        return resultHashMap
    }

    private val braces = listOf(
        VisualBasic6Lexer.LBRACE,
        VisualBasic6Lexer.RBRACE
    )

    private val parentheses = listOf(
        VisualBasic6Lexer.RPAREN,
        VisualBasic6Lexer.LPAREN
    )

    private val brackets = listOf(
        VisualBasic6Lexer.L_SQUARE_BRACKET,
        VisualBasic6Lexer.R_SQUARE_BRACKET
    )

    private val keywords = listOf(
        VisualBasic6Lexer.ACCESS,
        VisualBasic6Lexer.ADDRESSOF,
        VisualBasic6Lexer.ALIAS,
        VisualBasic6Lexer.AND,
        VisualBasic6Lexer.ATTRIBUTE,
        VisualBasic6Lexer.APPACTIVATE,
        VisualBasic6Lexer.APPEND,
        VisualBasic6Lexer.AS,
        VisualBasic6Lexer.BEEP,
        VisualBasic6Lexer.BEGIN,
        VisualBasic6Lexer.BEGINPROPERTY,
        VisualBasic6Lexer.BINARY,
        VisualBasic6Lexer.BOOLEAN, //
        VisualBasic6Lexer.BYVAL,
        VisualBasic6Lexer.BYREF,
        VisualBasic6Lexer.BYTE, //
        VisualBasic6Lexer.CALL,
        VisualBasic6Lexer.CASE,
        VisualBasic6Lexer.CHDIR,
        VisualBasic6Lexer.CHDRIVE,
        VisualBasic6Lexer.CLASS,
        VisualBasic6Lexer.CLOSE,
        VisualBasic6Lexer.COLLECTION,
        VisualBasic6Lexer.CONST,
        VisualBasic6Lexer.DATE,
        VisualBasic6Lexer.DECLARE,
        VisualBasic6Lexer.DEFBOOL,
        VisualBasic6Lexer.DEFBYTE,
        VisualBasic6Lexer.DEFDATE,
        VisualBasic6Lexer.DEFDBL,
        VisualBasic6Lexer.DEFDEC,
        VisualBasic6Lexer.DEFCUR,
        VisualBasic6Lexer.DEFINT,
        VisualBasic6Lexer.DEFLNG,
        VisualBasic6Lexer.DEFOBJ,
        VisualBasic6Lexer.DEFSNG,
        VisualBasic6Lexer.DEFSTR,
        VisualBasic6Lexer.DEFVAR,
        VisualBasic6Lexer.DELETESETTING,
        VisualBasic6Lexer.DIM,
        VisualBasic6Lexer.DO,
        VisualBasic6Lexer.DOUBLE, //
        VisualBasic6Lexer.EACH,
        VisualBasic6Lexer.ELSE,
        VisualBasic6Lexer.ELSEIF,
        VisualBasic6Lexer.END_ENUM,
        VisualBasic6Lexer.END_FUNCTION,
        VisualBasic6Lexer.END_IF,
        VisualBasic6Lexer.END_PROPERTY,
        VisualBasic6Lexer.END_SELECT,
        VisualBasic6Lexer.END_SUB,
        VisualBasic6Lexer.END_TYPE,
        VisualBasic6Lexer.END_WITH,
        VisualBasic6Lexer.END,
        VisualBasic6Lexer.ENDPROPERTY,
        VisualBasic6Lexer.ENUM,
        VisualBasic6Lexer.EQV,
        VisualBasic6Lexer.ERASE,
        VisualBasic6Lexer.ERROR,
        VisualBasic6Lexer.EVENT,
        VisualBasic6Lexer.EXIT_DO,
        VisualBasic6Lexer.EXIT_FOR,
        VisualBasic6Lexer.EXIT_FUNCTION,
        VisualBasic6Lexer.EXIT_PROPERTY,
        VisualBasic6Lexer.EXIT_SUB,
        VisualBasic6Lexer.FALSE,
        VisualBasic6Lexer.FILECOPY,
        VisualBasic6Lexer.FRIEND,
        VisualBasic6Lexer.FOR,
        VisualBasic6Lexer.FUNCTION,
        VisualBasic6Lexer.GET,
        VisualBasic6Lexer.GLOBAL,
        VisualBasic6Lexer.GOSUB,
        VisualBasic6Lexer.GOTO,
        VisualBasic6Lexer.IF,
        VisualBasic6Lexer.IMP,
        VisualBasic6Lexer.IMPLEMENTS,
        VisualBasic6Lexer.IN,
        VisualBasic6Lexer.INPUT,
        VisualBasic6Lexer.IS,
        VisualBasic6Lexer.INTEGER, //
        VisualBasic6Lexer.KILL,
        VisualBasic6Lexer.LOAD,
        VisualBasic6Lexer.LOCK,
        VisualBasic6Lexer.LONG, //
        VisualBasic6Lexer.LOOP,
        VisualBasic6Lexer.LEN,
        VisualBasic6Lexer.LET,
        VisualBasic6Lexer.LIB,
        VisualBasic6Lexer.LIKE,
        VisualBasic6Lexer.LINE_INPUT,
        VisualBasic6Lexer.LOCK_READ,
        VisualBasic6Lexer.LOCK_WRITE,
        VisualBasic6Lexer.LOCK_READ_WRITE,
        VisualBasic6Lexer.LSET,
        VisualBasic6Lexer.MACRO_IF,
        VisualBasic6Lexer.MACRO_ELSEIF,
        VisualBasic6Lexer.MACRO_ELSE,
        VisualBasic6Lexer.MACRO_END_IF,
        VisualBasic6Lexer.ME,
        VisualBasic6Lexer.MID,
        VisualBasic6Lexer.MKDIR,
        VisualBasic6Lexer.MOD,
        VisualBasic6Lexer.NAME,
        VisualBasic6Lexer.NEXT,
        VisualBasic6Lexer.NEW,
        VisualBasic6Lexer.NOT,
        VisualBasic6Lexer.NOTHING,
        VisualBasic6Lexer.NULL_,
        VisualBasic6Lexer.OBJECT,
        VisualBasic6Lexer.ON,
        VisualBasic6Lexer.ON_ERROR,
        VisualBasic6Lexer.ON_LOCAL_ERROR,
        VisualBasic6Lexer.OPEN,
        VisualBasic6Lexer.OPTIONAL,
        VisualBasic6Lexer.OPTION_BASE,
        VisualBasic6Lexer.OPTION_EXPLICIT,
        VisualBasic6Lexer.OPTION_COMPARE,
        VisualBasic6Lexer.OPTION_PRIVATE_MODULE,
        VisualBasic6Lexer.OR,
        VisualBasic6Lexer.OUTPUT,
        VisualBasic6Lexer.PARAMARRAY,
        VisualBasic6Lexer.PRESERVE,
        VisualBasic6Lexer.PRINT,
        VisualBasic6Lexer.PRIVATE,
        VisualBasic6Lexer.PROPERTY_GET,
        VisualBasic6Lexer.PROPERTY_LET,
        VisualBasic6Lexer.PROPERTY_SET,
        VisualBasic6Lexer.PUBLIC,
        VisualBasic6Lexer.PUT,
        VisualBasic6Lexer.RANDOM,
        VisualBasic6Lexer.RANDOMIZE,
        VisualBasic6Lexer.RAISEEVENT,
        VisualBasic6Lexer.READ,
        VisualBasic6Lexer.READ_WRITE,
        VisualBasic6Lexer.REDIM,
        VisualBasic6Lexer.REM,
        VisualBasic6Lexer.RESET,
        VisualBasic6Lexer.RESUME,
        VisualBasic6Lexer.RETURN,
        VisualBasic6Lexer.RMDIR,
        VisualBasic6Lexer.RSET,
        VisualBasic6Lexer.SAVEPICTURE,
        VisualBasic6Lexer.SAVESETTING,
        VisualBasic6Lexer.SEEK,
        VisualBasic6Lexer.SELECT,
        VisualBasic6Lexer.SENDKEYS,
        VisualBasic6Lexer.SET,
        VisualBasic6Lexer.SETATTR,
        VisualBasic6Lexer.SHARED,
        VisualBasic6Lexer.SINGLE,
        VisualBasic6Lexer.SPC,
        VisualBasic6Lexer.STATIC,
        VisualBasic6Lexer.STEP,
        VisualBasic6Lexer.STOP,
        VisualBasic6Lexer.STRING,
        VisualBasic6Lexer.SUB,
        VisualBasic6Lexer.TAB,
        VisualBasic6Lexer.TEXT,
        VisualBasic6Lexer.THEN,
        VisualBasic6Lexer.TIME,
        VisualBasic6Lexer.TO,
        VisualBasic6Lexer.TRUE,
        VisualBasic6Lexer.TYPE,
        VisualBasic6Lexer.TYPEOF,
        VisualBasic6Lexer.UNLOAD,
        VisualBasic6Lexer.UNLOCK,
        VisualBasic6Lexer.UNTIL,
        VisualBasic6Lexer.VARIANT,
        VisualBasic6Lexer.VERSION,
        VisualBasic6Lexer.WEND,
        VisualBasic6Lexer.WHILE,
        VisualBasic6Lexer.WIDTH,
        VisualBasic6Lexer.WITH,
        VisualBasic6Lexer.WITHEVENTS,
        VisualBasic6Lexer.WRITE,
        VisualBasic6Lexer.XOR,
    )

    private val numbers = listOf(
        VisualBasic6Lexer.INTEGERLITERAL,
        VisualBasic6Lexer.DOUBLELITERAL,
        VisualBasic6Lexer.OCTALLITERAL
    )


    private val elementTypeTextAttributeKeyMap = mergeAll(
        VisualBasic6Lexer.COMMENT mapsTo COMMENT,
        VisualBasic6Lexer.IDENTIFIER mapsTo IDENTIFIER,
        VisualBasic6Lexer.ERRCHAR mapsTo BAD_CHARACTER,
        VisualBasic6Lexer.STRINGLITERAL mapsTo STRINGS,
        braces mapsTo BRACES,
        parentheses mapsTo PARENTHESES,
        brackets mapsTo BRACKETS,
        keywords mapsTo KEYWORDS,
        numbers mapsTo NUMBER
    )


    companion object {

        init {
            PSIElementTypeFactory.defineLanguageIElementTypes(
                VisualBasic6Language.INSTANCE,
                VisualBasic6Parser.tokenNames,
                VisualBasic6Parser.ruleNames
            )
        }

        val BACKGROUND = createTextAttributesKey(
            "VB6_BACKGROUND",
            DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR
        )

        val IDENTIFIER = createTextAttributesKey(
            "VB6_IDENTIFIER",
            DefaultLanguageHighlighterColors.IDENTIFIER
        )

        val BAD_CHARACTER = createTextAttributesKey(
            "VB6_BAD_CHARACTER",
            HighlighterColors.BAD_CHARACTER
        )

        val BRACES = createTextAttributesKey(
            "VB6_BRACES",
            DefaultLanguageHighlighterColors.BRACES
        )

        val BRACKETS = createTextAttributesKey(
            "VB6_BRACKETS",
            DefaultLanguageHighlighterColors.BRACKETS
        )

        val COMMENT = createTextAttributesKey(
            "VB6_COMMENT",
            DefaultLanguageHighlighterColors.DOC_COMMENT
        )

        val DELIMITER = createTextAttributesKey(
            "VB6_DELIMITER",
            DefaultLanguageHighlighterColors.INSTANCE_FIELD
        )

        val KEYWORDS = createTextAttributesKey(
            "VB6_KEYWORD",
            DefaultLanguageHighlighterColors.KEYWORD
        )

        val NUMBER = createTextAttributesKey(
            "VB6_NUMBER",
            DefaultLanguageHighlighterColors.NUMBER
        )

        val OPERATORS = createTextAttributesKey(
            "VB6_OPERATOR",
            DefaultLanguageHighlighterColors.OPERATION_SIGN
        )

        val PARENTHESES = createTextAttributesKey(
            "VB6_PARENTHESIS",
            DefaultLanguageHighlighterColors.PARENTHESES
        )

        val STRINGS = createTextAttributesKey(
            "VB6_STRING",
            DefaultLanguageHighlighterColors.STRING
        )

        val FUNCTION_DECLARATION = createTextAttributesKey(
            "VB6_FUNCTION_DECLARATION",
            DefaultLanguageHighlighterColors.FUNCTION_DECLARATION
        )

        val FUNCTION_CALL = createTextAttributesKey(
            "VB6_FUNCTION_CALL",
            DefaultLanguageHighlighterColors.FUNCTION_CALL

        )
    }
}




