package com.github.tyrrx.vb6language.psi.tree.nodes.mixins

import com.github.tyrrx.vb6language.psi.VB6IElementTypes
import com.github.tyrrx.vb6language.psi.tree.nodes.utils.isIElementTypePresentInChildren
import com.intellij.psi.PsiElement

interface VB6IsStaticMixin: PsiElement {
    fun isStatic(): Boolean {
        return VB6IElementTypes.STATIC.isIElementTypePresentInChildren(this)
    }
}