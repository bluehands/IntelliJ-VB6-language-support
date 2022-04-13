package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6InlineMembersCall : PsiElement {
    val atomicFirstSegment: VB6AtomicInlineCall?
    val inlineMemberCalls: List<VB6InlineMemberCall>
    val callSegments: List<VB6PsiElement>
}

class VB6InlineMembersCallImpl(node: ASTNode) : VB6PsiNode(node), VB6InlineMembersCall {

    object Factory : IPsiNodeFactory<VB6InlineMembersCall> {
        override fun createPsiNode(node: ASTNode): VB6InlineMembersCall {
            return VB6InlineMembersCallImpl(node)
        }
    }

    override val atomicFirstSegment: VB6AtomicInlineCall?
        get() = findFirstChildByType(this)

    override val inlineMemberCalls: List<VB6InlineMemberCall>
        get() = findPsiElementsInDirectChildrenByType(this)

    override val callSegments: List<VB6PsiElement>
        get() {
            val first = atomicFirstSegment?.let { listOf(it) }
            return first?.let { it + inlineMemberCalls } ?: inlineMemberCalls
        }
}