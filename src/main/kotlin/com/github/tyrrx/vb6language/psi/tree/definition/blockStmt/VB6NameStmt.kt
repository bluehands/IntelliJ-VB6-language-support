package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6NameStmt : VB6PsiElement {
}

class VB6NameStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6NameStmt {

    object Factory : IPsiNodeFactory<VB6NameStmt> {
        override fun createPsiNode(node: ASTNode): VB6NameStmt {
            return VB6NameStmtImpl(node)
        }
    }
}