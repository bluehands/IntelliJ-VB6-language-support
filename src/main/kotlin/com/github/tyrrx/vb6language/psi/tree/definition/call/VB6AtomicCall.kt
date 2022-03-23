package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier

interface VB6AtomicCall : VB6PsiElement {
    val referenceIdentifier: VB6Identifier?
}