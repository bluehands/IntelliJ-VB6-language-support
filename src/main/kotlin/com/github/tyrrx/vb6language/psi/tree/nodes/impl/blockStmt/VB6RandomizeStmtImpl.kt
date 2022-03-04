package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6RandomizeStmt
import com.intellij.lang.ASTNode

class VB6RandomizeStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6RandomizeStmt {

    object Factory : IPsiNodeFactory<VB6RandomizeStmt> {
        override fun createPsiNode(node: ASTNode): VB6RandomizeStmt {
            return VB6RandomizeStmtImpl(node)
        }
    }
}