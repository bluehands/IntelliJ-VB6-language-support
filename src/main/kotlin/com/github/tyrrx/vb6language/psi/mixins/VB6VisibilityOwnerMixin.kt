package com.github.tyrrx.vb6language.psi.mixins

import com.github.tyrrx.vb6language.psi.scope.VB6VisibilityOwner
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Visibility
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6VisibilityEnum
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType

interface VB6VisibilityOwnerMixin : VB6VisibilityOwner {
    override val visibility: VB6VisibilityEnum
        get() {
            return findFirstChildByType<VB6Visibility>(this)
                ?.getEnumValue() ?: VB6VisibilityEnum.PUBLIC
        }
}