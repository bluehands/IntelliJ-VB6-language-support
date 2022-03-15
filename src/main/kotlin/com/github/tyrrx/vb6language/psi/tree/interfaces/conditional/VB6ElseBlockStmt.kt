package com.github.tyrrx.vb6language.psi.tree.interfaces.conditional

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6ElseBlockStmt : PsiElement {
}

class VB6ElseBlockStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ElseBlockStmt {

    object Factory : IPsiNodeFactory<VB6ElseBlockStmt> {
        override fun createPsiNode(node: ASTNode): VB6ElseBlockStmt {
            return VB6ElseBlockStmtImpl(node)
        }
    }
}