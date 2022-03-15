package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6ExitStmt : VB6Statement {
}

class VB6ExitStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ExitStmt {

    object Factory : IPsiNodeFactory<VB6ExitStmt> {
        override fun createPsiNode(node: ASTNode): VB6ExitStmt {
            return VB6ExitStmtImpl(node)
        }
    }
}