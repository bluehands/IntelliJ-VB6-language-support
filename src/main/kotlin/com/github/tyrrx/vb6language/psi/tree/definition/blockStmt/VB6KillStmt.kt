package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6KillStmt : VB6PsiElement {
}

class VB6KillStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6KillStmt {

    object Factory : IPsiNodeFactory<VB6KillStmt> {
        override fun createPsiNode(node: ASTNode): VB6KillStmt {
            return VB6KillStmtImpl(node)
        }
    }
}