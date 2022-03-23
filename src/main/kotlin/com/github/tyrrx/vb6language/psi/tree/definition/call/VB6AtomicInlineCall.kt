package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.SymbolReference
import com.github.tyrrx.vb6language.psi.reference.VB6Reference
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.intellij.lang.ASTNode

interface VB6AtomicInlineCall : VB6PsiElement, VB6ReferenceFactory, VB6ReferenceOwner {
}

class VB6AtomicInlineCallImpl(node: ASTNode) : VB6PsiNode(node), VB6AtomicInlineCall {
    object Factory : IPsiNodeFactory<VB6AtomicInlineCall> {
        override fun createPsiNode(node: ASTNode): VB6AtomicInlineCall {
            return VB6AtomicInlineCallImpl(node)
        }
    }

    override val referenceFactory: VB6ReferenceFactory?
        get() = this

    override fun getReference(): VB6Reference? {
        return referenceFactory?.createReference()
    }

    override fun createReference(): VB6Reference? {
        val identifier = when (val callDef = firstChild) {
            is VB6InlineProcedureOrArrayCall -> callDef.referenceIdentifier
            is VB6InlineVariableOrProcedureCall -> callDef.referenceIdentifier
            else -> null
        }
        return identifier?.let { id ->
            SymbolReference(this, id, id.textRangeInParent)
        }
    }
}