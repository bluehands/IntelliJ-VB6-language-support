package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6LockStmt
import com.intellij.lang.ASTNode

class VB6LockStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6LockStmt {

    object Factory : IPsiNodeFactory<VB6LockStmt> {
        override fun createPsiNode(node: ASTNode): VB6LockStmt {
            return VB6LockStmtImpl(node)
        }
    }
}