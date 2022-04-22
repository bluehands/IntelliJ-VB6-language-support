package com.github.tyrrx.vb6language.psi.scope

import com.github.tyrrx.vb6language.psi.base.VB6FunctionDeclaration
import com.github.tyrrx.vb6language.psi.base.VB6ProcedureDeclaration
import com.github.tyrrx.vb6language.psi.base.VB6SubroutineDeclaration
import com.github.tyrrx.vb6language.psi.inference.VB6TypeDeclaration
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6Module

class ModuleScope(private val module: VB6Module) : IModuleScope {

    override val typeDeclarations: List<VB6TypeDeclaration>
        get() = module.outsideVisibleNamedElementOwners.filterIsInstance<VB6TypeDeclaration>()

    override val procedureDeclarations: List<VB6ProcedureDeclaration>
        get() = module.outsideVisibleNamedElementOwners.filterIsInstance<VB6ProcedureDeclaration>()

    override val functionDeclarations: List<VB6FunctionDeclaration>
        get() = procedureDeclarations.filterIsInstance<VB6FunctionDeclaration>()

    override val subroutineDeclarations: List<VB6SubroutineDeclaration>
        get() = procedureDeclarations.filterIsInstance<VB6SubroutineDeclaration>()

}