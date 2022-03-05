package com.github.tyrrx.vb6language.psi.tree.impl


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.type.VB6FieldLength
import com.intellij.lang.ASTNode

class VB6FieldLengthImpl(node: ASTNode) : VB6PsiNode(node),
    VB6FieldLength {

    object Factory : IPsiNodeFactory<VB6FieldLength> {
        override fun createPsiNode(node: ASTNode): VB6FieldLength {
            return VB6FieldLengthImpl(node)
        }
    }
}