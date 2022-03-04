package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6DoLoopStmt
import com.intellij.lang.ASTNode

class VB6DoLoopStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6DoLoopStmt {

    object Factory : IPsiNodeFactory<VB6DoLoopStmt> {
        override fun createPsiNode(node: ASTNode): VB6DoLoopStmt {
            return VB6DoLoopStmtImpl(node)
        }
    }
}