package com.github.tyrrx.vb6language.psi.tree.interfaces.base

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiErrorElement
import org.antlr.intellij.adaptor.psi.Trees

interface VB6PsiElement : PsiElement {
    override fun getContext(): VB6ScopeNode?
}