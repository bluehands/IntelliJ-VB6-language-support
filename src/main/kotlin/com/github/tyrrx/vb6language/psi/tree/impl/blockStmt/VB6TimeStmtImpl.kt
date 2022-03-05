package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6TimeStmt
import com.intellij.lang.ASTNode

class VB6TimeStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6TimeStmt {

    object Factory : IPsiNodeFactory<VB6TimeStmt> {
        override fun createPsiNode(node: ASTNode): VB6TimeStmt {
            return VB6TimeStmtImpl(node)
        }
    }
}