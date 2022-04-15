package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6AppactivateStmt : VB6PsiElement {
}

class VB6AppactivateStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6AppactivateStmt {

    object Factory : IPsiNodeFactory<VB6AppactivateStmt> {
        override fun createPsiNode(node: ASTNode): VB6AppactivateStmt {
            return VB6AppactivateStmtImpl(node)
        }
    }
}