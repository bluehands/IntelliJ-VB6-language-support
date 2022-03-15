package com.github.tyrrx.vb6language.psi.tree.mixins

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6TypeHintDefinition
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6TypeHint
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType

interface VB6GetTypeHintFromChildrenMixin: VB6TypeHintDefinition {
    override fun getTypeHint(): VB6TypeHint? {
        return findFirstChildByType(this)
    }
}