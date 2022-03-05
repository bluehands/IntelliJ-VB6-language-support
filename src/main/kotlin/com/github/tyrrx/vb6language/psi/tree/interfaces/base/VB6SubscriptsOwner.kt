package com.github.tyrrx.vb6language.psi.tree.interfaces.base

import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6SubscriptElement

interface VB6SubscriptsOwner {
    fun getSubscripts(): List<VB6SubscriptElement>
}