package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6LoadStmt : VB6PsiElement {
}

class VB6LoadStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6LoadStmt {

    object Factory : IPsiNodeFactory<VB6LoadStmt> {
        override fun createPsiNode(node: ASTNode): VB6LoadStmt {
            return VB6LoadStmtImpl(node)
        }
    }
}