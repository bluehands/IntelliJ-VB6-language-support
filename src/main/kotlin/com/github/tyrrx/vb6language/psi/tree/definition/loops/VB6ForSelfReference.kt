package com.github.tyrrx.vb6language.psi.tree.definition.loops

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.SymbolReference
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference

interface VB6ForSelfReference : VB6PsiElement, VB6ReferenceOwner {
}

class VB6ForSelfReferenceImpl(node: ASTNode) : VB6PsiNode(node), VB6ForSelfReference {

    object Factory : IPsiNodeFactory<VB6ForSelfReference> {
        override fun createPsiNode(node: ASTNode): VB6ForSelfReference {
            return VB6ForSelfReferenceImpl(node)
        }
    }

    override val referencingIdentifier: VB6Identifier get() = firstChild as VB6Identifier

    override fun getReference(): PsiReference? {
        return SymbolReference(
            this,
            referencingIdentifier.textRangeInParent
        )
    }
}
