package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceFactory
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.reference.references.LineLabelReference
import com.github.tyrrx.vb6language.psi.reference.references.VB6Reference
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByTypeOf
import com.intellij.lang.ASTNode

interface VB6GoToDestination: VB6PsiElement, VB6ReferenceOwner, VB6ReferenceFactory {
    val referencingNamedElement: VB6NamedElement?
}

class VB6GoToDestinationImpl(node: ASTNode) : VB6PsiNode(node), VB6GoToDestination {
    object Factory : IPsiNodeFactory<VB6GoToDestination> {
        override fun createPsiNode(node: ASTNode): VB6GoToDestination {
            return VB6GoToDestinationImpl(node)
        }
    }

    override val referenceFactory: VB6ReferenceFactory
        get() = this

    override fun createReference(): VB6Reference? {
        return referencingNamedElement?.let {
            LineLabelReference(this, it, it.textRangeInParent)
        }
    }

    override val referencingNamedElement: VB6NamedElement?
        get() = findFirstChildByTypeOf(this)

    override fun getReference(): VB6Reference? {
        return createReference()
    }

}