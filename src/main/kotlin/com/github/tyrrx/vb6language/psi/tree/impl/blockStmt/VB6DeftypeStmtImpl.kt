package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6DeftypeStmt
import com.intellij.lang.ASTNode

class VB6DeftypeStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6DeftypeStmt {

    object Factory : IPsiNodeFactory<VB6DeftypeStmt> {
        override fun createPsiNode(node: ASTNode): VB6DeftypeStmt {
            return VB6DeftypeStmtImpl(node)
        }
    }
}