package com.github.tyrrx.vb6language.psi.tree.interfaces.module

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6ScopeNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6ConstStmt
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6ImplementsStmt
import com.github.tyrrx.vb6language.psi.tree.interfaces.variable.VB6ModuleVariableDefinition
import com.intellij.psi.PsiNameIdentifierOwner

interface VB6Module : VB6ScopeNode, PsiNameIdentifierOwner {

    // base
    fun getModuleHeader(): VB6ModuleHeader?
    fun getModuleConfig(): VB6ModuleConfig?
    fun getModuleAttributes(): VB6ModuleAttributes?
    fun getModuleDeclarations(): VB6ModuleDeclarations?
    fun getModuleBody(): VB6ModuleBody?


    fun isClass(): Boolean
    fun getModuleConfigElements(): Collection<VB6ModuleConfigElement>

    fun getFunctions(): List<VB6FunctionStatement>
    fun getSubroutines(): List<VB6SubroutineStatement>
    fun getProcedureDeclarations(): List<VB6DeclareStmt>

    fun getPropertyGets(): List<VB6PropertyGetStatement>
    fun getPropertySets(): List<VB6PropertySetStatement>
    fun getPropertyLets(): List<VB6PropertyLetStatement>

}

fun VB6Module.fromBodyGetElements(): List<VB6PsiElement> {
    return getModuleBody()?.getStatements() ?: emptyList()
}

fun VB6Module.fromDeclarationsGetElements(): List<VB6PsiElement> {
    return getModuleDeclarations()?.getElements()?.map { it.getInnerElement() } ?: emptyList()
}


inline fun <reified TStatement> VB6Module.fromModuleBodyGetByType(): List<TStatement> {
    return fromBodyGetElements().filterIsInstance<TStatement>()
}

inline fun <reified TStatement> VB6Module.fromModuleDeclarationsGetByType(): List<TStatement> {
    return fromDeclarationsGetElements().filterIsInstance<TStatement>()
}


fun VB6Module.fromDeclarationsGetDeclares(): List<VB6DeclareStmt> {
    return fromModuleDeclarationsGetByType()
}

fun VB6Module.fromDeclarationsGetEnumerations(): List<VB6EnumerationStmt> {
    return fromModuleDeclarationsGetByType()
}

fun VB6Module.fromDeclarationsGetEvents(): List<VB6EventStmt> {
    return fromModuleDeclarationsGetByType()
}

fun VB6Module.fromDeclarationsGetConst(): List<VB6ConstStmt> {
    return fromModuleDeclarationsGetByType()
}

fun VB6Module.fromDeclarationsGetImplements(): List<VB6ImplementsStmt> {
    return fromModuleDeclarationsGetByType()
}

fun VB6Module.fromDeclarationsGetVariables(): List<VB6ModuleVariableDefinition> {
    return fromModuleDeclarationsGetByType()
}

fun VB6Module.fromDeclarationsGetArrayVariables(): List<VB6ModuleVariableDefinition> {
    return fromDeclarationsGetVariables().filter { it.isArray() }
}

fun VB6Module.fromDeclarationsGetOptions() {
    TODO("Not yet implemented")
}

fun VB6Module.fromDeclarationsGetTypes(): List<VB6TypeStmt> {
    return fromModuleDeclarationsGetByType()
}

fun VB6Module.fromDeclarationsGetMacros() {
    TODO("Not yet implemented")
}



