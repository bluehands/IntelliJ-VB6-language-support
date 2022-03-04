package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6MidStmt
import com.intellij.lang.ASTNode

class VB6MidStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6MidStmt {

    object Factory : IPsiNodeFactory<VB6MidStmt> {
        override fun createPsiNode(node: ASTNode): VB6MidStmt {
            return VB6MidStmtImpl(node)
        }
    }
}