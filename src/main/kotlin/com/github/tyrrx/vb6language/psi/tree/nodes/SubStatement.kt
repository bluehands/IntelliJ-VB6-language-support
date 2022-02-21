package com.github.tyrrx.vb6language.psi.tree.nodes

import com.github.tyrrx.vb6language.VisualBasic6Language
import com.github.tyrrx.vb6language.psi.VisualBasic6ParserDefinition
import com.github.tyrrx.vb6language.psi.tree.tryFindIdentifierInSubtree
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiNamedElement
import org.antlr.intellij.adaptor.SymtabUtils
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree
import org.antlr.intellij.adaptor.psi.ScopeNode

class SubStatement(node: ASTNode) : ANTLRPsiNode(node), ScopeNode, PsiNameIdentifierOwner {
    override fun resolve(element: PsiNamedElement?): PsiElement? {
        return SymtabUtils.resolve(
            this, VisualBasic6Language.INSTANCE,
            element, "/ambiguousIdentifier/IDENTIFIER"
        )
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getName(): String? {
        return nameIdentifier?.text
    }

    override fun getNameIdentifier(): PsiElement? {
        return tryFindIdentifierInSubtree(this)
    }
}