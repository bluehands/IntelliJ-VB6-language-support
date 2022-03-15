package com.github.tyrrx.vb6language.psi.tree.utils

import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Literal
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

inline fun <reified TResult: PsiElement> findPsiElementInSubtree(subtreeRoot: PsiElement): TResult? {
    return PsiTreeUtil.findChildOfType(subtreeRoot, TResult::class.java);
}

inline fun <reified TResult: PsiElement> findPsiElementsInSubtree(subtreeRoot: PsiElement): Collection<TResult> {
    return PsiTreeUtil.findChildrenOfType(subtreeRoot, TResult::class.java);
}

fun findLiteralsInSubtree(subtreeRoot: PsiElement): Collection<VB6Literal> {
    return findPsiElementsInSubtree(subtreeRoot)
}