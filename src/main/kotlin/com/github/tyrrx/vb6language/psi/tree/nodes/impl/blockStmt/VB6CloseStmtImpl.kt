package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6CloseStmt
import com.intellij.lang.ASTNode

class VB6CloseStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6CloseStmt {

    object Factory : IPsiNodeFactory<VB6CloseStmt> {
        override fun createPsiNode(node: ASTNode): VB6CloseStmt {
            return VB6CloseStmtImpl(node)
        }
    }
}