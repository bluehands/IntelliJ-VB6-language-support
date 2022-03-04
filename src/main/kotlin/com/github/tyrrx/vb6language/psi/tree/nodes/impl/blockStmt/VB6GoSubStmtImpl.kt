package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6GoSubStmt
import com.intellij.lang.ASTNode

class VB6GoSubStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6GoSubStmt {

    object Factory : IPsiNodeFactory<VB6GoSubStmt> {
        override fun createPsiNode(node: ASTNode): VB6GoSubStmt {
            return VB6GoSubStmtImpl(node)
        }
    }
}