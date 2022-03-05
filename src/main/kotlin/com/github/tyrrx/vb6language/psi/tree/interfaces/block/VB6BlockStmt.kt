package com.github.tyrrx.vb6language.psi.tree.interfaces.block

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6BlockStatementMember
import com.intellij.psi.PsiElement

interface VB6BlockStmt:PsiElement {
    fun getStatement(): VB6BlockStatementMember
}
