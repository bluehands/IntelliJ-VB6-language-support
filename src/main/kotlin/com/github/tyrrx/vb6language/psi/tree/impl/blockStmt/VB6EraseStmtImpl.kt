package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6EraseStmt
import com.intellij.lang.ASTNode

class VB6EraseStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6EraseStmt {

    object Factory : IPsiNodeFactory<VB6EraseStmt> {
        override fun createPsiNode(node: ASTNode): VB6EraseStmt {
            return VB6EraseStmtImpl(node)
        }
    }
}