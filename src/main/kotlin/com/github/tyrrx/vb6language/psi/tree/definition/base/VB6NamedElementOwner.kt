package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.intellij.psi.PsiNameIdentifierOwner

interface VB6NamedElementOwner: PsiNameIdentifierOwner, VB6PsiElement {
    override fun getNameIdentifier(): VB6NamedElement?
    override fun getName(): String? {
        return nameIdentifier?.name
    }
    val isDefinition: Boolean
}

