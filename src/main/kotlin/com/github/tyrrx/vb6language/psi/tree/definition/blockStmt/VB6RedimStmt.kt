package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6RedimStmt : VB6PsiElement {
}

class VB6RedimStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6RedimStmt {

    object Factory : IPsiNodeFactory<VB6RedimStmt> {
        override fun createPsiNode(node: ASTNode): VB6RedimStmt {
            return VB6RedimStmtImpl(node)
        }
    }
}