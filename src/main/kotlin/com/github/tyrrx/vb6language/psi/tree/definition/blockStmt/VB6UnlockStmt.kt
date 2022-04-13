package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6UnlockStmt : VB6PsiElement {
}

class VB6UnlockStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6UnlockStmt {

    object Factory : IPsiNodeFactory<VB6UnlockStmt> {
        override fun createPsiNode(node: ASTNode): VB6UnlockStmt {
            return VB6UnlockStmtImpl(node)
        }
    }
}