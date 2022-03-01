package com.github.tyrrx.vb6language.psi.tree

import com.intellij.psi.PsiNameIdentifierOwner

interface VB6ModuleConfigElement: PsiNameIdentifierOwner {
    fun getLiteral(): VB6Literal?
}