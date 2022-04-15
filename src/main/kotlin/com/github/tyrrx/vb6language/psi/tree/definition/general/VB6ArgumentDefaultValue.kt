package com.github.tyrrx.vb6language.psi.tree.definition.general

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6ArgumentDefaultValue: VB6PsiElement {
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
