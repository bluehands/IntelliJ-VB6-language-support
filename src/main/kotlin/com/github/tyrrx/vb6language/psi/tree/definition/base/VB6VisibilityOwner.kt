package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6VisibilityEnum
import com.intellij.psi.PsiElement

interface VB6VisibilityOwner: PsiElement {
    fun getVisibility(): VB6VisibilityEnum
}