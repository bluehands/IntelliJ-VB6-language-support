package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base

import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6AmbiguousIdentifier
import com.intellij.psi.PsiNameIdentifierOwner

interface VB6AmbiguousIdentifierOwner: PsiNameIdentifierOwner {
    override fun getNameIdentifier(): VB6AmbiguousIdentifier?
    override fun getName(): String? {
        return nameIdentifier?.name
    }
}