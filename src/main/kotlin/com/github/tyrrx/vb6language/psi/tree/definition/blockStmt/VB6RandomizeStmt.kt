package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6RandomizeStmt : VB6PsiElement {
}

class VB6RandomizeStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6RandomizeStmt {

    object Factory : IPsiNodeFactory<VB6RandomizeStmt> {
        override fun createPsiNode(node: ASTNode): VB6RandomizeStmt {
            return VB6RandomizeStmtImpl(node)
        }
    }
}