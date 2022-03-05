package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6AmbiguousIdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6BlockStatementMember

interface VB6LineLabel : VB6BlockStatementMember,
    VB6AmbiguousIdentifierOwner {
}