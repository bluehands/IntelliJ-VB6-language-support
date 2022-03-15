package com.github.tyrrx.vb6language.psi.tree.mixins

import com.github.tyrrx.vb6language.psi.tree.definition.VB6ValueStmt
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6SingleValueStatementOwner
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType

interface VB6GetSingleValueStatementFromChildrenMixin:
    VB6SingleValueStatementOwner {
    override fun getValueStatement(): VB6ValueStmt {
        return findFirstChildByType(this)!!
    }
}