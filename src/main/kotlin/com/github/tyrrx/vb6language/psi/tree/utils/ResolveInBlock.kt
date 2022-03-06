package com.github.tyrrx.vb6language.psi.tree.utils

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6BlockScope
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement

fun tryResolveInBlock(blockScope: VB6BlockScope, element: PsiNamedElement?): VB6IdentifierOwner? {
    return blockScope
        .getBlock()
        ?.getStatements()
        ?.flatMap { findPsiElementsInSubtree<VB6IdentifierOwner>(it) }
        ?.find { it.name == element?.name }
}

fun tryResolveInParentContext(blockScope: VB6BlockScope, element: PsiNamedElement?): VB6IdentifierOwner? {
    return blockScope.context?.resolve(element)
}

fun tryResolveSelf(blockScope: VB6BlockScope, element: PsiNamedElement?): VB6IdentifierOwner? {
    return when (blockScope) {
        is VB6IdentifierOwner -> if (blockScope.name == element?.name) blockScope else null
        else -> null
    }
}

fun tryResolveInBlockScopeOrParentContext(blockScope: VB6BlockScope, element: PsiNamedElement?): VB6IdentifierOwner? {
    return tryResolveInBlock(blockScope, element)
        ?: tryResolveInParentContext(blockScope, element)
}

