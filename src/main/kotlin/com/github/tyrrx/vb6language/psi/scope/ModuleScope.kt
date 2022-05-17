package com.github.tyrrx.vb6language.psi.scope

import com.github.tyrrx.vb6language.psi.declarations.*
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6Module
import com.github.tyrrx.vb6language.psi.tree.definition.module.namedElementOwners

class ModuleScope(private val module: VB6Module) : IModuleScope {

    override val typeDeclarations: List<VB6TypeDeclaration>
        get() = module.namedElementOwners.filterIsInstance<VB6TypeDeclaration>()

    override val procedureDeclarations: List<VB6ProcedureDeclaration>
        get() = module.namedElementOwners.filterIsInstance<VB6ProcedureDeclaration>()

    override val functionDeclarations: List<VB6FunctionDeclaration>
        get() = procedureDeclarations.filterIsInstance<VB6FunctionDeclaration>()

    override val subroutineDeclarations: List<VB6SubroutineDeclaration>
        get() = procedureDeclarations.filterIsInstance<VB6SubroutineDeclaration>()

    override val valueDeclarations: List<VB6ValueDeclaration>
        get() = module.namedElementOwners.filterIsInstance<VB6ValueDeclaration>()

    override val constantDeclarations: List<VB6ConstantDeclaration>
        get() = valueDeclarations.filterIsInstance<VB6ConstantDeclaration>()

    override val variableDeclarations: List<VB6VariableDeclaration>
        get() = valueDeclarations.filterIsInstance<VB6VariableDeclaration>()
}