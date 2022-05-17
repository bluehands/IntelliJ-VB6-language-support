package com.github.tyrrx.vb6language.psi.scope

import com.github.tyrrx.vb6language.psi.declarations.*

interface IModuleScope {
    val typeDeclarations: List<VB6TypeDeclaration>
    val procedureDeclarations: List<VB6ProcedureDeclaration>
    val functionDeclarations: List<VB6FunctionDeclaration>
    val subroutineDeclarations: List<VB6SubroutineDeclaration>
    val valueDeclarations: List<VB6ValueDeclaration>
    val constantDeclarations: List<VB6ConstantDeclaration>
    val variableDeclarations: List<VB6VariableDeclaration>
}