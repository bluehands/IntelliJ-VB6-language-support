package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6GetStmt
import com.intellij.lang.ASTNode

class VB6GetStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6GetStmt {

    object Factory : IPsiNodeFactory<VB6GetStmt> {
        override fun createPsiNode(node: ASTNode): VB6GetStmt {
            return VB6GetStmtImpl(node)
        }
    }
}