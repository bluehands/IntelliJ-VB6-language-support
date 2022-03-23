package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6ExplicitMemberProcedureCall : PsiElement {
}

class VB6ExplicitMemberProcedureCallImpl(node: ASTNode) : VB6PsiNode(node), VB6ExplicitMemberProcedureCall {

    object Factory : IPsiNodeFactory<VB6ExplicitMemberProcedureCall> {
        override fun createPsiNode(node: ASTNode): VB6ExplicitMemberProcedureCall {
            return VB6ExplicitMemberProcedureCallImpl(node)
        }
    }
}