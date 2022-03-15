package com.github.tyrrx.vb6language.psi.tree.interfaces.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6iCS_S_ProcedureOrArrayCall : PsiElement {
}

class VB6iCS_S_ProcedureOrArrayCallImpl(node: ASTNode) : VB6PsiNode(node), VB6iCS_S_ProcedureOrArrayCall {

    object Factory : IPsiNodeFactory<VB6iCS_S_ProcedureOrArrayCall> {
        override fun createPsiNode(node: ASTNode): VB6iCS_S_ProcedureOrArrayCall {
            return VB6iCS_S_ProcedureOrArrayCallImpl(node)
        }
    }
}