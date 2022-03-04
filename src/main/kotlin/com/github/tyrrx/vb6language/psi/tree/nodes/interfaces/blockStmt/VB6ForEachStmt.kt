package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base.VB6AmbiguousIdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base.VB6BlockScope
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base.VB6BlockStatement
import com.github.tyrrx.vb6language.psi.tree.nodes.mixins.VB6GetTypeHintFromChildrenMixin

interface VB6ForEachStmt :
    VB6BlockStatement,
    VB6BlockScope,
    VB6AmbiguousIdentifierOwner,
    VB6GetTypeHintFromChildrenMixin {
}