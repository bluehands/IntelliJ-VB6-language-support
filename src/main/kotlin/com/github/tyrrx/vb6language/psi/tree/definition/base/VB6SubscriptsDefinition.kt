package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.tree.definition.VB6SubscriptElement

interface VB6SubscriptsDefinition {
    fun getSubscripts(): List<VB6SubscriptElement>
}