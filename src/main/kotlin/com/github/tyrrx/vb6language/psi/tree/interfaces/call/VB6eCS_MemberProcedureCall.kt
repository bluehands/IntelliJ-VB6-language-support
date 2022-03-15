package com.github.tyrrx.vb6language.psi.tree.interfaces.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6eCS_MemberProcedureCall : PsiElement {
}

class VB6eCS_MemberProcedureCallImpl(node: ASTNode) : VB6PsiNode(node), VB6eCS_MemberProcedureCall {

    object Factory : IPsiNodeFactory<VB6eCS_MemberProcedureCall> {
        override fun createPsiNode(node: ASTNode): VB6eCS_MemberProcedureCall {
            return VB6eCS_MemberProcedureCallImpl(node)
        }
    }
}