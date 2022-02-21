package com.github.tyrrx.vb6language.psi

import com.intellij.psi.impl.source.tree.LeafElement
import com.intellij.psi.tree.IElementType

interface ILeafFactory {
    fun createLeaf(type: IElementType, text: CharSequence): LeafElement
}