package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6ExplicitMemberProcedureCall : VB6PsiElement {
    val inlineCall: VB6InlineCall?
}

class VB6ExplicitMemberProcedureCallImpl(node: ASTNode) : VB6PsiNode(node), VB6ExplicitMemberProcedureCall {

    object Factory : IPsiNodeFactory<VB6ExplicitMemberProcedureCall> {
        override fun createPsiNode(node: ASTNode): VB6ExplicitMemberProcedureCall {
            return VB6ExplicitMemberProcedureCallImpl(node)
        }
    }

    override val inlineCall: VB6InlineCall?
        get() = findFirstChildByType(this)
}