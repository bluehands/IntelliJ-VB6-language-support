package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6AmbiguousIdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement

interface VB6LineLabel : VB6Statement,
    VB6AmbiguousIdentifierOwner {
}