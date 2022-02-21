package com.github.tyrrx.vb6language.psi

import com.github.tyrrx.vb6language.VisualBasic6Language
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.lexer.TokenIElementType

object VB6TokenIElementTypes: TokenType {

    val tokens: List<TokenIElementType> = PSIElementTypeFactory.getTokenIElementTypes(VisualBasic6Language.INSTANCE)

    val rules: List<RuleIElementType> = PSIElementTypeFactory.getRuleIElementTypes(VisualBasic6Language.INSTANCE)

    val file = IFileElementType(VisualBasic6Language.INSTANCE)
}