package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6UnloadStmt
import com.intellij.lang.ASTNode

class VB6UnloadStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6UnloadStmt {

    object Factory : IPsiNodeFactory<VB6UnloadStmt> {
        override fun createPsiNode(node: ASTNode): VB6UnloadStmt {
            return VB6UnloadStmtImpl(node)
        }
    }
}