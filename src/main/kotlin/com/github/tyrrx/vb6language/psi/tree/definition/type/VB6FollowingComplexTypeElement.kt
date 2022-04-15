package com.github.tyrrx.vb6language.psi.tree.definition.type

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
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType
import com.intellij.lang.ASTNode

interface VB6FollowingComplexTypeElement : VB6PsiElement, VB6MemberReferenceOwner, VB6ReferenceFactory {
    val namedElement: VB6NamedElement?
}

class VB6FollowingComplexTypeElementImpl(node: ASTNode) : VB6PsiNode(node), VB6FollowingComplexTypeElement {

    object Factory : IPsiNodeFactory<VB6FollowingComplexTypeElement> {
        override fun createPsiNode(node: ASTNode): VB6FollowingComplexTypeElement {
            return VB6FollowingComplexTypeElementImpl(node)
        }
    }

    override val referenceFactory: VB6ReferenceFactory
        get() = this

    override fun createReference(): VB6Reference? {
        return namedElement?.let { namedElement ->
            TypeMemberReference(this, namedElement, namedElement.textRangeInParent, previousReferenceOwner?.reference)
        }
    }

    override val namedElement: VB6NamedElement?
        get() = findFirstChildByType(this)

    override fun getReference(): VB6Reference? {
        return createReference()
    }

    override val previousReferenceOwner: VB6ReferenceOwner?
        get() {
            val myParent = parent as? VB6MemberReferenceChain
            val chainRoot = myParent?.chainRoot()
            return chainRoot?.previousReferenceOwnerOf(this)
        }
}