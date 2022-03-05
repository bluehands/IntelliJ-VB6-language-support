package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6ResetStmt
import com.intellij.lang.ASTNode

class VB6ResetStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ResetStmt {

    object Factory : IPsiNodeFactory<VB6ResetStmt> {
        override fun createPsiNode(node: ASTNode): VB6ResetStmt {
            return VB6ResetStmtImpl(node)
        }
    }
}