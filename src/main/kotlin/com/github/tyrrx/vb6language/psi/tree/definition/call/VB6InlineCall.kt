package com.github.tyrrx.vb6language.psi.tree.definition.call


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.VB6Reference
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6InlineCall : VB6PsiElement {
    val finalReference: VB6Reference?
}

class VB6InlineCallImpl(node: ASTNode) : VB6PsiNode(node), VB6InlineCall {

    object Factory : IPsiNodeFactory<VB6InlineCall> {
        override fun createPsiNode(node: ASTNode): VB6InlineCall {
            return VB6InlineCallImpl(node)
        }
    }

    override val finalReference: VB6Reference?
        get() = when (val call = firstChild) {
            is VB6InlineMembersCall -> call.callSegments.lastOrNull()?.reference
            is VB6AtomicInlineCall -> call.reference
            is VB6DictionaryCallStmt -> TODO("Not yet supported")
            else -> null
        }
}