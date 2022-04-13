package com.github.tyrrx.vb6language.language

import com.intellij.lang.Language

class VB6Language: Language("VisualBasic6") {
    companion object {
        @JvmStatic
        val INSTANCE = VB6Language()
    }
}