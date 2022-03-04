package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6OnGoToStmt
import com.intellij.lang.ASTNode

class VB6OnGoToStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6OnGoToStmt {

    object Factory : IPsiNodeFactory<VB6OnGoToStmt> {
        override fun createPsiNode(node: ASTNode): VB6OnGoToStmt {
            return VB6OnGoToStmtImpl(node)
        }
    }
}