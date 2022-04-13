package com.github.tyrrx.vb6language.language

import com.intellij.psi.impl.source.tree.LeafElement
import com.intellij.psi.tree.IElementType

interface ILeafFactory {
    fun createLeaf(type: IElementType, text: CharSequence): LeafElement
}