package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.VB6Reference
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.intellij.lang.ASTNode

interface VB6ImplementsStmt : VB6StatementBase, VB6ReferenceOwner, VB6ReferenceFactory {
}

class VB6ImplementsStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ImplementsStmt {

    object Factory : IPsiNodeFactory<VB6ImplementsStmt> {
        override fun createPsiNode(node: ASTNode): VB6ImplementsStmt {
            return VB6ImplementsStmtImpl(node)
        }
    }

    override fun getReference(): VB6Reference? {
        TODO("Not yet implemented")
    }

    override val referenceFactory: VB6ReferenceFactory?
        get() = TODO("Not yet implemented")

    override fun createReference(): VB6Reference? {
        TODO("Not yet implemented")
    }

}