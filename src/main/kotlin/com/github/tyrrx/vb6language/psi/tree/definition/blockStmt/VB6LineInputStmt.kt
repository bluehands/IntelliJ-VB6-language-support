package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6LineInputStmt : VB6PsiElement {
}

class VB6LineInputStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6LineInputStmt {

    object Factory : IPsiNodeFactory<VB6LineInputStmt> {
        override fun createPsiNode(node: ASTNode): VB6LineInputStmt {
            return VB6LineInputStmtImpl(node)
        }
    }
}