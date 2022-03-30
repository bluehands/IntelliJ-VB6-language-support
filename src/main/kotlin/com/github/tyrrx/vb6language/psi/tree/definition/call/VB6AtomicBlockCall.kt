package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.SymbolReference
import com.github.tyrrx.vb6language.psi.reference.VB6Reference
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode

interface VB6AtomicBlockCall : VB6AtomicCall, VB6ReferenceFactory, VB6ReferenceOwner {
}

class VB6AtomicBlockCallImpl(node: ASTNode) : VB6PsiNode(node), VB6AtomicBlockCall {

    object Factory : IPsiNodeFactory<VB6AtomicBlockCall> {
        override fun createPsiNode(node: ASTNode): VB6AtomicBlockCall {
            return VB6AtomicBlockCallImpl(node)
        }
    }

    override val referenceIdentifier: VB6NamedElement?
        get() = findFirstChildByType(this)

    override fun getReference(): VB6Reference? {
        return createReference()
    }

    override fun createReference(): VB6Reference? {
        return referenceIdentifier?.let { id ->
            SymbolReference(this, id, id.textRangeInParent)
        }
    }

    override val referenceFactory: VB6ReferenceFactory
        get() = this
}