package com.github.tyrrx.vb6language.psi.tree.interfaces.conditional

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6IfConditionStmt : PsiElement{
}

class VB6IfConditionStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6IfConditionStmt {

    object Factory : IPsiNodeFactory<VB6IfConditionStmt> {
        override fun createPsiNode(node: ASTNode): VB6IfConditionStmt {
            return VB6IfConditionStmtImpl(node)
        }
    }
}