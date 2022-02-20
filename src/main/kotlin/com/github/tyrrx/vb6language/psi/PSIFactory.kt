package com.github.tyrrx.vb6language.psi

import com.github.tyrrx.vb6language.parser.VisualBasic6Parser
import com.github.tyrrx.vb6language.psi.tree.FunctionStatement
import com.github.tyrrx.vb6language.psi.tree.SubStatement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

object PSIFactory {
    fun createElement(node: ASTNode): PsiElement {
        val elementType = node.elementType
        return if (elementType is RuleIElementType) {
            when (elementType.ruleIndex) {
                VisualBasic6Parser.RULE_functionStmt -> FunctionStatement(node)
                VisualBasic6Parser.RULE_subStmt -> SubStatement(node)
                else -> ANTLRPsiNode(node)
            }
        } else {
            ANTLRPsiNode(node)
        }
    }
}