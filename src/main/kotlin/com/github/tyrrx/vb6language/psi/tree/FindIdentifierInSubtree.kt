package com.github.tyrrx.vb6language.psi.tree

import com.github.tyrrx.vb6language.psi.tree.leafes.IdentifierPsiLeaf
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.util.PsiTreeUtil

fun findIdentifierInSubtree(subtreeRoot: PsiElement): IdentifierPsiLeaf? {
    return PsiTreeUtil.findChildOfType(subtreeRoot, IdentifierPsiLeaf::class.java)
}

fun PsiNameIdentifierOwner.findIdentifierInSubtree(): IdentifierPsiLeaf? {
    return findIdentifierInSubtree(this)
}