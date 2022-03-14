package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6Literal
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement

interface VB6AttributeStmt : VB6Statement, VB6IdentifierOwner {
    fun getLiterals(): Collection<VB6Literal>
}