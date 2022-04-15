package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.reference.VB6MemberReferenceChain
import com.github.tyrrx.vb6language.psi.reference.VB6MemberReferenceOwner
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceFactory
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.reference.references.TypeMemberReference
import com.github.tyrrx.vb6language.psi.reference.references.VB6Reference
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6InlineMemberCall : VB6PsiElement, VB6MemberReferenceOwner, VB6ReferenceFactory {
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

    override val previousReferenceOwner: VB6ReferenceOwner?
        get() {
            val myParent = parent as? VB6MemberReferenceChain
            val chainRoot = myParent?.chainRoot()
            return chainRoot?.previousReferenceOwnerOf(this)
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
            previousReferenceOwner?.let {
                return TypeMemberReference(this, id, id.textRangeInParent, it.reference)
            } ?: TODO("Search for with statement and obtain reference from it")
        }
    }
}