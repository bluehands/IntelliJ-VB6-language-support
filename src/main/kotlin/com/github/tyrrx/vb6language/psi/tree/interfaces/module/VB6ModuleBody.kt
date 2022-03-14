package com.github.tyrrx.vb6language.psi.tree.interfaces.module

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiElement
import com.intellij.psi.PsiElement

interface VB6ModuleBody : PsiElement {
    fun getStatements(): List<VB6PsiElement>
}