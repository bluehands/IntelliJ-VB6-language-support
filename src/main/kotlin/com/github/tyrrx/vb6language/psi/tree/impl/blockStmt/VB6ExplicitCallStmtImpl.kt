package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6ExplicitCallStmt
import com.intellij.lang.ASTNode

class VB6ExplicitCallStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ExplicitCallStmt {

    object Factory : IPsiNodeFactory<VB6ExplicitCallStmt> {
        override fun createPsiNode(node: ASTNode): VB6ExplicitCallStmt {
            return VB6ExplicitCallStmtImpl(node)
        }
    }
}