package com.github.tyrrx.vb6language.psi.tree

import com.intellij.psi.PsiNameIdentifierOwner
import org.antlr.intellij.adaptor.psi.ScopeNode

interface VB6Module : ScopeNode, PsiNameIdentifierOwner {
    fun isClass(): Boolean
    fun getModuleHeaders(): Collection<VB6ModuleHeader>
    // TODO module references
    // TODO control properties
    fun getModuleConfigElements(): Collection<VB6ModuleConfigElement>
    fun getModuleAttributes(): Collection<VB6Attribute>
    // TODO get module options

    fun getFunctions(): Collection<VB6Function>
    fun getSubroutines(): Collection<VB6Subroutine>

}