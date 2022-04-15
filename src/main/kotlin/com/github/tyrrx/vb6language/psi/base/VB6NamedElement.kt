package com.github.tyrrx.vb6language.psi.base

import com.intellij.psi.PsiNamedElement

interface VB6NamedElement : PsiNamedElement, VB6PsiElement {
    val referenceOwner: VB6ReferenceOwner?
    val namedElementOwner: VB6NamedElementOwner?
}