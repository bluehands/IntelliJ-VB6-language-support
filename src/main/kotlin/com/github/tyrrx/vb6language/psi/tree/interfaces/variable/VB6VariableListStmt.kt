package com.github.tyrrx.vb6language.psi.tree.interfaces.variable

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiElement
import com.intellij.psi.PsiElement

/** [com.github.tyrrx.vb6language.psi.tree.impl.VB6VariableListStmtImpl] */
interface VB6VariableListStmt : VB6PsiElement {
    fun getVariableDefinitions(): List<VB6VariableSubStmt>
}