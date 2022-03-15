package com.github.tyrrx.vb6language.psi.tree.mixins

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6TypeHintOwner
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6TypeHint
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType

interface VB6GetTypeHintFromChildrenMixin: VB6TypeHintOwner {
    override fun getTypeHint(): VB6TypeHint? {
        return findFirstChildByType(this)
    }
}