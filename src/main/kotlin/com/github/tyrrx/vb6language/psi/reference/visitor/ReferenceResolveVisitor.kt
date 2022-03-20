package com.github.tyrrx.vb6language.psi.reference.visitor

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.visitor.ScopeNodeVisitor

interface ReferenceResolveVisitor : ScopeNodeVisitor<VB6IdentifierOwner?> {
    val referenceOwner: VB6ReferenceOwner
}