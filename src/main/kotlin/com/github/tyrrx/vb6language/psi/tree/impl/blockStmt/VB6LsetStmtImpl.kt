package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6LsetStmt
import com.intellij.lang.ASTNode

class VB6LsetStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6LsetStmt {

    object Factory : IPsiNodeFactory<VB6LsetStmt> {
        override fun createPsiNode(node: ASTNode): VB6LsetStmt {
            return VB6LsetStmtImpl(node)
        }
    }
}