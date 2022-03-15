package com.github.tyrrx.vb6language.psi.tree.mixins

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6VisibilityOwner
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Visibility
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6VisibilityEnum
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType

interface VB6GetVisibilityFromChildrenMixin: VB6VisibilityOwner {
    override fun getVisibility(): VB6VisibilityEnum {
        return findFirstChildByType<VB6Visibility>(this)
            ?.getEnumValue() ?: VB6VisibilityEnum.PUBLIC
    }
}