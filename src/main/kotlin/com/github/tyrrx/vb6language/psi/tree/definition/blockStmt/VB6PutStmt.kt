package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6PutStmt : VB6PsiElement {
}

class VB6PutStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6PutStmt {

    object Factory : IPsiNodeFactory<VB6PutStmt> {
        override fun createPsiNode(node: ASTNode): VB6PutStmt {
            return VB6PutStmtImpl(node)
        }
    }
}