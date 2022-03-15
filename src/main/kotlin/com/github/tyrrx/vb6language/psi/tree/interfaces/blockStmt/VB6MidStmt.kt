package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6MidStmt : VB6Statement {
}

class VB6MidStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6MidStmt {

    object Factory : IPsiNodeFactory<VB6MidStmt> {
        override fun createPsiNode(node: ASTNode): VB6MidStmt {
            return VB6MidStmtImpl(node)
        }
    }
}