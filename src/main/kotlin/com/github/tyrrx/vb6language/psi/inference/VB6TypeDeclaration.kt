package com.github.tyrrx.vb6language.psi.inference

import com.github.tyrrx.vb6language.psi.visitor.TypeDeclarationVisitor

interface VB6TypeDeclaration {
    fun <TReturn> processTypeDeclarations(visitor: TypeDeclarationVisitor<TReturn>): TReturn
}