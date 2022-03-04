package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base

import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6VisibilityEnum
import com.intellij.psi.PsiElement

interface VB6GetVisibility: PsiElement {
    fun getVisibility(): VB6VisibilityEnum
}