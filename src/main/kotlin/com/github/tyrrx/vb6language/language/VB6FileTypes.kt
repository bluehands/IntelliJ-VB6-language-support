package com.github.tyrrx.vb6language.language

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

object VB6ClassFileType : LanguageFileType(VB6Language.INSTANCE) {

    override fun getName(): String {
        return "VB6 Class"
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

    override fun getCharset(file: VirtualFile, content: ByteArray?): String {
        return "windows-1252"
    }

    override fun getDisplayName(): String {
        return name
    }
}

object VB6FormFileType : LanguageFileType(VB6Language.INSTANCE) {

    override fun getName(): String {
        return "VB6 Form"
    }

    override fun getDescription(): String {
        return "Visual Basic 6.0 form file"
    }

    override fun getDefaultExtension(): String {
        return "frm"
    }

    override fun getIcon(): Icon? {
        return IconLoader.findIcon("/assets/vb6icon16x16.png")
    }

    override fun getCharset(file: VirtualFile, content: ByteArray?): String {
        return "windows-1252"
    }

    override fun getDisplayName(): String {
        return name
    }
}

object VB6ModuleFileType : LanguageFileType(VB6Language.INSTANCE) {

    override fun getName(): String {
        return "VB6 Module"
    }

    override fun getDescription(): String {
        return "Visual Basic 6.0 module file"
    }

    override fun getDefaultExtension(): String {
        return "bas"
    }

    override fun getIcon(): Icon? {
        return IconLoader.findIcon("/assets/vb6icon16x16.png")
    }

    override fun getCharset(file: VirtualFile, content: ByteArray?): String {
        return "windows-1252"
    }
    override fun getDisplayName(): String {
        return name
    }
}

