package com.github.tyrrx.vb6language.psi.scope

import com.github.tyrrx.vb6language.psi.base.VB6FunctionDeclaration
import com.github.tyrrx.vb6language.psi.base.VB6ProcedureDeclaration
import com.github.tyrrx.vb6language.psi.base.VB6SubroutineDeclaration
import com.github.tyrrx.vb6language.psi.inference.VB6TypeDeclaration
import com.github.tyrrx.vb6language.psi.tree.definition.VB6File
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6Module

@Suppress("MemberVisibilityCanBePrivate")
class GlobalScope(private val file: VB6File) {

    val modules: List<VB6Module>
        get() = file.projects.flatMap { it.modules }

    val standardModules: Iterable<VB6Module>
        get() = modules.filter { !it.isClass() }

    val classModules: Iterable<VB6Module>
        get() = modules.filter { it.isClass() }

    val moduleTypeDeclarations
        get() = standardModules.flatMap { standardModule ->
            standardModule.outsideVisibleNamedElementOwners.filterIsInstance<VB6TypeDeclaration>()
        }

    val typeDeclarations: Iterable<VB6TypeDeclaration>
        get() = standardModules + moduleTypeDeclarations

    val procedureDeclarations: Iterable<VB6ProcedureDeclaration>
        get() = standardModules.flatMap {
            it.outsideVisibleNamedElementOwners.filterIsInstance<VB6ProcedureDeclaration>()
        }

    val functionDeclarations: Iterable<VB6FunctionDeclaration>
        get() = procedureDeclarations.filterIsInstance<VB6FunctionDeclaration>()

    val subroutineDeclarations: Iterable<VB6SubroutineDeclaration>
        get() = procedureDeclarations.filterIsInstance<VB6SubroutineDeclaration>()

}