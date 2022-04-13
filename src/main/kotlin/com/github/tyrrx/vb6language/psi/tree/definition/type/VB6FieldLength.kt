package com.github.tyrrx.vb6language.psi.tree.definition.type

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6FieldLength : VB6PsiElement {
    //Todo add members
}

class VB6FieldLengthImpl(node: ASTNode) : VB6PsiNode(node),
    VB6FieldLength {

    object Factory : IPsiNodeFactory<VB6FieldLength> {
        override fun createPsiNode(node: ASTNode): VB6FieldLength {
            return VB6FieldLengthImpl(node)
        }
    }
}
