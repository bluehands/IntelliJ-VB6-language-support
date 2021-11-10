package com.github.tyrrx.vb6language

import com.intellij.openapi.fileTypes.LanguageFileType
import org.jetbrains.annotations.NonNls
import com.intellij.openapi.util.NlsContexts
import com.intellij.openapi.util.NlsSafe
import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

class VisualBasic6ClassFileType : LanguageFileType(VisualBasic6Language.INSTANCE) {

    override fun getName(): @NonNls String {
        return "Visual Basic 6.0"
    }

    override fun getDescription(): @NlsContexts.Label String {
        return "Visual Basic 6.0 class file"
    }

    override fun getDefaultExtension(): @NlsSafe String {
        return "cls"
    }

    override fun getIcon(): Icon? {
        return IconLoader.findIcon("/assets/vb6icon16x16.png")
    }

    companion object {
        val INSTANCE = VisualBasic6ClassFileType()
    }
}
