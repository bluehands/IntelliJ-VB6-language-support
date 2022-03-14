package com.github.tyrrx.vb6language.psi.tree.interfaces.module

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6AttributeStmt

interface VB6ModuleAttributes : VB6PsiElement {
    fun getAttributes(): List<VB6AttributeStmt>
}
