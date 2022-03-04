package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6UnlockStmt
import com.intellij.lang.ASTNode

class VB6UnlockStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6UnlockStmt {

    object Factory : IPsiNodeFactory<VB6UnlockStmt> {
        override fun createPsiNode(node: ASTNode): VB6UnlockStmt {
            return VB6UnlockStmtImpl(node)
        }
    }
}