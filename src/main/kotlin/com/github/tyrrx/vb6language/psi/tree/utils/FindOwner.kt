package com.github.tyrrx.vb6language.psi.tree.utils

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.intellij.psi.PsiElement

fun findOwnerRecursive(element: PsiElement): PsiElement {
    return when(element) {
        is VB6IdentifierOwner -> element
        is VB6ReferenceOwner -> element
        else -> findOwnerRecursive(element.parent)
    }
}