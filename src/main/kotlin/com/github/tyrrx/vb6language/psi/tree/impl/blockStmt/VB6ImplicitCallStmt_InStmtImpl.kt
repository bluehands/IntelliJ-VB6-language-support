package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6ImplicitCallStmt_InStmt
import com.intellij.lang.ASTNode

class VB6ImplicitCallStmt_InStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ImplicitCallStmt_InStmt {

    object Factory : IPsiNodeFactory<VB6ImplicitCallStmt_InStmt> {
        override fun createPsiNode(node: ASTNode): VB6ImplicitCallStmt_InStmt {
            return VB6ImplicitCallStmt_InStmtImpl(node)
        }
    }
}