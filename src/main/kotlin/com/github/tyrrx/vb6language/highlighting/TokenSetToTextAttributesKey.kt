package com.github.tyrrx.vb6language.highlighting

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet

infix fun TokenSet.mapsTo(that: TextAttributesKey): Map<IElementType, TextAttributesKey> {
    return this.types.associateWith { that }
}
