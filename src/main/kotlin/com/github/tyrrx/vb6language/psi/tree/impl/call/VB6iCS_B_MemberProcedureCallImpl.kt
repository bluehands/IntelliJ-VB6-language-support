package com.github.tyrrx.vb6language.psi.tree.impl.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.call.VB6iCS_B_MemberProcedureCall
import com.intellij.lang.ASTNode

class VB6iCS_B_MemberProcedureCallImpl(node: ASTNode) : VB6PsiNode(node), VB6iCS_B_MemberProcedureCall {

    object Factory : IPsiNodeFactory<VB6iCS_B_MemberProcedureCall> {
        override fun createPsiNode(node: ASTNode): VB6iCS_B_MemberProcedureCall {
            return VB6iCS_B_MemberProcedureCallImpl(node)
        }
    }
}