package com.github.tyrrx.vb6language.psi.tree.interfaces.base

import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6Value
import com.intellij.psi.PsiElement

interface VB6SingleValueStatementOwner: PsiElement {
    fun getValueStatement(): VB6Value
}