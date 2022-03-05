package com.github.tyrrx.vb6language.psi.tree.utils

import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType

inline fun <reified TResult: PsiElement> findFirstChildByType(parentOfChildren: PsiElement): TResult? {
    return PsiTreeUtil.getChildOfType(parentOfChildren, TResult::class.java)
}

inline fun <reified TResult: PsiElement> findPsiElementsInDirectChildrenByType(parentOfChildren: PsiElement): List<TResult> {
    return PsiTreeUtil.getChildrenOfTypeAsList(parentOfChildren, TResult::class.java)
}

fun findInChildrenByIElementType(root: PsiElement, elementType: IElementType): PsiElement? {
    return root.children.find { psiElement -> psiElement.elementType == elementType }
}

fun findInChildrenByAnyOfGivenElementTypes(root: PsiElement, elementTypes: Collection<IElementType>): PsiElement? {
    return root.children.find { psiElement -> psiElement.elementType in elementTypes }
}