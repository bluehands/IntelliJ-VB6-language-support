package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6ExplicitCallStmt
import com.intellij.lang.ASTNode

class VB6ExplicitCallStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6ExplicitCallStmt {

    object Factory : IPsiNodeFactory<VB6ExplicitCallStmt> {
        override fun createPsiNode(node: ASTNode): VB6ExplicitCallStmt {
            return VB6ExplicitCallStmtImpl(node)
        }
    }
}