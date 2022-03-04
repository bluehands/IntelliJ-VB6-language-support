package com.github.tyrrx.vb6language.psi.tree.nodes.mixins

import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6TypeHint
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base.VB6GetTypeHint
import com.github.tyrrx.vb6language.psi.tree.nodes.utils.findFirstChildByType
import com.intellij.psi.PsiElement

interface VB6GetTypeHintFromChildrenMixin: VB6GetTypeHint {
    override fun getTypeHint(): VB6TypeHint? {
        return findFirstChildByType(this)
    }
}