package com.github.tyrrx.vb6language.psi.tree.mixins

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6VisibilityDefinition
import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6Visibility
import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6VisibilityEnum
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType

interface VB6GetVisibilityFromChildrenMixin: VB6VisibilityDefinition {
    override fun getVisibility(): VB6VisibilityEnum {
        return findFirstChildByType<VB6Visibility>(this)
            ?.getEnumValue() ?: VB6VisibilityEnum.PUBLIC
    }
}