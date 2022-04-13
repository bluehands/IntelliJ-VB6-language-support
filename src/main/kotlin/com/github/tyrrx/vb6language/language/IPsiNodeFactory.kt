package com.github.tyrrx.vb6language.language

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface IPsiNodeFactory<T : PsiElement> {
    fun createPsiNode(node: ASTNode): T
}