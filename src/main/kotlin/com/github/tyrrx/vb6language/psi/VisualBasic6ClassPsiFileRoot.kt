package com.github.tyrrx.vb6language.psi

import com.github.tyrrx.vb6language.VisualBasic6ClassFileType
import com.github.tyrrx.vb6language.VisualBasic6Language
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import org.jetbrains.annotations.NotNull

class VisualBasic6ClassPsiFileRoot(viewProvider: @NotNull FileViewProvider) : PsiFileBase(viewProvider, VisualBasic6Language.INSTANCE) {
    override fun getFileType(): FileType {
        return VisualBasic6ClassFileType.INSTANCE
    }

    override fun toString(): String {
        return "VisualBasic6ClassPsiFileRoot"
    }

}