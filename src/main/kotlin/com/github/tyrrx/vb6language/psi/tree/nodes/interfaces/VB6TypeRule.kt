package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces

import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base.VB6Type
import com.intellij.psi.PsiElement

interface VB6TypeRule: PsiElement {
    fun getComplexOrBaseType(): VB6Type
}
