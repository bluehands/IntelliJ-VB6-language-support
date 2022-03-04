package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6ChdirStmt
import com.intellij.lang.ASTNode

class VB6ChdirStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6ChdirStmt {

    object Factory : IPsiNodeFactory<VB6ChdirStmt> {
        override fun createPsiNode(node: ASTNode): VB6ChdirStmt {
            return VB6ChdirStmtImpl(node)
        }
    }
}