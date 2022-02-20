package com.github.tyrrx.vb6language.highlighter

import com.github.tyrrx.vb6language.psi.VisualBasic6ParserDefinition
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.tree.IElementType

infix fun Collection<Int>.mapsTo(that: TextAttributesKey): Map<IElementType, TextAttributesKey> {
    return this.associate { antlrToken -> VisualBasic6ParserDefinition.tokens[antlrToken] to that }
}

infix fun Int.mapsTo(that: TextAttributesKey): Map<IElementType, TextAttributesKey> {
    return mapOf(VisualBasic6ParserDefinition.tokens[this] to that)
}
