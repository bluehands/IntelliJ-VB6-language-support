package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6OnErrorStmt
import com.intellij.lang.ASTNode

class VB6OnErrorStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6OnErrorStmt {

    object Factory : IPsiNodeFactory<VB6OnErrorStmt> {
        override fun createPsiNode(node: ASTNode): VB6OnErrorStmt {
            return VB6OnErrorStmtImpl(node)
        }
    }
}