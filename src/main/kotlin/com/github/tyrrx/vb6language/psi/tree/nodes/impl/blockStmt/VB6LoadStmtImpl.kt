package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6LoadStmt
import com.intellij.lang.ASTNode

class VB6LoadStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6LoadStmt {

    object Factory : IPsiNodeFactory<VB6LoadStmt> {
        override fun createPsiNode(node: ASTNode): VB6LoadStmt {
            return VB6LoadStmtImpl(node)
        }
    }
}