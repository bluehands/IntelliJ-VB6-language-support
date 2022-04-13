package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6PrintStmt : VB6PsiElement {
}


class VB6PrintStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6PrintStmt {

    object Factory : IPsiNodeFactory<VB6PrintStmt> {
        override fun createPsiNode(node: ASTNode): VB6PrintStmt {
            return VB6PrintStmtImpl(node)
        }
    }
}