package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6PutStmt
import com.intellij.lang.ASTNode

class VB6PutStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6PutStmt {

    object Factory : IPsiNodeFactory<VB6PutStmt> {
        override fun createPsiNode(node: ASTNode): VB6PutStmt {
            return VB6PutStmtImpl(node)
        }
    }
}