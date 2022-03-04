package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6ResetStmt
import com.intellij.lang.ASTNode

class VB6ResetStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6ResetStmt {

    object Factory : IPsiNodeFactory<VB6ResetStmt> {
        override fun createPsiNode(node: ASTNode): VB6ResetStmt {
            return VB6ResetStmtImpl(node)
        }
    }
}