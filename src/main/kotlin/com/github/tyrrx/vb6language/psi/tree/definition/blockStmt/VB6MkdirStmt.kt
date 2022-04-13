package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6MkdirStmt : VB6PsiElement {
}

class VB6MkdirStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6MkdirStmt {

    object Factory : IPsiNodeFactory<VB6MkdirStmt> {
        override fun createPsiNode(node: ASTNode): VB6MkdirStmt {
            return VB6MkdirStmtImpl(node)
        }
    }
}