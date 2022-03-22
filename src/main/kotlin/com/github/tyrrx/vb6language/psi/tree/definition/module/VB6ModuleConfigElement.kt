package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Literal
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementInSubtree
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6ModuleConfigElement: VB6IdentifierOwner {
    fun getLiteral(): VB6Literal?
}

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

    override fun getNameIdentifier(): VB6Identifier? {
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