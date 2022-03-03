package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces

import com.intellij.psi.PsiElement

interface VB6ArgumentList: PsiElement {
    fun getArguments(): List<VB6Argument>
}