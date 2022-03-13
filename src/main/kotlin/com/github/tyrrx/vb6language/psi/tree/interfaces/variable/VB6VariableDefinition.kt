package com.github.tyrrx.vb6language.psi.tree.interfaces.variable

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6TypeClauseDefinition
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6SubscriptsDefinition
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6GetTypeHintFromChildrenMixin

interface VB6VariableDefinition:
    VB6IdentifierOwner,
    VB6TypeClauseDefinition,
    VB6SubscriptsDefinition,
    VB6GetTypeHintFromChildrenMixin {
    fun isArray(): Boolean // not valid in module with events https://docs.microsoft.com/en-us/previous-versions/visualstudio/visual-basic-6/aa243352(v=vs.60)
}