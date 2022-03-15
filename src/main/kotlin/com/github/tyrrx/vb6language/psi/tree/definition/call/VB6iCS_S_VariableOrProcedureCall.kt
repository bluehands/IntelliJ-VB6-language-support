package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6iCS_S_VariableOrProcedureCall : PsiElement {
}

class VB6iCS_S_VariableOrProcedureCallImpl(node: ASTNode) : VB6PsiNode(node), VB6iCS_S_VariableOrProcedureCall {

    object Factory : IPsiNodeFactory<VB6iCS_S_VariableOrProcedureCall> {
        override fun createPsiNode(node: ASTNode): VB6iCS_S_VariableOrProcedureCall {
            return VB6iCS_S_VariableOrProcedureCallImpl(node)
        }
    }
}