package com.github.tyrrx.vb6language.psi.tree

import com.intellij.psi.PsiNameIdentifierOwner
import org.antlr.intellij.adaptor.psi.ScopeNode

interface VB6ModuleDeclaration : ScopeNode, PsiNameIdentifierOwner {
    fun getModuleAttributes(): Collection<VB6AttributeDeclaration>
    fun getModuleHeaders(): Collection<VB6ModuleHeader>
    fun isClass(): Boolean
}