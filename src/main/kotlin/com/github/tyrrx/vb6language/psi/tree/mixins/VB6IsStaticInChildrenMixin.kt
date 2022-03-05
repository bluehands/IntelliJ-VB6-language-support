package com.github.tyrrx.vb6language.psi.tree.mixins

import com.github.tyrrx.vb6language.psi.language.VB6IElementTypes
import com.github.tyrrx.vb6language.psi.tree.utils.isIElementTypePresentInChildren
import com.intellij.psi.PsiElement

interface VB6IsStaticInChildrenMixin: PsiElement {
    fun isStatic(): Boolean {
        return VB6IElementTypes.STATIC.isIElementTypePresentInChildren(this)
    }
}