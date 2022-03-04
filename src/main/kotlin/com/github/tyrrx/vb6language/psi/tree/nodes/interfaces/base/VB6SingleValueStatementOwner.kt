package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base

import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6ValueImpl
import com.intellij.psi.PsiElement

interface VB6SingleValueStatementOwner: PsiElement {
    fun getValueStatement(): VB6ValueImpl
}