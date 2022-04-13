package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6OnGoToStmt : VB6PsiElement {
}

class VB6OnGoToStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6OnGoToStmt {

    object Factory : IPsiNodeFactory<VB6OnGoToStmt> {
        override fun createPsiNode(node: ASTNode): VB6OnGoToStmt {
            return VB6OnGoToStmtImpl(node)
        }
    }
}