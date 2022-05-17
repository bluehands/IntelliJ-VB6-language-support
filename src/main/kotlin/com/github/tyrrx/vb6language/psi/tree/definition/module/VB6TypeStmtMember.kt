package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.inference.VB6TypeClauseOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByTypeOf
import com.github.tyrrx.vb6language.psi.visitor.NamedElementOwnerVisitor
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6TypeStmtMember : VB6PsiElement, VB6NamedElementOwner, VB6TypeClauseOwner {
    val ofTypeStmt: VB6TypeStmt?
}

class VB6TypeStmtMemberImpl(node: ASTNode) : VB6PsiNode(node), VB6TypeStmtMember {

    object Factory : IPsiNodeFactory<VB6TypeStmtMember> {
        override fun createPsiNode(node: ASTNode): VB6TypeStmtMember {
            return VB6TypeStmtMemberImpl(node)
        }
    }

    override val typeClause: VB6AsTypeClause?
        get() = findFirstChildByTypeOf(this)

    override val ofTypeStmt: VB6TypeStmt?
        get() = parent as? VB6TypeStmt

    override fun <TReturn> accept(namedElementOwnerVisitor: NamedElementOwnerVisitor<TReturn>): TReturn {
        return namedElementOwnerVisitor.visitTypeStmtMember(this)
    }

    override fun getNameIdentifier(): VB6NamedElement? {
        return findFirstChildByTypeOf(this)
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

}