package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6GoToStmt
import com.intellij.lang.ASTNode

class VB6GoToStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6GoToStmt {

    object Factory : IPsiNodeFactory<VB6GoToStmt> {
        override fun createPsiNode(node: ASTNode): VB6GoToStmt {
            return VB6GoToStmtImpl(node)
        }
    }
}