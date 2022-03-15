package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6iCS_B_MemberProcedureCall : PsiElement {
}


class VB6iCS_B_MemberProcedureCallImpl(node: ASTNode) : VB6PsiNode(node), VB6iCS_B_MemberProcedureCall {

    object Factory : IPsiNodeFactory<VB6iCS_B_MemberProcedureCall> {
        override fun createPsiNode(node: ASTNode): VB6iCS_B_MemberProcedureCall {
            return VB6iCS_B_MemberProcedureCallImpl(node)
        }
    }
}