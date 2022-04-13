package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6ChdriveStmt : VB6PsiElement {
}


class VB6ChdriveStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ChdriveStmt {

    object Factory : IPsiNodeFactory<VB6ChdriveStmt> {
        override fun createPsiNode(node: ASTNode): VB6ChdriveStmt {
            return VB6ChdriveStmtImpl(node)
        }
    }
}