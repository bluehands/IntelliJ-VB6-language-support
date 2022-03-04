package com.github.tyrrx.vb6language.psi.tree.nodes.mixins

import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6ValueImpl
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base.VB6SingleValueStatementOwner
import com.github.tyrrx.vb6language.psi.tree.nodes.utils.findFirstChildByType

interface VB6GetSingleValueStatementFromChildrenMixin: VB6SingleValueStatementOwner {
    override fun getValueStatement(): VB6ValueImpl {
        return findFirstChildByType(this)!!
    }
}