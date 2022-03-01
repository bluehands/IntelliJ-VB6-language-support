package com.github.tyrrx.vb6language.psi.tree

import com.intellij.psi.PsiElement

interface VB6Visibility: PsiElement {
    fun getEnumValue(): VB6VisibilityEnum
}