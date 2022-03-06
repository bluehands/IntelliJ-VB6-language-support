package com.github.tyrrx.vb6language.psi.tree.interfaces.module

import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6Attribute
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6ScopeNode
import com.intellij.psi.PsiNameIdentifierOwner

interface VB6Module : VB6ScopeNode, PsiNameIdentifierOwner {
    fun isClass(): Boolean
    fun getModuleHeaders(): Collection<VB6ModuleHeader>
    // TODO module references
    // TODO control properties
    fun getModuleConfigElements(): Collection<VB6ModuleConfigElement>
    fun getModuleAttributes(): Collection<VB6Attribute>
    // TODO get module options

    fun getFunctions(): Collection<VB6FunctionStatement>
    fun getSubroutines(): Collection<VB6SubroutineStatement>

}