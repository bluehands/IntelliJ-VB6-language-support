package com.github.tyrrx.vb6language.psi.reference.visitor

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6Module
import com.github.tyrrx.vb6language.psi.tree.definition.module.fromDeclarationsGetArrayVariables
import com.github.tyrrx.vb6language.psi.tree.definition.module.fromDeclarationsGetDeclares

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