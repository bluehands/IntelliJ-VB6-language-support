package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.literal.VB6Literal
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByTypeOf
import com.github.tyrrx.vb6language.psi.utils.findPsiElementInSubtree
import com.github.tyrrx.vb6language.psi.visitor.NamedElementOwnerVisitor
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6ModuleConfigElement: VB6NamedElementOwner {
    fun getLiteral(): VB6Literal?
}

class VB6ModuleConfigElementImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ModuleConfigElement {
    override fun setName(name: String): PsiElement {
        return this
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = listOf(this)

    override fun getLiteral(): VB6Literal? {
        return findPsiElementInSubtree(this)
    }

    override fun <TReturn> accept(namedElementOwnerVisitor: NamedElementOwnerVisitor<TReturn>): TReturn {
        return namedElementOwnerVisitor.visitModuleConfigElement(this)
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun getNameIdentifier(): VB6NamedElement? {
        return findFirstChildByTypeOf(this)
    }

    object Factory: IPsiNodeFactory<VB6ModuleConfigElement> {
        override fun createPsiNode(node: ASTNode): VB6ModuleConfigElement {
            return VB6ModuleConfigElementImpl(node)
        }
    }

    override val isDefinition: Boolean
        get() = true
}