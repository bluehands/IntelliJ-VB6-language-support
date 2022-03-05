package com.github.tyrrx.vb6language.psi.tree.interfaces

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6GetAsTypeClause
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6GetVisibility
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6SubscriptsOwner
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6AmbiguousIdentifierFromChildrenMixin
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6GetTypeHintFromChildrenMixin

/** [com.github.tyrrx.vb6language.psi.tree.impl.VB6VariableSubStmtImpl] */
interface VB6VariableSubStmt :
    VB6GetVisibility,
    VB6GetAsTypeClause,
    VB6SubscriptsOwner,
    VB6GetTypeHintFromChildrenMixin,
    VB6AmbiguousIdentifierFromChildrenMixin {
        fun withEvents(): Boolean
}