package com.github.tyrrx.vb6language.psi.tree.definition.conditional

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6ElseBlockStmt : VB6PsiElement {
}

class VB6ElseBlockStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ElseBlockStmt {

    object Factory : IPsiNodeFactory<VB6ElseBlockStmt> {
        override fun createPsiNode(node: ASTNode): VB6ElseBlockStmt {
            return VB6ElseBlockStmtImpl(node)
        }
    }
}