package com.github.tyrrx.vb6language.psi.tree.impl


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6ArgumentDefaultValue
import com.intellij.lang.ASTNode

class VB6ArgumentDefaultValueImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ArgumentDefaultValue {

    object Factory : IPsiNodeFactory<VB6ArgumentDefaultValue> {
        override fun createPsiNode(node: ASTNode): VB6ArgumentDefaultValue {
            return VB6ArgumentDefaultValueImpl(node)
        }
    }
}