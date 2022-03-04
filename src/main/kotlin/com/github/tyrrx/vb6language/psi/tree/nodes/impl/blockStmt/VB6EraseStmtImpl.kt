package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6EraseStmt
import com.intellij.lang.ASTNode

class VB6EraseStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6EraseStmt {

    object Factory : IPsiNodeFactory<VB6EraseStmt> {
        override fun createPsiNode(node: ASTNode): VB6EraseStmt {
            return VB6EraseStmtImpl(node)
        }
    }
}