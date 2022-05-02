package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.VB6MemberReferenceChain
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByTypeOf
import com.intellij.lang.ASTNode

interface VB6BlockMembersCall : VB6MemberReferenceChain {
    val inlineCall: VB6InlineCall?
}


class VB6BlockMembersCallImpl(node: ASTNode) : VB6PsiNode(node), VB6BlockMembersCall {

    object Factory : IPsiNodeFactory<VB6BlockMembersCall> {
        override fun createPsiNode(node: ASTNode): VB6BlockMembersCall {
            return VB6BlockMembersCallImpl(node)
        }
    }

    override val inlineCall: VB6InlineCall?
        get() = findFirstChildByTypeOf(this)

    override val referenceOwners: List<VB6ReferenceOwner>
        get() {
            val first = inlineCall?.referenceOwners ?: emptyList()
            return first + listOfNotNull(findFirstChildByTypeOf<VB6LastBlockMemberCall>(this))
        }
}