package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.loops


import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6AmbiguousIdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6BlockScope
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6BlockStatementMember
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6GetAsTypeClause
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6GetTypeHintFromChildrenMixin

interface VB6ForNextStmt :
    VB6BlockStatementMember,
    VB6BlockScope,
    VB6AmbiguousIdentifierOwner,
    VB6GetAsTypeClause,
    VB6GetTypeHintFromChildrenMixin {
}