package com.github.tyrrx.vb6language.psi.tree.interfaces.base

import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6VisibilityEnum
import com.intellij.psi.PsiElement

interface VB6VisibilityDefinition: PsiElement {
    fun getVisibility(): VB6VisibilityEnum
}