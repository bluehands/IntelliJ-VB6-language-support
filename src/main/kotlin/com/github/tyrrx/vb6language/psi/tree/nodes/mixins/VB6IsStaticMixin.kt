package com.github.tyrrx.vb6language.psi.tree.nodes.mixins

import com.github.tyrrx.vb6language.psi.VB6IElementTypes
import com.github.tyrrx.vb6language.psi.tree.nodes.utils.findLeafInChildrenByElementType
import com.intellij.psi.PsiElement

interface VB6IsStaticMixin: PsiElement {
    fun isStatic(): Boolean {
        return findLeafInChildrenByElementType(this, VB6IElementTypes.STATIC) != null
    }
}