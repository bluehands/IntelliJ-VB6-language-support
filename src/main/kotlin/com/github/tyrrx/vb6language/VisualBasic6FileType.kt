package com.github.tyrrx.vb6language

import com.intellij.openapi.fileTypes.LanguageFileType
import org.jetbrains.annotations.NonNls
import com.intellij.openapi.util.NlsContexts
import com.intellij.openapi.util.NlsSafe
import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

class VisualBasic6FileType : LanguageFileType(VisualBasic6Language()) {
    override fun getName(): @NonNls String {
        return "Visual Basic 6.0"
    }

    override fun getDescription(): @NlsContexts.Label String {
        return "desc"
    }

    override fun getDefaultExtension(): @NlsSafe String {
        return "cls"
    }

    override fun getIcon(): Icon? {
        return IconLoader.findIcon("/assets/vb6icon.png")
    }

    companion object {
        val INSTANCE = VisualBasic6FileType()
    }
}