package com.github.tyrrx.vb6language.psi.reference

import com.github.tyrrx.vb6language.psi.reference.visitor.ReferenceResolveVisitor
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiElement

fun VB6PsiElement.resolveInContext(resolveVisitor: ReferenceResolveVisitor): VB6IdentifierOwner? {
    return this.context?.resolve(resolveVisitor)
}