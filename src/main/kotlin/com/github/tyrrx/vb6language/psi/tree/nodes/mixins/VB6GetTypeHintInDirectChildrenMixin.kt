package com.github.tyrrx.vb6language.psi.tree.nodes.mixins

import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6TypeHint
import com.github.tyrrx.vb6language.psi.tree.nodes.utils.findFirstPsiElementInDirectChildrenByType
import com.intellij.psi.PsiElement

interface VB6GetTypeHintInDirectChildrenMixin: PsiElement {
    fun getTypeHint(): VB6TypeHint? {
        return findFirstPsiElementInDirectChildrenByType(this)
    }
}