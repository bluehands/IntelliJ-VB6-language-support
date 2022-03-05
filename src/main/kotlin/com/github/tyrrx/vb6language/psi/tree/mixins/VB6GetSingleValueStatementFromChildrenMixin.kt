package com.github.tyrrx.vb6language.psi.tree.mixins

import com.github.tyrrx.vb6language.psi.tree.impl.VB6ValueImpl
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6SingleValueStatementOwner
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType

interface VB6GetSingleValueStatementFromChildrenMixin:
    VB6SingleValueStatementOwner {
    override fun getValueStatement(): VB6ValueImpl {
        return findFirstChildByType(this)!!
    }
}