package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6SelectCaseStmt
import com.intellij.lang.ASTNode

class VB6SelectCaseStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6SelectCaseStmt {

    object Factory : IPsiNodeFactory<VB6SelectCaseStmt> {
        override fun createPsiNode(node: ASTNode): VB6SelectCaseStmt {
            return VB6SelectCaseStmtImpl(node)
        }
    }
}