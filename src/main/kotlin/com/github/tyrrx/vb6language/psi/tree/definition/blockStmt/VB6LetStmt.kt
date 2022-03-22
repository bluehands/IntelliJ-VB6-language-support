package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.github.tyrrx.vb6language.psi.tree.definition.call.VB6ImplicitCallStmt_InStmt
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6LetStmt : VB6StatementBase, VB6IdentifierOwner {
    val innerElement: VB6ImplicitCallStmt_InStmt
}

class VB6LetStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6LetStmt {

    object Factory : IPsiNodeFactory<VB6LetStmt> {
        override fun createPsiNode(node: ASTNode): VB6LetStmt {
            return VB6LetStmtImpl(node)
        }
    }

    override val innerElement: VB6ImplicitCallStmt_InStmt
        get() = findFirstChildByType(this)!!

    override val isDefinition: Boolean
        get() = innerElement.firstChild.reference?.resolve() == null

    override fun getNameIdentifier(): VB6Identifier? {
        return when (val referenceOwner = innerElement.firstChild) {
            is VB6ReferenceOwner -> referenceOwner.referencingIdentifier
            else -> TODO("err")
        }
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun setName(name: String): PsiElement {
        return nameIdentifier?.setName(name) ?: this
    }
}