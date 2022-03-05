package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt.conditional


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.conditional.VB6ThenBlockStmt
import com.intellij.lang.ASTNode

class VB6ThenBlockStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ThenBlockStmt {

    object Factory : IPsiNodeFactory<VB6ThenBlockStmt> {
        override fun createPsiNode(node: ASTNode): VB6ThenBlockStmt {
            return VB6ThenBlockStmtImpl(node)
        }
    }
}