package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.tree.definition.VB6ValueStmt
import com.intellij.psi.PsiElement

interface VB6SingleValueStatementOwner: PsiElement {
    fun getValueStatement(): VB6ValueStmt
}