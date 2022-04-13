package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6RsetStmt : VB6PsiElement {
}

class VB6RsetStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6RsetStmt {

    object Factory : IPsiNodeFactory<VB6RsetStmt> {
        override fun createPsiNode(node: ASTNode): VB6RsetStmt {
            return VB6RsetStmtImpl(node)
        }
    }
}