package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6MemberReferenceChain
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType
import com.intellij.lang.ASTNode

interface VB6ExplicitMemberProcedureCall : VB6PsiElement, VB6MemberReferenceChain {
    val inlineCall: VB6InlineCall?
    val lastExplicitMemberProcedureCall: VB6LastExplicitMemberProcedureCall?
}

class VB6ExplicitMemberProcedureCallImpl(node: ASTNode) : VB6PsiNode(node), VB6ExplicitMemberProcedureCall {

    object Factory : IPsiNodeFactory<VB6ExplicitMemberProcedureCall> {
        override fun createPsiNode(node: ASTNode): VB6ExplicitMemberProcedureCall {
            return VB6ExplicitMemberProcedureCallImpl(node)
        }
    }

    override val inlineCall: VB6InlineCall?
        get() = findFirstChildByType(this)

    override val lastExplicitMemberProcedureCall: VB6LastExplicitMemberProcedureCall?
        get() = findFirstChildByType(this)

    override val referenceOwners: List<VB6ReferenceOwner>
        get() {
            val first = inlineCall?.referenceOwners ?: emptyList()
            return first + listOfNotNull(lastExplicitMemberProcedureCall)
        }
}