package com.github.tyrrx.vb6language

import com.intellij.openapi.fileTypes.LanguageFileType
import org.jetbrains.annotations.NonNls
import com.intellij.openapi.util.NlsContexts
import com.intellij.openapi.util.NlsSafe
import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

class VB6ClassFileType : LanguageFileType(VB6Language.INSTANCE) {

    override fun getName(): String {
        return "Visual Basic 6.0"
    }

    override fun getDescription(): String {
        return "Visual Basic 6.0 class file"
    }

    override fun getDefaultExtension(): String {
        return "cls"
    }

    override fun getIcon(): Icon? {
        return IconLoader.findIcon("/assets/vb6icon16x16.png")
    }



    companion object {
        @JvmStatic
        val INSTANCE = VB6ClassFileType()
    }
}
