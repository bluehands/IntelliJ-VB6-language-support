package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6RmdirStmt : VB6PsiElement {
}

class VB6RmdirStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6RmdirStmt {

    object Factory : IPsiNodeFactory<VB6RmdirStmt> {
        override fun createPsiNode(node: ASTNode): VB6RmdirStmt {
            return VB6RmdirStmtImpl(node)
        }
    }
}