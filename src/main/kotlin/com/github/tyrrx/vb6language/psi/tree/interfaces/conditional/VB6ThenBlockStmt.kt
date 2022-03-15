package com.github.tyrrx.vb6language.psi.tree.interfaces.conditional

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6ThenBlockStmt : PsiElement {
}

class VB6ThenBlockStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ThenBlockStmt {

    object Factory : IPsiNodeFactory<VB6ThenBlockStmt> {
        override fun createPsiNode(node: ASTNode): VB6ThenBlockStmt {
            return VB6ThenBlockStmtImpl(node)
        }
    }
}