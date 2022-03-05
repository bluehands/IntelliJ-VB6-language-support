package com.github.tyrrx.vb6language.psi.tree.mixins

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6GetVisibility
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6Visibility
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6VisibilityEnum
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType

interface VB6GetVisibilityFromChildrenMixin: VB6GetVisibility {
    override fun getVisibility(): VB6VisibilityEnum {
        return findFirstChildByType<VB6Visibility>(this)
            ?.getEnumValue() ?: VB6VisibilityEnum.PUBLIC
    }
}