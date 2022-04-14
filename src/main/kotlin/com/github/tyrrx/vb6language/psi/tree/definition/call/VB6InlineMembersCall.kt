package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInDirectChildrenByType
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
                findFirstChildByType<VB6AtomicInlineCall>(this)) +
                findPsiElementsInDirectChildrenByType<VB6InlineMemberCall>(this)
}