package com.github.tyrrx.vb6language.psi.tree

import com.intellij.psi.PsiElement

interface VB6VisibilityModifiedElement: PsiElement {
    fun getVisibility(): VB6VisibilityEnum {
        return findPsiElementInSubtree<VB6Visibility>(this)
            ?.getEnumValue() ?: VB6VisibilityEnum.PUBLIC
    }
}