package com.github.tyrrx.vb6language.psi.tree.nodes

import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.VB6Literal
import com.github.tyrrx.vb6language.psi.tree.VB6ModuleConfigElement
import com.github.tyrrx.vb6language.psi.tree.findIdentifierInSubtree
import com.github.tyrrx.vb6language.psi.tree.findPsiElementInSubtree
import com.github.tyrrx.vb6language.psi.tree.leafes.IdentifierPsiLeaf
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

class VB6ModuleConfigElementImpl(node: ASTNode) : VB6PsiNode(node), VB6ModuleConfigElement {
    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getLiteral(): VB6Literal? {
        return findPsiElementInSubtree(this)
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun getNameIdentifier(): IdentifierPsiLeaf? {
        return this.findIdentifierInSubtree()
    }

    object Factory: IPsiNodeFactory<VB6ModuleConfigElement> {
        override fun createPsiNode(node: ASTNode): VB6ModuleConfigElement {
            return VB6ModuleConfigElementImpl(node)
        }
    }
}