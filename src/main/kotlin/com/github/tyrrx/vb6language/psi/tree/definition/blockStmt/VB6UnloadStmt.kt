package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6UnloadStmt : VB6PsiElement {
}

class VB6UnloadStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6UnloadStmt {

    object Factory : IPsiNodeFactory<VB6UnloadStmt> {
        override fun createPsiNode(node: ASTNode): VB6UnloadStmt {
            return VB6UnloadStmtImpl(node)
        }
    }
}