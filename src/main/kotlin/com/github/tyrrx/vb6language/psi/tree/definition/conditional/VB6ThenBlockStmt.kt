package com.github.tyrrx.vb6language.psi.tree.definition.conditional

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6ThenBlockStmt : VB6PsiElement {
}

class VB6ThenBlockStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ThenBlockStmt {

    object Factory : IPsiNodeFactory<VB6ThenBlockStmt> {
        override fun createPsiNode(node: ASTNode): VB6ThenBlockStmt {
            return VB6ThenBlockStmtImpl(node)
        }
    }
}