package com.github.tyrrx.vb6language.psi.mixins

import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByTypeOf

interface VB6IdentifierFromChildrenMixin:
        VB6NamedElementOwner {

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun getNameIdentifier(): VB6NamedElement? {
        return findFirstChildByTypeOf(this)
    }
}