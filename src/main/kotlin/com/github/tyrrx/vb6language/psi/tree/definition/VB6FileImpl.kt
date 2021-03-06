package com.github.tyrrx.vb6language.psi.tree.definition

import com.github.tyrrx.vb6language.language.VB6Language
import com.github.tyrrx.vb6language.project.VB6Project
import com.github.tyrrx.vb6language.project.VB6WorkspaceService
import com.github.tyrrx.vb6language.psi.reference.references.VB6Reference
import com.github.tyrrx.vb6language.psi.scope.VB6ScopeNode
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6Module
import com.github.tyrrx.vb6language.psi.visitor.ScopeNodeVisitor
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
        return originalVirtualFile().fileType
    }

    override val module: VB6Module?
        get() = firstChild?.firstChild?.let { it as? VB6Module }

    override val projects: Iterable<VB6Project>
        get() {
            val workspaceService = project.service<VB6WorkspaceService>()
            return workspaceService.findVB6Projects(this)
        }

    override val isProjectMember: Boolean
        get() = projects.any()

    override val path: Path
        get() {
            return originalVirtualFile().toNioPath()
        }

    private fun originalVirtualFile() = originalFile.virtualFile

    override fun <TReturn> accept(nodeVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        return nodeVisitor.visitFile(this)
    }

    override fun getContext(): VB6ScopeNode? {
        return null
    }

    override fun toString(): String {
        return fileType.name
    }

    override fun getReference(): VB6Reference? {
        return null
    }
}