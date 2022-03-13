package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6TypeClauseDefinition
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6VisibilityDefinition
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6GetTypeHintFromChildrenMixin

interface VB6ConstSubStmt:
    VB6IdentifierOwner,
    VB6VisibilityDefinition,
    VB6TypeClauseDefinition,
    VB6GetTypeHintFromChildrenMixin {
}