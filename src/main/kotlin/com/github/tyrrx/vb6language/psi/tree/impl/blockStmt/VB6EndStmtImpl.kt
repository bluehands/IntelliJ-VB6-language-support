package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6EndStmt
import com.intellij.lang.ASTNode

class VB6EndStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6EndStmt {

    object Factory : IPsiNodeFactory<VB6EndStmt> {
        override fun createPsiNode(node: ASTNode): VB6EndStmt {
            return VB6EndStmtImpl(node)
        }
    }
}