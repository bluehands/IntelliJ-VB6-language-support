package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6AppactivateStmt
import com.intellij.lang.ASTNode

class VB6AppactivateStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6AppactivateStmt {

    object Factory : IPsiNodeFactory<VB6AppactivateStmt> {
        override fun createPsiNode(node: ASTNode): VB6AppactivateStmt {
            return VB6AppactivateStmtImpl(node)
        }
    }
}