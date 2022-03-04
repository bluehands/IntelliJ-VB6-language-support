package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6WidthStmt
import com.intellij.lang.ASTNode

class VB6WidthStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6WidthStmt {

    object Factory : IPsiNodeFactory<VB6WidthStmt> {
        override fun createPsiNode(node: ASTNode): VB6WidthStmt {
            return VB6WidthStmtImpl(node)
        }
    }
}