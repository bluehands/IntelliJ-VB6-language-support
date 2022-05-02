package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.VB6MemberReferenceChain
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByTypeOf
import com.github.tyrrx.vb6language.psi.utils.findChildElementsByTypeOf
import com.intellij.lang.ASTNode

interface VB6InlineMembersCall : VB6MemberReferenceChain {
}

class VB6InlineMembersCallImpl(node: ASTNode) : VB6PsiNode(node), VB6InlineMembersCall {

    object Factory : IPsiNodeFactory<VB6InlineMembersCall> {
        override fun createPsiNode(node: ASTNode): VB6InlineMembersCall {
            return VB6InlineMembersCallImpl(node)
        }
    }

    override val referenceOwners: List<VB6ReferenceOwner>
        get() = listOfNotNull(
                findFirstChildByTypeOf<VB6AtomicInlineCall>(this)) +
                findChildElementsByTypeOf<VB6InlineMemberCall>(this)
}