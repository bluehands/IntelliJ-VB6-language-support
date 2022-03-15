package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6UnlockStmt : VB6Statement {
}

class VB6UnlockStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6UnlockStmt {

    object Factory : IPsiNodeFactory<VB6UnlockStmt> {
        override fun createPsiNode(node: ASTNode): VB6UnlockStmt {
            return VB6UnlockStmtImpl(node)
        }
    }
}