package com.github.tyrrx.vb6language.psi.tree

import com.intellij.psi.PsiElement

interface VB6ModuleHeader: PsiElement {
    fun getVersion(): Double
    fun isClass(): Boolean
}