package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6RsetStmt
import com.intellij.lang.ASTNode

class VB6RsetStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6RsetStmt {

    object Factory : IPsiNodeFactory<VB6RsetStmt> {
        override fun createPsiNode(node: ASTNode): VB6RsetStmt {
            return VB6RsetStmtImpl(node)
        }
    }
}