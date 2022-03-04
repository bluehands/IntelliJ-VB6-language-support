package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6SavepictureStmt
import com.intellij.lang.ASTNode

class VB6SavepictureStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6SavepictureStmt {

    object Factory : IPsiNodeFactory<VB6SavepictureStmt> {
        override fun createPsiNode(node: ASTNode): VB6SavepictureStmt {
            return VB6SavepictureStmtImpl(node)
        }
    }
}