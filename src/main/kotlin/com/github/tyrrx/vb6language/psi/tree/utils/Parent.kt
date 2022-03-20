package com.github.tyrrx.vb6language.psi.tree.utils

import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

inline fun <reified TResult : PsiElement> findFirstParentOfType(element: PsiElement): TResult? {
    return PsiTreeUtil.findFirstParent(element) { it is TResult } as TResult?
}