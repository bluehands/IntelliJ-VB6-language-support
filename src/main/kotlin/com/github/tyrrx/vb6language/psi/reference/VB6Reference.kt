package com.github.tyrrx.vb6language.psi.reference

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiReference

interface VB6Reference : PsiReference {
    val myElement: VB6ReferenceOwner
    val referencingNamedElement: VB6NamedElement
    val textRange: TextRange
}