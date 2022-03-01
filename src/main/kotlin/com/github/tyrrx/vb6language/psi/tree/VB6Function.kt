package com.github.tyrrx.vb6language.psi.tree

import com.intellij.psi.PsiNameIdentifierOwner
import org.antlr.intellij.adaptor.psi.ScopeNode

interface VB6Function: ScopeNode, PsiNameIdentifierOwner {
    fun getVisibility(): VB6VisibilityEnum
    fun isStatic(): Boolean
}