package com.github.tyrrx.vb6language.psi.language

import com.github.tyrrx.vb6language.VB6ClassFileType
import com.github.tyrrx.vb6language.VB6Language
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import org.jetbrains.annotations.NotNull

class VB6ClassFile(viewProvider: @NotNull FileViewProvider) : PsiFileBase(viewProvider, VB6Language.INSTANCE) {
    override fun getFileType(): FileType {
        return VB6ClassFileType.INSTANCE
    }

    override fun toString(): String {
        return "VisualBasic6ClassPsiFileRoot"
    }

}