package com.github.tyrrx.vb6language.psi.reference.references

import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiReference

interface VB6Reference : PsiReference {
    val myReferenceOwner: VB6ReferenceOwner
    val referencingNamedElement: VB6NamedElement
    val textRange: TextRange
}