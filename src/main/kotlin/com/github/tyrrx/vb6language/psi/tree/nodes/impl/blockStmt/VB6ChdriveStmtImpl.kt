package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6ChdriveStmt
import com.intellij.lang.ASTNode

class VB6ChdriveStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6ChdriveStmt {

    object Factory : IPsiNodeFactory<VB6ChdriveStmt> {
        override fun createPsiNode(node: ASTNode): VB6ChdriveStmt {
            return VB6ChdriveStmtImpl(node)
        }
    }
}