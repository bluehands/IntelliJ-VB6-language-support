package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6LockStmt
import com.intellij.lang.ASTNode

class VB6LockStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6LockStmt {

    object Factory : IPsiNodeFactory<VB6LockStmt> {
        override fun createPsiNode(node: ASTNode): VB6LockStmt {
            return VB6LockStmtImpl(node)
        }
    }
}