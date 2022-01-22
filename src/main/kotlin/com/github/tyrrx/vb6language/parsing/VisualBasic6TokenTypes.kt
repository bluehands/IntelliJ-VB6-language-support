package com.github.tyrrx.vb6language.parsing

import com.github.tyrrx.vb6language.VisualBasic6Language
import com.intellij.psi.tree.IElementType

class VisualBasic6TokenTypes {
    companion object {
        @JvmStatic
        val BAD_TOKEN_TYPE = IElementType("BAD_TOKEN", VisualBasic6Language.INSTANCE)
    }
}