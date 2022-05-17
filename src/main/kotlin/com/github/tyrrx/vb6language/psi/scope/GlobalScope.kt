package com.github.tyrrx.vb6language.psi.scope

import com.github.tyrrx.vb6language.psi.declarations.*
import com.github.tyrrx.vb6language.psi.tree.definition.VB6File
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6Module

@Suppress("MemberVisibilityCanBePrivate")
class GlobalScope(private val file: VB6File) : IModuleScope {

    val modules: List<VB6Module>
        get() = file.projects.flatMap { it.modules }

    val standardModules: List<VB6Module>
        get() = modules.filter { !it.isClass() }

    val classModules: List<VB6Module>
        get() = modules.filter { it.isClass() }

    val moduleTypeDeclarations: List<VB6TypeDeclaration>
        get() = modules.flatMap { module ->
            module.outsideVisibleNamedElementOwners.filterIsInstance<VB6TypeDeclaration>()
        }

    override val typeDeclarations: List<VB6TypeDeclaration>
        get() = modules + moduleTypeDeclarations

    override val procedureDeclarations: List<VB6ProcedureDeclaration>
        get() = modules.flatMap {
            it.outsideVisibleNamedElementOwners.filterIsInstance<VB6ProcedureDeclaration>()
        }

    override val functionDeclarations: List<VB6FunctionDeclaration>
        get() = procedureDeclarations.filterIsInstance<VB6FunctionDeclaration>()

    override val subroutineDeclarations: List<VB6SubroutineDeclaration>
        get() = procedureDeclarations.filterIsInstance<VB6SubroutineDeclaration>()

    override val valueDeclarations: List<VB6ValueDeclaration>
        get() = modules.flatMap { module ->
            module.outsideVisibleNamedElementOwners.filterIsInstance<VB6ValueDeclaration>()
        }

    override val constantDeclarations: List<VB6ConstantDeclaration>
        get() = valueDeclarations.filterIsInstance<VB6ConstantDeclaration>()

    override val variableDeclarations: List<VB6VariableDeclaration>
        get() = valueDeclarations.filterIsInstance<VB6VariableDeclaration>()
}