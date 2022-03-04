package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6ErrorStmt
import com.intellij.lang.ASTNode

class VB6ErrorStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6ErrorStmt {

    object Factory : IPsiNodeFactory<VB6ErrorStmt> {
        override fun createPsiNode(node: ASTNode): VB6ErrorStmt {
            return VB6ErrorStmtImpl(node)
        }
    }
}