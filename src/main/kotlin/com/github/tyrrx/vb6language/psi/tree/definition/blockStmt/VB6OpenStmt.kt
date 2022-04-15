package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6OpenStmt : VB6PsiElement {
}

class VB6OpenStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6OpenStmt {

    object Factory : IPsiNodeFactory<VB6OpenStmt> {
        override fun createPsiNode(node: ASTNode): VB6OpenStmt {
            return VB6OpenStmtImpl(node)
        }
    }
}