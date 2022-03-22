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

fun findIdentifierOwnerRecursive(element: PsiElement): VB6IdentifierOwner {
    return when(element) {
        is VB6IdentifierOwner -> element
        else -> findIdentifierOwnerRecursive(element.parent)
    }
}

fun findReferenceOwnerRecursive(element: PsiElement): VB6ReferenceOwner {
    return when(element) {
        is VB6ReferenceOwner -> element
        else -> findReferenceOwnerRecursive(element.parent)
    }
}

