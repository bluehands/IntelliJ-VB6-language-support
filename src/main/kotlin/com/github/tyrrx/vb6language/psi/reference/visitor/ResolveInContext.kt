package com.github.tyrrx.vb6language.psi.reference

import com.github.tyrrx.vb6language.psi.reference.visitor.ReferenceResolveVisitor
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement

fun VB6PsiElement.resolveInContext(resolveVisitor: ReferenceResolveVisitor): VB6IdentifierOwner? {
    return this.context?.resolve(resolveVisitor)
}

fun ReferenceResolveVisitor.compareReferenceAndScopeNameOrResolveInContext(scope: VB6IdentifierOwner): VB6IdentifierOwner? {
    return when (scope.name) {
        referenceOwner.getIdentifier().name -> scope
        else -> scope.resolveInContext(this)
    }
}