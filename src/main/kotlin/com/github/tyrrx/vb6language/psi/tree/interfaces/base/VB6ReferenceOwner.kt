package com.github.tyrrx.vb6language.psi.tree.interfaces.base

import com.github.tyrrx.vb6language.psi.tree.interfaces.identifier.VB6Identifier
import com.intellij.psi.PsiElement

interface VB6ReferenceOwner: PsiElement {
    fun getIdentifier(): VB6Identifier
}