package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces

import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base.VB6BlockStatement
import com.intellij.psi.PsiElement

interface VB6BlockStatementRule:PsiElement {
    fun getStatement(): VB6BlockStatement
}
