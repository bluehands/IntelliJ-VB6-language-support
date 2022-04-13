package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Argument
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6ArgumentList
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Visibility
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6VisibilityEnum
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6EventStmt :
    VB6EnclosingVisibleNamedElements,
    VB6PsiElement,
    VB6NamedElementOwner,
    VB6VisibilityOwner,
    VB6ArgumentOwner {
}

class VB6EventStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6EventStmt {

    object Factory : IPsiNodeFactory<VB6EventStmt> {
        override fun createPsiNode(node: ASTNode): VB6EventStmt {
            return VB6EventStmtImpl(node)
        }
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = listOf(this)
    override val outsideVisibleNamedElements: List<VB6NamedElement>
        get() = emptyList() // todo also this?

    override fun getNameIdentifier(): VB6NamedElement? {
        return findFirstChildByType(this)
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override val isDefinition: Boolean
        get() = true

    override fun setName(name: String): PsiElement {
        nameIdentifier?.setName(name)
        return this
    }

    override val visibility: VB6VisibilityEnum
        get() = findFirstChildByType<VB6Visibility>(this)?.getEnumValue() ?: VB6VisibilityEnum.PUBLIC

    override val arguments: List<VB6Argument>
        get() = findFirstChildByType<VB6ArgumentList>(this)?.arguments() ?: emptyList()
}