package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6DateStmt : VB6PsiElement {
}

class VB6DateStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6DateStmt {

    object Factory : IPsiNodeFactory<VB6DateStmt> {
        override fun createPsiNode(node: ASTNode): VB6DateStmt {
            return VB6DateStmtImpl(node)
        }
    }
}