package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces

import com.intellij.psi.PsiElement

interface VB6AsTypeClause:PsiElement {
    fun isAutoInitialized(): Boolean // default false
    fun getFieldLength(): VB6FieldLength?
    fun getTypeRule(): VB6TypeRule
}
