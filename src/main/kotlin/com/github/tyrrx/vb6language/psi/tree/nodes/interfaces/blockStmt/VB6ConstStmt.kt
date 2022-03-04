package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt

import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base.VB6BlockStatement
import com.github.tyrrx.vb6language.psi.tree.nodes.mixins.VB6GetVisibilityFromChildrenMixin

interface VB6ConstStmt : VB6BlockStatement, VB6GetVisibilityFromChildrenMixin {
    fun getDeclarations(): List<VB6ConstSubStmt>
}