package com.github.tyrrx.vb6language.psi.scope

import com.github.tyrrx.vb6language.psi.declarations.VB6FunctionDeclaration
import com.github.tyrrx.vb6language.psi.declarations.VB6ProcedureDeclaration
import com.github.tyrrx.vb6language.psi.declarations.VB6SubroutineDeclaration
import com.github.tyrrx.vb6language.psi.declarations.VB6TypeDeclaration

interface IModuleScope {
    val typeDeclarations: List<VB6TypeDeclaration>
    val procedureDeclarations: List<VB6ProcedureDeclaration>
    val functionDeclarations: List<VB6FunctionDeclaration>
    val subroutineDeclarations: List<VB6SubroutineDeclaration>
}