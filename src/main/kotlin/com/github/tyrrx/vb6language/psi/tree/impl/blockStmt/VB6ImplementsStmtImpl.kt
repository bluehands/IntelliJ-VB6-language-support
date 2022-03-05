package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6ImplementsStmt
import com.intellij.lang.ASTNode

class VB6ImplementsStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ImplementsStmt {

    object Factory : IPsiNodeFactory<VB6ImplementsStmt> {
        override fun createPsiNode(node: ASTNode): VB6ImplementsStmt {
            return VB6ImplementsStmtImpl(node)
        }
    }
}