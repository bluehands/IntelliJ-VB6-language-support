package com.github.tyrrx.vb6language.psi.reference.visitor

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6Module

fun VB6Module.explicitCallScope() : List<VB6IdentifierOwner> {
    return this.getSubroutines().plus(this.getFunctions())
}

//fun VB6Module.explicitMemberCallScope() : List<VB6IdentifierOwner> {
//
//}

fun VB6Module.callableScope() {

}