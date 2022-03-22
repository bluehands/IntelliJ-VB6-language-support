package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.intellij.psi.PsiNameIdentifierOwner

interface VB6IdentifierOwner: PsiNameIdentifierOwner, VB6PsiElement {
    override fun getNameIdentifier(): VB6Identifier?
    override fun getName(): String? {
        return nameIdentifier?.name
    }
    val isDefinition: Boolean
}

