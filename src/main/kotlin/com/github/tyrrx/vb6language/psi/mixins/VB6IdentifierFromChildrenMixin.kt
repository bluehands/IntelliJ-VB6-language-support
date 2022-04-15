package com.github.tyrrx.vb6language.psi.mixins

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType

interface VB6IdentifierFromChildrenMixin:
    VB6NamedElementOwner {

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun getNameIdentifier(): VB6NamedElement? {
        return findFirstChildByType(this)
    }
}