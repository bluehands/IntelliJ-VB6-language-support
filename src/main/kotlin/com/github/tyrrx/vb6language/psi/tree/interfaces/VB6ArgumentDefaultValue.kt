package com.github.tyrrx.vb6language.psi.tree.interfaces

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6ArgumentDefaultValue:PsiElement {
// Todo add members
}

class VB6ArgumentDefaultValueImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ArgumentDefaultValue {

    object Factory : IPsiNodeFactory<VB6ArgumentDefaultValue> {
        override fun createPsiNode(node: ASTNode): VB6ArgumentDefaultValue {
            return VB6ArgumentDefaultValueImpl(node)
        }
    }
}
