package com.github.tyrrx.vb6language.psi.reference

import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.reference.references.VB6Reference
interface VB6ReferenceOwner: VB6PsiElement {
    override fun getReference(): VB6Reference?
    val referenceFactory: VB6ReferenceFactory?
}