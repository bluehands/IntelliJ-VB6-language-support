package com.github.tyrrx.vb6language.psi.tree.definition.call


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.VB6Reference
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode

interface VB6ImplicitCallStmt_InStmt : VB6StatementBase, VB6ReferenceOwner {
}

class VB6ImplicitCallStmt_InStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ImplicitCallStmt_InStmt {

    object Factory : IPsiNodeFactory<VB6ImplicitCallStmt_InStmt> {
        override fun createPsiNode(node: ASTNode): VB6ImplicitCallStmt_InStmt {
            return VB6ImplicitCallStmt_InStmtImpl(node)
        }
    }

    override val referenceFactory: VB6ReferenceFactory?
        get() = when (val factory = firstChild) {
            is VB6ReferenceFactory -> factory
            else -> null
        }

    override fun getReference(): VB6Reference? {
        return referenceFactory?.createReference()
    }
}