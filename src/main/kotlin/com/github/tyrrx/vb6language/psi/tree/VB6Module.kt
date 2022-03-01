package com.github.tyrrx.vb6language.psi.tree

import com.intellij.psi.PsiNameIdentifierOwner
import org.antlr.intellij.adaptor.psi.ScopeNode

interface VB6Module : ScopeNode, PsiNameIdentifierOwner {
    fun getModuleAttributes(): Collection<VB6Attribute>
    fun getModuleHeaders(): Collection<VB6ModuleHeader>
    fun isClass(): Boolean
}