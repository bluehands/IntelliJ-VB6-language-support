package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6MidStmt : VB6PsiElement {
}

class VB6MidStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6MidStmt {

    object Factory : IPsiNodeFactory<VB6MidStmt> {
        override fun createPsiNode(node: ASTNode): VB6MidStmt {
            return VB6MidStmtImpl(node)
        }
    }
}