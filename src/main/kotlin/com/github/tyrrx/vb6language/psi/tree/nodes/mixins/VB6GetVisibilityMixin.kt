package com.github.tyrrx.vb6language.psi.tree.nodes.mixins

import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6Visibility
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6VisibilityEnum
import com.github.tyrrx.vb6language.psi.tree.nodes.utils.findFirstPsiElementInDirectChildrenByType
import com.github.tyrrx.vb6language.psi.tree.nodes.utils.findPsiElementInSubtree
import com.intellij.psi.PsiElement

interface VB6GetVisibilityMixin: PsiElement {
    fun getVisibility(): VB6VisibilityEnum {
        return findFirstPsiElementInDirectChildrenByType<VB6Visibility>(this)
            ?.getEnumValue() ?: VB6VisibilityEnum.PUBLIC
    }
}