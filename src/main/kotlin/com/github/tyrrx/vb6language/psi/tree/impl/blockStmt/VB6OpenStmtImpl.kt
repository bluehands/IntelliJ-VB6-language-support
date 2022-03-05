package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6OpenStmt
import com.intellij.lang.ASTNode

class VB6OpenStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6OpenStmt {

    object Factory : IPsiNodeFactory<VB6OpenStmt> {
        override fun createPsiNode(node: ASTNode): VB6OpenStmt {
            return VB6OpenStmtImpl(node)
        }
    }
}