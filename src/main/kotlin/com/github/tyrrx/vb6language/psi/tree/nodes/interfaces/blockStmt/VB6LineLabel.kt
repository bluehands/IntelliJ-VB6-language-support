package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base.VB6AmbiguousIdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base.VB6BlockStatement

interface VB6LineLabel : VB6BlockStatement, VB6AmbiguousIdentifierOwner {
}