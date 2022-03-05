package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6ReturnStmt
import com.intellij.lang.ASTNode

class VB6ReturnStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ReturnStmt {

    object Factory : IPsiNodeFactory<VB6ReturnStmt> {
        override fun createPsiNode(node: ASTNode): VB6ReturnStmt {
            return VB6ReturnStmtImpl(node)
        }
    }
}