package com.github.tyrrx.vb6language

import com.github.tyrrx.vb6language.VisualBasic6ParserDefinition.Companion.tokens
import com.github.tyrrx.vb6language.parser.VisualBasic6Lexer
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey

class VisualBasic6SyntaxHighlighter : SyntaxHighlighterBase() {


    override fun getHighlightingLexer(): Lexer {
        val lexer = VisualBasic6Lexer(null)
        return ANTLRLexerAdaptor(VisualBasic6Language.INSTANCE, lexer)
    }

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        val attributes = if (tokenType == tokens[VisualBasic6Lexer.COMMENT]) {
            arrayOf(COMMENT)
        } else {
            emptyArray()
        }
//        return pack(BACKGROUND, attributes)
        return attributes;
    }


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
    }
}