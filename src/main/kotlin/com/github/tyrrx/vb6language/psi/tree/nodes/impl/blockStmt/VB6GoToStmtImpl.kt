package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6GoToStmt
import com.intellij.lang.ASTNode

class VB6GoToStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6GoToStmt {

    object Factory : IPsiNodeFactory<VB6GoToStmt> {
        override fun createPsiNode(node: ASTNode): VB6GoToStmt {
            return VB6GoToStmtImpl(node)
        }
    }
}