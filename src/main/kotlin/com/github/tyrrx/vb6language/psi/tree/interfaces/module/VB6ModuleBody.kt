package com.github.tyrrx.vb6language.psi.tree.interfaces.module

import com.intellij.psi.PsiElement

interface VB6ModuleBody : PsiElement {
    fun getStatements(): List<PsiElement>
}