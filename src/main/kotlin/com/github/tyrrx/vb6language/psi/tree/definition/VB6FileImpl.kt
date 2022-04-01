package com.github.tyrrx.vb6language.psi.tree.definition

import com.github.tyrrx.vb6language.psi.language.VB6Language
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

interface VB6File : VB6ScopeNode, PsiFile {
    val module: VB6Module?
    val projects: Iterable<VB6Project>
    val isProjectMember: Boolean
    val path: Path
}

class VB6FileImpl(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, VB6Language.INSTANCE), VB6File {
    override fun getFileType(): FileType {
        return viewProvider.virtualFile.fileType
    }

    override val module: VB6Module?
        get() = firstChild?.firstChild?.let { it as VB6Module }

    override val projects: Iterable<VB6Project>
        get() {
            val workspaceService = project.service<VB6WorkspaceService>()
            return workspaceService.findVB6Projects(this)
        }
    override val isProjectMember: Boolean
        get() = projects.any()

    override val path: Path
        get() = viewProvider.virtualFile.toNioPath()

    override fun <TReturn> resolve(resolveVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        return resolveVisitor.resolveFile(this)
    }

    override fun getContext(): VB6ScopeNode? {
        return null
    }

    override fun toString(): String {
        return fileType.name
    }
}