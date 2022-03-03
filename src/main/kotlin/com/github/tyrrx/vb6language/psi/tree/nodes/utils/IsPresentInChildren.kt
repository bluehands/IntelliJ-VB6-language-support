package com.github.tyrrx.vb6language.psi.tree.nodes.utils

import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType

fun IElementType.isIElementTypePresentInChildren(ofParent: PsiElement): Boolean {
    return isIElementTypePresentInChildren(ofParent, this )
}
private fun isIElementTypePresentInChildren(ofParent: PsiElement, elementType: IElementType): Boolean {
    return findInChildrenByIElementType(ofParent, elementType) != null
}
