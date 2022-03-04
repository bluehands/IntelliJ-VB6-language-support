package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6ExitStmt
import com.intellij.lang.ASTNode

class VB6ExitStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6ExitStmt {

    object Factory : IPsiNodeFactory<VB6ExitStmt> {
        override fun createPsiNode(node: ASTNode): VB6ExitStmt {
            return VB6ExitStmtImpl(node)
        }
    }
}