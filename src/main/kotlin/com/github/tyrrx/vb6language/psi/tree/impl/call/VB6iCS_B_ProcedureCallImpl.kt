package com.github.tyrrx.vb6language.psi.tree.impl.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.call.VB6iCS_B_ProcedureCall
import com.intellij.lang.ASTNode

class VB6iCS_B_ProcedureCallImpl(node: ASTNode) : VB6PsiNode(node), VB6iCS_B_ProcedureCall {

    object Factory : IPsiNodeFactory<VB6iCS_B_ProcedureCall> {
        override fun createPsiNode(node: ASTNode): VB6iCS_B_ProcedureCall {
            return VB6iCS_B_ProcedureCallImpl(node)
        }
    }
}