package com.github.tyrrx.vb6language.psi.reference.visitor

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6BlockScope
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6Module
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.fromDeclarationsGetArrayVariables
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.fromDeclarationsGetDeclares
import com.github.tyrrx.vb6language.psi.tree.interfaces.variable.VB6VariableStmt

fun VB6Module.explicitCallScope(): List<VB6IdentifierOwner> {
    return this.getSubroutines().plus(this.getFunctions())
}

//fun VB6Module.explicitMemberCallScope() : List<VB6IdentifierOwner> {
//
//}

@Suppress("FunctionName")
fun VB6Module.arrayOrProcedureScope(): List<VB6IdentifierOwner> {
    return fromDeclarationsGetArrayVariables() with
            fromDeclarationsGetDeclares() with
            getFunctions() with
            getSubroutines()
}

infix fun List<VB6IdentifierOwner>.with(that: List<VB6IdentifierOwner>): List<VB6IdentifierOwner> {
    return this.plus(that)
}