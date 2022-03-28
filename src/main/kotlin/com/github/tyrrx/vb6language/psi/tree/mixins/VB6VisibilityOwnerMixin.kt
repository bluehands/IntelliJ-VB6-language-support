package com.github.tyrrx.vb6language.psi.tree.mixins

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6VisibilityOwner
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Visibility
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6VisibilityEnum
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType

interface VB6VisibilityOwnerMixin : VB6VisibilityOwner {
    override val visibility: VB6VisibilityEnum
        get() {
            return findFirstChildByType<VB6Visibility>(this)
                ?.getEnumValue() ?: VB6VisibilityEnum.PUBLIC
        }
}