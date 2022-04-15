package com.github.tyrrx.vb6language.psi.tree.definition.call


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6ExplicitCallStmt : VB6PsiElement {
}

class VB6ExplicitCallStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ExplicitCallStmt {

    object Factory : IPsiNodeFactory<VB6ExplicitCallStmt> {
        override fun createPsiNode(node: ASTNode): VB6ExplicitCallStmt {
            return VB6ExplicitCallStmtImpl(node)
        }
    }
}