package com.github.tyrrx.vb6language.psi.tree.interfaces.module

import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6Attribute
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PropertyStatement
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6ScopeNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.variable.VB6ModuleVariableDefinition
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner

interface VB6Module : VB6ScopeNode, PsiNameIdentifierOwner {
    fun isClass(): Boolean

    fun getModuleHeaders(): Collection<VB6ModuleHeader>
    // TODO module references
    // TODO control properties
    fun getModuleConfigElements(): Collection<VB6ModuleConfigElement>
    fun getModuleAttributes(): Collection<VB6Attribute>
    // TODO get module options

    fun getModuleBody(): VB6ModuleBody?

    fun getFunctions(): List<VB6FunctionStatement>
    fun getSubroutines(): List<VB6SubroutineStatement>
    fun getExternalFunctions()
    fun getExternalSubroutines()

    fun getPropertyGets(): List<VB6PropertyGetStatement>
    fun getPropertySets(): List<VB6PropertySetStatement>
    fun getPropertyLets(): List<VB6PropertyLetStatement>

    fun getModuleVariables(): List<VB6ModuleVariableDefinition>

    fun getBodyStatements(): List<PsiElement>
}