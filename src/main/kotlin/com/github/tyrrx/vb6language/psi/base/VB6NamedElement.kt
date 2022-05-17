package com.github.tyrrx.vb6language.psi.base

import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.intellij.psi.PsiNamedElement

interface VB6NamedElement : PsiNamedElement, VB6PsiElement {
    val referenceOwner: VB6ReferenceOwner?
    val namedElementOwner: VB6NamedElementOwner?
}