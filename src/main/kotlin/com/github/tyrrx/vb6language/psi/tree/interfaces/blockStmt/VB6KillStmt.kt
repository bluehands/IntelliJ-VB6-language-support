package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6KillStmt : VB6Statement {
}

class VB6KillStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6KillStmt {

    object Factory : IPsiNodeFactory<VB6KillStmt> {
        override fun createPsiNode(node: ASTNode): VB6KillStmt {
            return VB6KillStmtImpl(node)
        }
    }
}