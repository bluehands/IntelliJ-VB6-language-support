package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6OnGoToStmt
import com.intellij.lang.ASTNode

class VB6OnGoToStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6OnGoToStmt {

    object Factory : IPsiNodeFactory<VB6OnGoToStmt> {
        override fun createPsiNode(node: ASTNode): VB6OnGoToStmt {
            return VB6OnGoToStmtImpl(node)
        }
    }
}