package com.github.tyrrx.vb6language.psi.scope

import com.github.tyrrx.vb6language.psi.declarations.VB6FunctionDeclaration
import com.github.tyrrx.vb6language.psi.declarations.VB6ProcedureDeclaration
import com.github.tyrrx.vb6language.psi.declarations.VB6SubroutineDeclaration
import com.github.tyrrx.vb6language.psi.declarations.VB6TypeDeclaration
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
        get() = standardModules.flatMap { standardModule ->
            standardModule.outsideVisibleNamedElementOwners.filterIsInstance<VB6TypeDeclaration>()
        }

    override val typeDeclarations: List<VB6TypeDeclaration>
        get() = standardModules + moduleTypeDeclarations

    override val procedureDeclarations: List<VB6ProcedureDeclaration>
        get() = standardModules.flatMap {
            it.outsideVisibleNamedElementOwners.filterIsInstance<VB6ProcedureDeclaration>()
        }

    override val functionDeclarations: List<VB6FunctionDeclaration>
        get() = procedureDeclarations.filterIsInstance<VB6FunctionDeclaration>()

    override val subroutineDeclarations: List<VB6SubroutineDeclaration>
        get() = procedureDeclarations.filterIsInstance<VB6SubroutineDeclaration>()
}