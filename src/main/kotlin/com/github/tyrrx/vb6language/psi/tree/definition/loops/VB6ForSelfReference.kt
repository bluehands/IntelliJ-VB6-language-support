package com.github.tyrrx.vb6language.psi.tree.definition.loops

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.VB6Reference
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.intellij.lang.ASTNode

interface VB6ForSelfReference : VB6PsiElement, VB6ReferenceOwner {
}

class VB6ForSelfReferenceImpl(node: ASTNode) : VB6PsiNode(node), VB6ForSelfReference {

    object Factory : IPsiNodeFactory<VB6ForSelfReference> {
        override fun createPsiNode(node: ASTNode): VB6ForSelfReference {
            return VB6ForSelfReferenceImpl(node)
        }
    }

    override val referenceFactory: VB6ReferenceFactory?
        get() = TODO("Not yet implemented")

    override fun getReference(): VB6Reference? {
        return referenceFactory?.createReference()
    }
}
