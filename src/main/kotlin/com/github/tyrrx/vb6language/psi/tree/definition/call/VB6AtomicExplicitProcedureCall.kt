package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceFactory
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.reference.references.CallOrValueReference
import com.github.tyrrx.vb6language.psi.reference.references.VB6Reference
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByTypeOf
import com.intellij.lang.ASTNode

interface VB6AtomicExplicitProcedureCall : VB6ReferenceOwner, VB6ReferenceFactory, VB6AtomicCall {

}

class VB6AtomicExplicitProcedureCallImpl(node: ASTNode) : VB6PsiNode(node), VB6AtomicExplicitProcedureCall {

    object Factory : IPsiNodeFactory<VB6AtomicExplicitProcedureCall> {
        override fun createPsiNode(node: ASTNode): VB6AtomicExplicitProcedureCall {
            return VB6AtomicExplicitProcedureCallImpl(node)
        }
    }

    override val referenceFactory: VB6ReferenceFactory
        get() = this

    override fun createReference(): VB6Reference? {
        return referenceIdentifier
            ?.let { CallOrValueReference(this, it, it.textRangeInParent) }
    }

    override val referenceIdentifier: VB6NamedElement?
        get() = findFirstChildByTypeOf(this)

    override fun getReference(): VB6Reference? {
        return createReference()
    }
}

