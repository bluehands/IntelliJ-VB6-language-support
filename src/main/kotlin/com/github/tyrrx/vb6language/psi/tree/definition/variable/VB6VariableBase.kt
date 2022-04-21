package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.base.VB6SubscriptsOwner
import com.github.tyrrx.vb6language.psi.inference.VB6TypeClauseOwner
import com.github.tyrrx.vb6language.psi.mixins.VB6TypeHintMixin

interface VB6VariableBase :
        VB6NamedElementOwner,
        VB6TypeClauseOwner,
        VB6SubscriptsOwner,
        VB6TypeHintMixin {
    fun isArray(): Boolean // not valid in module with events https://docs.microsoft.com/en-us/previous-versions/visualstudio/visual-basic-6/aa243352(v=vs.60)
}