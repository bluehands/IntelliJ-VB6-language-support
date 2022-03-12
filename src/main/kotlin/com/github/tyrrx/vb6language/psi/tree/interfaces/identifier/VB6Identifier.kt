package com.github.tyrrx.vb6language.psi.tree.interfaces.identifier

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement

interface VB6Identifier: PsiNamedElement {
    fun getOwner(): PsiElement
}