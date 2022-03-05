package com.github.tyrrx.vb6language.psi.tree.interfaces.type

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Type
import com.intellij.psi.PsiElement

interface VB6TypeRule: PsiElement {
    fun getComplexOrBaseType(): VB6Type
}
