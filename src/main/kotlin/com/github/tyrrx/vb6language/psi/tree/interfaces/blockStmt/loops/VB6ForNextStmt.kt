package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.loops


import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6BlockScope
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6GetAsTypeClause
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6GetTypeHintFromChildrenMixin

interface VB6ForNextStmt :
    VB6Statement,
    VB6BlockScope,
    VB6IdentifierOwner,
    VB6GetAsTypeClause,
    VB6GetTypeHintFromChildrenMixin {
}