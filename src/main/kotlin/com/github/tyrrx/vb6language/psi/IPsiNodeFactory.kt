package com.github.tyrrx.vb6language.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.CompositeElement

interface IPsiNodeFactory<T : PsiElement> {
    fun createPsiNode(node: ASTNode): T
}