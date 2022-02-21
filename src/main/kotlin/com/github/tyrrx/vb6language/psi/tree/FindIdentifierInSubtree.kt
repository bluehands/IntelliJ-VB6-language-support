package com.github.tyrrx.vb6language.psi.tree

import com.github.tyrrx.vb6language.psi.tree.leafes.IdentifierPsiLeaf
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

fun tryFindIdentifierInSubtree(subtreeRoot: PsiElement): IdentifierPsiLeaf? {
    return PsiTreeUtil.findChildOfType(subtreeRoot, IdentifierPsiLeaf::class.java)
}