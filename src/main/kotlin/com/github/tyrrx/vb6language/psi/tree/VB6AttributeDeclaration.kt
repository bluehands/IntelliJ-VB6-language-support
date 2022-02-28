package com.github.tyrrx.vb6language.psi.tree

import com.github.tyrrx.vb6language.psi.tree.nodes.VB6LiteralImpl
import com.intellij.psi.PsiNameIdentifierOwner

interface VB6AttributeDeclaration : PsiNameIdentifierOwner {
    fun getLiterals(): Collection<VB6Literal>
}