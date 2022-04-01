package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.literal.VB6Literal
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementInSubtree
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6ModuleConfigElement: VB6NamedElementOwner {
    fun getLiteral(): VB6Literal?
}

class VB6ModuleConfigElementImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ModuleConfigElement {
    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = listOf(this)
    override val outsideVisibleNamedElements: List<VB6NamedElement>
        get() = TODO("Not yet implemented")

    override fun getLiteral(): VB6Literal? {
        return findPsiElementInSubtree(this)
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun getNameIdentifier(): VB6NamedElement? {
        return findFirstChildByType(this)
    }

    object Factory: IPsiNodeFactory<VB6ModuleConfigElement> {
        override fun createPsiNode(node: ASTNode): VB6ModuleConfigElement {
            return VB6ModuleConfigElementImpl(node)
        }
    }

    override val isDefinition: Boolean
        get() = true
}