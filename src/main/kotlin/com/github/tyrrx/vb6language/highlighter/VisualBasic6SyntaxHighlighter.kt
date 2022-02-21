package com.github.tyrrx.vb6language.highlighter

import com.github.tyrrx.vb6language.VisualBasic6Language
import com.github.tyrrx.vb6language.parser.VisualBasic6Lexer
import com.github.tyrrx.vb6language.parser.VisualBasic6Parser
import com.github.tyrrx.vb6language.psi.VB6TokenSets
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

    private val elementTypeTextAttributeKeyMap = mergeAll(
        VB6TokenSets.comments mapsTo COMMENT,
        VB6TokenSets.identifiers mapsTo IDENTIFIER,
        VB6TokenSets.errorChars mapsTo BAD_CHARACTER,
        VB6TokenSets.stringLiterals mapsTo STRINGS,
        VB6TokenSets.braces mapsTo BRACES,
        VB6TokenSets.parentheses mapsTo PARENTHESES,
        VB6TokenSets.brackets mapsTo BRACKETS,
        VB6TokenSets.keywords mapsTo KEYWORDS,
        VB6TokenSets.numbers mapsTo NUMBER
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




