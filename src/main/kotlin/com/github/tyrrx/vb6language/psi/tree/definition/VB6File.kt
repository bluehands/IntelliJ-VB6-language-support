package com.github.tyrrx.vb6language.psi.tree.definition

import com.github.tyrrx.vb6language.VB6Language
import com.github.tyrrx.vb6language.project.VB6Project
import com.github.tyrrx.vb6language.project.VB6WorkspaceService
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ScopeNode
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6Module
import com.github.tyrrx.vb6language.psi.tree.visitor.ScopeNodeVisitor
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.components.service
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiFile
import java.nio.file.Path

interface IVB6File : VB6ScopeNode, PsiFile {
    val module: VB6Module
    val vb6Project: VB6Project?
    val path: Path
}

class VB6File(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, VB6Language.INSTANCE), IVB6File {
    override fun getFileType(): FileType {
        return viewProvider.virtualFile.fileType
    }

    override val module: VB6Module
        get() = firstChild.firstChild as VB6Module

    override val vb6Project: VB6Project?
        get() {
            val workspaceService = project.service<VB6WorkspaceService>()
            val vb6Project = workspaceService.findVB6ProjectForVB6FilePath(path)
            return vb6Project
        }

    override val path: Path
        get() = viewProvider.virtualFile.toNioPath()

    override fun <TReturn> resolve(resolveVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        TODO("Not yet implemented")
    }

    override fun getContext(): VB6ScopeNode? {
        return null
    }

    override fun toString(): String {
        return fileType.name
    }
}