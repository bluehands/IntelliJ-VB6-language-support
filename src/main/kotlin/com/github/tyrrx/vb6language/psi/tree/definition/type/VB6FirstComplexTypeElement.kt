package com.github.tyrrx.vb6language.psi.tree.definition.type

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceFactory
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.reference.references.TypeReference
import com.github.tyrrx.vb6language.psi.reference.references.VB6Reference
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType
import com.intellij.lang.ASTNode

interface VB6FirstComplexTypeElement : VB6PsiElement, VB6ReferenceOwner, VB6ReferenceFactory {
    val namedElement: VB6NamedElement?
}

class VB6FirstComplexTypeElementImpl(node: ASTNode) : VB6PsiNode(node), VB6FirstComplexTypeElement {

    object Factory : IPsiNodeFactory<VB6FirstComplexTypeElement> {
        override fun createPsiNode(node: ASTNode): VB6FirstComplexTypeElement {
            return VB6FirstComplexTypeElementImpl(node)
        }
    }

    override val referenceFactory: VB6ReferenceFactory
        get() = this

    override fun createReference(): VB6Reference? {
        return namedElement?.let {
            TypeReference(this, it, it.textRangeInParent)
        }
    }

    override val namedElement: VB6NamedElement?
        get() = findFirstChildByType(this)

    override fun getReference(): VB6Reference? {
        return createReference()
    }
}