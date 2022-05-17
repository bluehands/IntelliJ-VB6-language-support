package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.reference.VB6MemberReferenceChain
import com.github.tyrrx.vb6language.psi.reference.VB6MemberReferenceOwner
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceFactory
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.reference.references.TypeMemberReference
import com.github.tyrrx.vb6language.psi.reference.references.VB6Reference
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByTypeOf
import com.intellij.lang.ASTNode

interface VB6LastExplicitMemberProcedureCall : VB6PsiElement, VB6MemberReferenceOwner, VB6ReferenceFactory {
    val referencingElement: VB6NamedElement?
}

class VB6LastExplicitMemberProcedureCallImpl(node: ASTNode) : VB6PsiNode(node), VB6LastExplicitMemberProcedureCall {

    object Factory : IPsiNodeFactory<VB6LastExplicitMemberProcedureCall> {
        override fun createPsiNode(node: ASTNode): VB6LastExplicitMemberProcedureCall {
            return VB6LastExplicitMemberProcedureCallImpl(node)
        }
    }

    override val referencingElement: VB6NamedElement?
        get() = findFirstChildByTypeOf(this)

    override fun getReference(): VB6Reference? {
        return createReference()
    }

    override val previousReferenceOwner: VB6ReferenceOwner?
        get() {
            val myParent = parent as? VB6MemberReferenceChain
            val chainRoot = myParent?.chainRoot()
            return chainRoot?.previousReferenceOwnerOf(this)
        }


    override val referenceFactory: VB6ReferenceFactory?
        get() = this

    override fun createReference(): VB6Reference? {
        val blockMembersCall = parent as VB6ExplicitMemberProcedureCall
        return blockMembersCall.inlineCall?.let { inlineCall ->
            referencingElement?.let { ref ->
                TypeMemberReference(
                        this,
                        ref,
                        ref.textRangeInParent,
                        inlineCall.finalReference
                )
            }
        } ?: TODO("Search for with statment and get type")
    }
}