package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement

interface VB6AtomicCall : VB6PsiElement {
    val referenceIdentifier: VB6NamedElement?
}