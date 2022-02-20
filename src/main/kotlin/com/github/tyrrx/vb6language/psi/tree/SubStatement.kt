package com.github.tyrrx.vb6language.psi.tree

import com.github.tyrrx.vb6language.VisualBasic6Language
import com.github.tyrrx.vb6language.psi.VisualBasic6ParserDefinition
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import org.antlr.intellij.adaptor.SymtabUtils
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree
import org.antlr.intellij.adaptor.psi.ScopeNode

class SubStatement(node: ASTNode) : IdentifierDefSubtree(node, VisualBasic6ParserDefinition.IDENTIFIER), ScopeNode {
    override fun resolve(element: PsiNamedElement?): PsiElement? {
        return SymtabUtils.resolve(
            this, VisualBasic6Language.INSTANCE,
            element, "/ambiguousIdentifier/IDENTIFIER"
        )
    }
}