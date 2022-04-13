package com.github.tyrrx.vb6language.psi.tree.definition.literal

import com.github.tyrrx.vb6language.language.ILeafFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiLeaf
import com.intellij.psi.impl.source.tree.LeafElement
import com.intellij.psi.tree.IElementType

class VB6StringLiteral(type: IElementType?, text: CharSequence?) : VB6PsiLeaf(type, text) {
    val value: String = this.text.trim('"')

    object Factory : ILeafFactory {
        override fun createLeaf(type: IElementType, text: CharSequence): LeafElement {
            return VB6StringLiteral(type, text)
        }
    }
}