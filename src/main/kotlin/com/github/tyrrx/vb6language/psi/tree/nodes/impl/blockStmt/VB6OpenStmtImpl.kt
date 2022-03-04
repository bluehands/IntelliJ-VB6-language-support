package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6OpenStmt
import com.intellij.lang.ASTNode

class VB6OpenStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6OpenStmt {

    object Factory : IPsiNodeFactory<VB6OpenStmt> {
        override fun createPsiNode(node: ASTNode): VB6OpenStmt {
            return VB6OpenStmtImpl(node)
        }
    }
}