package com.github.tyrrx.vb6language.psi.reference.visitor

import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.visitor.ScopeNodeVisitor

interface ReferenceResolveVisitor : ScopeNodeVisitor<VB6NamedElementOwner?> {
    val referenceOwner: VB6ReferenceOwner
    val referencingIdentifier: VB6NamedElement
}