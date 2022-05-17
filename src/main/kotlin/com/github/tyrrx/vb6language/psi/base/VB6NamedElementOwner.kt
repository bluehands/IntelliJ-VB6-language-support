package com.github.tyrrx.vb6language.psi.base

import com.github.tyrrx.vb6language.psi.scope.VB6EnclosingVisibleNamedElements
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.visitor.NamedElementOwnerVisitor
import com.intellij.psi.PsiNameIdentifierOwner

interface VB6NamedElementOwner : PsiNameIdentifierOwner, VB6PsiElement, VB6EnclosingVisibleNamedElements {

    fun <TReturn> accept(namedElementOwnerVisitor: NamedElementOwnerVisitor<TReturn>): TReturn
    override fun getNameIdentifier(): VB6NamedElement?
    override fun getName(): String? {
        return nameIdentifier?.name
    }

    val isDefinition: Boolean
}

