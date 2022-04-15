package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6ResetStmt : VB6PsiElement {
}

class VB6ResetStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ResetStmt {

    object Factory : IPsiNodeFactory<VB6ResetStmt> {
        override fun createPsiNode(node: ASTNode): VB6ResetStmt {
            return VB6ResetStmtImpl(node)
        }
    }
}