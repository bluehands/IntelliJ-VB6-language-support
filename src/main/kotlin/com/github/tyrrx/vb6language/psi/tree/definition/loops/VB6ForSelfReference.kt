package com.github.tyrrx.vb6language.psi.tree.definition.loops

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceFactory
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.reference.references.SymbolReference
import com.github.tyrrx.vb6language.psi.reference.references.VB6Reference
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.intellij.lang.ASTNode

interface VB6ForSelfReference : VB6PsiElement, VB6ReferenceOwner, VB6ReferenceFactory {
    val identifier: VB6Identifier?
}

class VB6ForSelfReferenceImpl(node: ASTNode) : VB6PsiNode(node), VB6ForSelfReference {

    object Factory : IPsiNodeFactory<VB6ForSelfReference> {
        override fun createPsiNode(node: ASTNode): VB6ForSelfReference {
            return VB6ForSelfReferenceImpl(node)
        }
    }

    override val referenceFactory: VB6ReferenceFactory?
        get() = this

    override fun createReference(): VB6Reference? {
        return identifier?.let { SymbolReference(this, it, it.textRangeInParent) }
    }

    override val identifier: VB6Identifier?
        get() = when (val id = firstChild) {
            is VB6Identifier -> id
            else -> null
        }

    override fun getReference(): VB6Reference? {
        return referenceFactory?.createReference()
    }
}
