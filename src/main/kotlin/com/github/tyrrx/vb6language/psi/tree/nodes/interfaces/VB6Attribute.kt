package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces

import com.intellij.psi.PsiNameIdentifierOwner

interface VB6Attribute : PsiNameIdentifierOwner {
    fun getLiterals(): Collection<VB6Literal>
}