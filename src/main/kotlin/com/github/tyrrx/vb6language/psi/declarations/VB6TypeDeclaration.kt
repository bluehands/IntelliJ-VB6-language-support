package com.github.tyrrx.vb6language.psi.declarations

import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.visitor.TypeDeclarationVisitor

interface VB6TypeDeclaration : VB6PsiElement, VB6NamedElementOwner {
    fun <TReturn> processTypeDeclarations(visitor: TypeDeclarationVisitor<TReturn>): TReturn
}