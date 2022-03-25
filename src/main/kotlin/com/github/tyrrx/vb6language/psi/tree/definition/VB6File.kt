package com.github.tyrrx.vb6language.psi.tree.definition

import com.github.tyrrx.vb6language.VB6ClassFileType
import com.github.tyrrx.vb6language.VB6Language
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ScopeNode
import com.github.tyrrx.vb6language.psi.tree.visitor.ScopeNodeVisitor
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import org.jetbrains.annotations.NotNull

class VB6File(viewProvider: @NotNull FileViewProvider) : PsiFileBase(viewProvider, VB6Language.INSTANCE) {
    override fun getFileType(): FileType {
        return super.getVirtualFile().fileType
    }

    override fun toString(): String {
        return fileType.name
    }

}