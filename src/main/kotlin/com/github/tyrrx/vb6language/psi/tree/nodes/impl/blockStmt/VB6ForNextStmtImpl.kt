package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6ForNextStmt
import com.intellij.lang.ASTNode

class VB6ForNextStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6ForNextStmt {

    object Factory : IPsiNodeFactory<VB6ForNextStmt> {
        override fun createPsiNode(node: ASTNode): VB6ForNextStmt {
            return VB6ForNextStmtImpl(node)
        }
    }
}