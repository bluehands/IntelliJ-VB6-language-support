package com.github.tyrrx.vb6language.psi.tree.interfaces.block

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.psi.PsiElement

interface VB6BlockStmt:PsiElement {
    fun getMember(): VB6Statement
}
