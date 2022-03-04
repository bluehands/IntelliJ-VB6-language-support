package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6RsetStmt
import com.intellij.lang.ASTNode

class VB6RsetStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6RsetStmt {

    object Factory : IPsiNodeFactory<VB6RsetStmt> {
        override fun createPsiNode(node: ASTNode): VB6RsetStmt {
            return VB6RsetStmtImpl(node)
        }
    }
}