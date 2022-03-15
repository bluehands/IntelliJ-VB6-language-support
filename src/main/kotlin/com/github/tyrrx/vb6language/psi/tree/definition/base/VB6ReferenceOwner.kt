package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier

interface VB6ReferenceOwner: VB6PsiElement {
    fun getIdentifier(): VB6Identifier
}