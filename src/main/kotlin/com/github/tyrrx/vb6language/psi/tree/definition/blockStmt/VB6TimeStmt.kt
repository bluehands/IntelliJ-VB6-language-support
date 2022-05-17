package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6TimeStmt : VB6PsiElement {
}

class VB6TimeStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6TimeStmt {

    object Factory : IPsiNodeFactory<VB6TimeStmt> {
        override fun createPsiNode(node: ASTNode): VB6TimeStmt {
            return VB6TimeStmtImpl(node)
        }
    }
}