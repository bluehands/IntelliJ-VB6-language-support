package com.github.tyrrx.vb6language.project

abstract class VBPFileContext {
    class Tag(val tagName: String) : VBPFileContext()
    class Default : VBPFileContext()

    val values = ArrayList<VBPValue>()

    fun addToContext(parseValue: VBPValue) {
        values.add(parseValue)
    }
}