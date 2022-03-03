package com.github.tyrrx.vb6language.psi.tree.nodes.utils

import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType

inline fun <reified TResult: PsiElement> findFirstPsiElementInDirectChildrenByType(parentOfChildren: PsiElement): TResult? {
    return PsiTreeUtil.getChildOfType(parentOfChildren, TResult::class.java)
}

fun findLeafInChildrenByElementType(root: PsiElement, elementType: IElementType): PsiElement? {
    return root.children.find { psiElement -> psiElement.elementType == elementType }
}