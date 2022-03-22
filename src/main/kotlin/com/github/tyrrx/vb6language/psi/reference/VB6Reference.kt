package com.github.tyrrx.vb6language.psi.reference

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiReference

interface VB6Reference : PsiReference {
    val myElement: VB6ReferenceOwner
    val referencingIdentifier: VB6Identifier
    val textRange: TextRange
}