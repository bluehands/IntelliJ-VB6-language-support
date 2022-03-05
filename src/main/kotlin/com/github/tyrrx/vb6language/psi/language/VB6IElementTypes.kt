package com.github.tyrrx.vb6language.psi.language

import com.github.tyrrx.vb6language.VB6Language
import com.github.tyrrx.vb6language.parser.VisualBasic6Lexer
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.lexer.TokenIElementType

object VB6IElementTypes: TokenType {

    val tokens: List<TokenIElementType> = PSIElementTypeFactory.getTokenIElementTypes(VB6Language.INSTANCE)

    val rules: List<RuleIElementType> = PSIElementTypeFactory.getRuleIElementTypes(VB6Language.INSTANCE)

    val file = IFileElementType(VB6Language.INSTANCE)

    val CLASS = tokens[VisualBasic6Lexer.CLASS]

    val PRIVATE = tokens[VisualBasic6Lexer.PRIVATE]
    val PUBLIC = tokens[VisualBasic6Lexer.PUBLIC]
    val FRIEND = tokens[VisualBasic6Lexer.FRIEND]
    val GLOBAL = tokens[VisualBasic6Lexer.GLOBAL]

    val STATIC = tokens[VisualBasic6Lexer.STATIC]

    val OPTIONAL = tokens[VisualBasic6Lexer.OPTIONAL]

    val BYVAL = tokens[VisualBasic6Lexer.BYVAL]
    val BYREF = tokens[VisualBasic6Lexer.BYREF]

    val PARAMARRAY = tokens[VisualBasic6Lexer.PARAMARRAY]

    val NEW = tokens[VisualBasic6Lexer.NEW]

    val WITHEVENTS = tokens[VisualBasic6Lexer.WITHEVENTS]
}