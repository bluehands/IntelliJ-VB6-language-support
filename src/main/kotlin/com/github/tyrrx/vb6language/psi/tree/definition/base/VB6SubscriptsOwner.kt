package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6SubscriptElement

interface VB6SubscriptsOwner {
    fun getSubscripts(): List<VB6SubscriptElement>
}