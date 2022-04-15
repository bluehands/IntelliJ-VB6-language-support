package com.github.tyrrx.vb6language.language

import com.github.tyrrx.vb6language.psi.base.VB6PsiElement
import com.intellij.lang.ASTNode

interface IPsiNodeFactory<T : VB6PsiElement> {
    fun createPsiNode(node: ASTNode): T
}