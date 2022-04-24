package com.github.tyrrx.vb6language.psi.mixins

import com.github.tyrrx.vb6language.psi.inference.VB6TypeHintOwner
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6TypeHint
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType

interface VB6TypeHintOwnerMixin: VB6TypeHintOwner {
    override fun getTypeHint(): VB6TypeHint? {
        return findFirstChildByType(this)
    }
}