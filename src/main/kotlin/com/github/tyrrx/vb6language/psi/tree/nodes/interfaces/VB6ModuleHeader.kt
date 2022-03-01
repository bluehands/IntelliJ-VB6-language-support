package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces

import com.intellij.psi.PsiElement

interface VB6ModuleHeader: PsiElement {
    fun getVersion(): Double
    fun isClass(): Boolean
}