package com.github.tyrrx.vb6language.highlighter

import com.github.tyrrx.vb6language.VisualBasic6Language
import com.github.tyrrx.vb6language.parser.VisualBasic6Lexer
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor

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
        VisualBasic6Lexer.PRIVATE,
        VisualBasic6Lexer.PUBLIC,
        VisualBasic6Lexer.BYVAL,
        VisualBasic6Lexer.BYREF,
        VisualBasic6Lexer.IF,
        VisualBasic6Lexer.END_IF,
        VisualBasic6Lexer.ELSEIF,
        VisualBasic6Lexer.ELSE,
        VisualBasic6Lexer.THEN,
        VisualBasic6Lexer.IS,
        VisualBasic6Lexer.DIM,
        VisualBasic6Lexer.SET,
        VisualBasic6Lexer.ON,
        VisualBasic6Lexer.ON_ERROR,
        VisualBasic6Lexer.ON_LOCAL_ERROR,
        VisualBasic6Lexer.RETURN,
        VisualBasic6Lexer.NEW,
        VisualBasic6Lexer.SELECT,
        VisualBasic6Lexer.CASE,
        VisualBasic6Lexer.END_SELECT,
        VisualBasic6Lexer.EXIT_DO,
        VisualBasic6Lexer.EXIT_FOR,
        VisualBasic6Lexer.EXIT_FUNCTION,
        VisualBasic6Lexer.EXIT_SUB,
        VisualBasic6Lexer.EXIT_PROPERTY,
        VisualBasic6Lexer.FOR,
        VisualBasic6Lexer.LOOP,
        VisualBasic6Lexer.DO,
        VisualBasic6Lexer.SUB,
        VisualBasic6Lexer.FUNCTION,
        VisualBasic6Lexer.END_SUB,
        VisualBasic6Lexer.END_FUNCTION
    )

    private val numbers = listOf(
        VisualBasic6Lexer.INTEGERLITERAL,
        VisualBasic6Lexer.DOUBLELITERAL,
        VisualBasic6Lexer.OCTALLITERAL
    )

    private val functionDefinitions = listOf(
        VisualBasic6Lexer.SUB,
        VisualBasic6Lexer.FUNCTION,
        VisualBasic6Lexer.END_SUB,
        VisualBasic6Lexer.END_FUNCTION
    )

    private val elementTypeTextAttributeKeyMap = mergeAll(
        VisualBasic6Lexer.COMMENT mapsTo COMMENT,
        VisualBasic6Lexer.IDENTIFIER mapsTo IDENTIFIER,
        VisualBasic6Lexer.ERRCHAR mapsTo BAD_CHARACTER,
        braces mapsTo BRACES,
        parentheses mapsTo PARENTHESES,
        brackets mapsTo BRACKETS,
        keywords mapsTo KEYWORDS,
        numbers mapsTo NUMBER,
        functionDefinitions mapsTo FUNCTION_DECLARATION,
    )


    companion object {
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




