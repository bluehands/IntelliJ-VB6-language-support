package com.github.tyrrx.vb6language.psi.tree

import com.github.tyrrx.vb6language.psi.tree.leafes.VB6PsiLeaf
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.elementType

fun findLeafInChildrenByElementType(root: PsiElement, elementType: IElementType): PsiElement? {
    return root.children.find { psiElement -> psiElement.elementType == elementType }
}