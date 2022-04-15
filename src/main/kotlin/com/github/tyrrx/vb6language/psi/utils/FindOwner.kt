package com.github.tyrrx.vb6language.psi.utils

import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.base.VB6ReferenceOwner
import com.intellij.psi.PsiElement

fun findOwnerRecursive(element: PsiElement): PsiElement {
    return when (element) {
        is VB6NamedElementOwner -> element
        is VB6ReferenceOwner -> element
        else -> findOwnerRecursive(element.parent)
    }
}

fun findIdentifierOwnerRecursive(element: PsiElement?): VB6NamedElementOwner? {
    return when (element) {
        null -> null
        is VB6NamedElementOwner -> element
        else -> findIdentifierOwnerRecursive(element.parent)
    }
}

fun findReferenceOwnerRecursive(element: PsiElement?): VB6ReferenceOwner? {
    return when (element) {
        null -> null
        is VB6ReferenceOwner -> element
        else -> findReferenceOwnerRecursive(element.parent)
    }
}

