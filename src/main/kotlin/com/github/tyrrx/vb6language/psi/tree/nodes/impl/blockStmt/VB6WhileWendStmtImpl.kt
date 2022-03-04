package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6WhileWendStmt
import com.intellij.lang.ASTNode

class VB6WhileWendStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6WhileWendStmt {

    object Factory : IPsiNodeFactory<VB6WhileWendStmt> {
        override fun createPsiNode(node: ASTNode): VB6WhileWendStmt {
            return VB6WhileWendStmtImpl(node)
        }
    }
}