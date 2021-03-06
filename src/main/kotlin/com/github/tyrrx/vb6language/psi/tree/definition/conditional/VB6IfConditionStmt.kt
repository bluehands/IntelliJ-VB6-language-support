package com.github.tyrrx.vb6language.psi.tree.definition.conditional

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6IfConditionStmt : VB6PsiElement {
}

class VB6IfConditionStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6IfConditionStmt {

    object Factory : IPsiNodeFactory<VB6IfConditionStmt> {
        override fun createPsiNode(node: ASTNode): VB6IfConditionStmt {
            return VB6IfConditionStmtImpl(node)
        }
    }
}