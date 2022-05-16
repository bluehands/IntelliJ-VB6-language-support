package com.github.tyrrx.vb6language.psi.visitor

import com.github.tyrrx.vb6language.psi.tree.definition.module.*

interface TypeDeclarationVisitor<TReturn> {
    fun visitModule(module: VB6Module): TReturn
    fun visitType(type: VB6TypeStmt): TReturn
    fun visitEnum(enum: VB6EnumerationStmt): TReturn
}