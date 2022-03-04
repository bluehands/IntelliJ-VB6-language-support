package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6SetStmt
import com.intellij.lang.ASTNode

class VB6SetStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6SetStmt {

    object Factory : IPsiNodeFactory<VB6SetStmt> {
        override fun createPsiNode(node: ASTNode): VB6SetStmt {
            return VB6SetStmtImpl(node)
        }
    }
}