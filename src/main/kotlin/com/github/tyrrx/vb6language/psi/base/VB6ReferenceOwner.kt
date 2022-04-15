package com.github.tyrrx.vb6language.psi.base

import com.github.tyrrx.vb6language.psi.reference.VB6Reference
interface VB6ReferenceOwner: VB6PsiElement {
    override fun getReference(): VB6Reference?
    val referenceFactory: VB6ReferenceFactory?
}