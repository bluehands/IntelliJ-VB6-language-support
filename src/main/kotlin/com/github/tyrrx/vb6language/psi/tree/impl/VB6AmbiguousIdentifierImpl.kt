package com.github.tyrrx.vb6language.psi.tree.impl


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.identifier.VB6AmbiguousIdentifier
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

class VB6AmbiguousIdentifierImpl(node: ASTNode) : VB6PsiNode(node),
    VB6AmbiguousIdentifier {

    object Factory : IPsiNodeFactory<VB6AmbiguousIdentifier> {
        override fun createPsiNode(node: ASTNode): VB6AmbiguousIdentifier {
            return VB6AmbiguousIdentifierImpl(node)
        }
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getName(): String? {
        return children.fold("") { acc, psiElement -> acc.plus(psiElement.text) }
    }
}