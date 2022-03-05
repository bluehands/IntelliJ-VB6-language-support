package com.github.tyrrx.vb6language.psi.tree.mixins

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6GetTypeHint
import com.github.tyrrx.vb6language.psi.tree.interfaces.type.VB6TypeHint
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType

interface VB6GetTypeHintFromChildrenMixin: VB6GetTypeHint {
    override fun getTypeHint(): VB6TypeHint? {
        return findFirstChildByType(this)
    }
}