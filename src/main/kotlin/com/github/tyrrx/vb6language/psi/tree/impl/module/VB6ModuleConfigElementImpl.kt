package com.github.tyrrx.vb6language.psi.tree.impl.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6Literal
import com.github.tyrrx.vb6language.psi.tree.interfaces.identifier.VB6AmbiguousIdentifier
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6ModuleConfigElement
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementInSubtree
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

class VB6ModuleConfigElementImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ModuleConfigElement {
    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getLiteral(): VB6Literal? {
        return findPsiElementInSubtree(this)
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun getNameIdentifier(): VB6AmbiguousIdentifier? {
        return findFirstChildByType(this)
    }

    object Factory: IPsiNodeFactory<VB6ModuleConfigElement> {
        override fun createPsiNode(node: ASTNode): VB6ModuleConfigElement {
            return VB6ModuleConfigElementImpl(node)
        }
    }
}