package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6ExitStmt : VB6PsiElement {
}

class VB6ExitStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ExitStmt {

    object Factory : IPsiNodeFactory<VB6ExitStmt> {
        override fun createPsiNode(node: ASTNode): VB6ExitStmt {
            return VB6ExitStmtImpl(node)
        }
    }
}