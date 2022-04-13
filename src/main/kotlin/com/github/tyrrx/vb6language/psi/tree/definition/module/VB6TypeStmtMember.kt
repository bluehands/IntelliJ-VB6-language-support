package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6TypeStmtMember : VB6PsiElement, VB6NamedElementOwner, VB6TypeClauseOwner{
}

class VB6TypeStmtMemberImpl(node: ASTNode) : VB6PsiNode(node), VB6TypeStmtMember {

    object Factory : IPsiNodeFactory<VB6TypeStmtMember> {
        override fun createPsiNode(node: ASTNode): VB6TypeStmtMember {
            return VB6TypeStmtMemberImpl(node)
        }
    }

    override val typeClause: VB6AsTypeClause?
        get() = findFirstChildByType(this)

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

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = listOf(this)

    override val outsideVisibleNamedElements: List<VB6NamedElement>
        get() = TODO("Not yet implemented")
}