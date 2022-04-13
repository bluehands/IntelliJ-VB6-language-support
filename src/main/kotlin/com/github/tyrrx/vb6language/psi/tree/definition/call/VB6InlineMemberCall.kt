package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.TypeMemberReference
import com.github.tyrrx.vb6language.psi.reference.VB6Reference
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.intellij.lang.ASTNode

interface VB6InlineMemberCall : VB6PsiElement, VB6ReferenceOwner, VB6ReferenceFactory {
}

class VB6InlineMemberCallImpl(node: ASTNode) : VB6PsiNode(node), VB6InlineMemberCall {

    object Factory : IPsiNodeFactory<VB6InlineMemberCall> {
        override fun createPsiNode(node: ASTNode): VB6InlineMemberCall {
            return VB6InlineMemberCallImpl(node)
        }
    }

    override fun getReference(): VB6Reference? {
        return createReference()
    }

    override val referenceFactory: VB6ReferenceFactory
        get() = this

    override fun createReference(): VB6Reference? {
        val identifier = when (val callDef = firstChild) {
            is VB6InlineProcedureOrArrayCall -> callDef.referenceIdentifier
            is VB6InlineVariableOrProcedureCall -> callDef.referenceIdentifier
            else -> null
        }
        return identifier?.let { id ->

            val myParent = parent as VB6InlineMembersCall
            val inlineMemberCalls = myParent.inlineMemberCalls
            val iterator = inlineMemberCalls.listIterator(inlineMemberCalls.indexOf(this))
            val previousSegment = if (iterator.hasPrevious()) {
                iterator.previous()
            } else {
                myParent.atomicFirstSegment
            }
            previousSegment?.let {
                return TypeMemberReference(this, id, id.textRangeInParent, it.reference)
            } ?: TODO("Search for with statement and obtain reference from it")
        }
    }
}