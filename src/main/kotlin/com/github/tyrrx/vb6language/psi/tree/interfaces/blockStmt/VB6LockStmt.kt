package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6LockStmt : VB6Statement {
}

class VB6LockStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6LockStmt {

    object Factory : IPsiNodeFactory<VB6LockStmt> {
        override fun createPsiNode(node: ASTNode): VB6LockStmt {
            return VB6LockStmtImpl(node)
        }
    }
}