package com.github.tyrrx.vb6language.psi.tree.nodes.mixins

import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6Visibility
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6VisibilityEnum
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base.VB6GetVisibility
import com.github.tyrrx.vb6language.psi.tree.nodes.utils.findFirstChildByType
import com.intellij.psi.PsiElement

interface VB6GetVisibilityFromChildrenMixin: VB6GetVisibility {
    override fun getVisibility(): VB6VisibilityEnum {
        return findFirstChildByType<VB6Visibility>(this)
            ?.getEnumValue() ?: VB6VisibilityEnum.PUBLIC
    }
}