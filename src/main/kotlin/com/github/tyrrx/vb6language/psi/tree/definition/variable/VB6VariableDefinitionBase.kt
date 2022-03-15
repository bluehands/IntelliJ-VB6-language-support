package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6TypeClauseOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6SubscriptsOwner
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6GetTypeHintFromChildrenMixin

interface VB6VariableDefinitionBase:
    VB6IdentifierOwner,
    VB6TypeClauseOwner,
    VB6SubscriptsOwner,
    VB6GetTypeHintFromChildrenMixin {
    fun isArray(): Boolean // not valid in module with events https://docs.microsoft.com/en-us/previous-versions/visualstudio/visual-basic-6/aa243352(v=vs.60)
}