package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6GetAsTypeClause
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6GetVisibility
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6GetTypeHintFromChildrenMixin

interface VB6ConstSubStmt:
    VB6IdentifierOwner,
    VB6GetVisibility,
    VB6GetAsTypeClause,
    VB6GetTypeHintFromChildrenMixin {
}