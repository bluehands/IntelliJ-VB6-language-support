package com.github.tyrrx.vb6language.psi.tree.interfaces.conditional


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6SelectCaseStmt : VB6Statement {
}

class VB6SelectCaseStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6SelectCaseStmt {

    object Factory : IPsiNodeFactory<VB6SelectCaseStmt> {
        override fun createPsiNode(node: ASTNode): VB6SelectCaseStmt {
            return VB6SelectCaseStmtImpl(node)
        }
    }
}