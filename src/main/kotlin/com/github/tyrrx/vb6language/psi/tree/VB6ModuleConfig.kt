package com.github.tyrrx.vb6language.psi.tree

import com.intellij.psi.PsiElement

interface VB6ModuleConfig: PsiElement {
    fun getModuleConfigElements(): Collection<VB6ModuleConfigElement>
}