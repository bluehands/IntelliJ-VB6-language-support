package com.github.tyrrx.vb6language.psi.tree.visitor

import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6EnumerationStmtImpl
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6Module
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6TypeStmtImpl

interface TypeDeclarationVisitor<TReturn> {
    fun processModuleDeclarations(module: VB6Module): TReturn
    fun processTypeStmtDeclarations(type: VB6TypeStmtImpl): TReturn
    fun processEnumerationStmtDeclarations(enum: VB6EnumerationStmtImpl): TReturn
}