package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Literal
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.github.tyrrx.vb6language.psi.tree.definition.call.VB6ImplicitCallStmt_InStmt
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementInSubtree
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6AttributeStmt : VB6StatementBase, VB6IdentifierOwner {
    fun getLiterals(): Collection<VB6Literal>
}

class VB6AttributeStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6AttributeStmt {

    object Factory : IPsiNodeFactory<VB6AttributeStmt> {
        override fun createPsiNode(node: ASTNode): VB6AttributeStmt {
            return VB6AttributeStmtImpl(node)
        }
    }

    override fun getLiterals(): Collection<VB6Literal> {
        return findPsiElementsInDirectChildrenByType(this)
    }

    override fun getNameIdentifier(): VB6Identifier? {
        return findFirstChildByType<VB6ImplicitCallStmt_InStmt>(this)
            ?.let { findPsiElementInSubtree(it) }
    }

    override fun setName(name: String): PsiElement {
        return nameIdentifier?.setName(name) ?: this
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }
}