package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6InputStmt
import com.intellij.lang.ASTNode

class VB6InputStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6InputStmt {

    object Factory : IPsiNodeFactory<VB6InputStmt> {
        override fun createPsiNode(node: ASTNode): VB6InputStmt {
            return VB6InputStmtImpl(node)
        }
    }
}