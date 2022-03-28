package com.github.tyrrx.vb6language.project

import com.github.tyrrx.vb6language.psi.tree.definition.VB6File
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6Module
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.psi.PsiManager
import java.nio.file.Files

interface VB6Project {
    // todo val externalComReferences:
    val myVirtualFile: VirtualFile
    val myIntellijProject: Project
    val projectName: String

    val modules: Iterable<VB6Module>
    fun containsSourceFile(file: VB6File): Boolean

}

class VB6ProjectImpl(
    override val myVirtualFile: VirtualFile,
    override val myIntellijProject: Project
) : VB6Project {
    private val vbpContext: List<VBPContext> = parseVbpFile(myVirtualFile)
    private val vbpDefaultContext = vbpContext.first { it is VBPContext.Default }

    private val vbpModules = vbpDefaultContext.values.filterIsInstance<VBPValue.Module>()
    private val vbpClasses = vbpDefaultContext.values.filterIsInstance<VBPValue.Class>()
    private val vbpForms = vbpDefaultContext.values.filterIsInstance<VBPValue.Form>()

    private val vbpName = vbpDefaultContext.values.filterIsInstance<VBPValue.Name>().first()

    private val moduleFilePaths = vbpModules
        .mapNotNull { myVirtualFile.toNioPath().resolveSibling(it.path) } + vbpClasses
        .mapNotNull { myVirtualFile.toNioPath().resolveSibling(it.path) }

    override val projectName: String get() = vbpName.name

    override val modules: Iterable<VB6Module>
        get() {
            val virtualFileManager = VirtualFileManager.getInstance()
            val psiManager = PsiManager.getInstance(myIntellijProject)
            return moduleFilePaths
                .mapNotNull { virtualFileManager.findFileByNioPath(it) }
                .mapNotNull { psiManager.findFile(it) }
                .filterIsInstance<VB6File>()
                .map { it.module }
        }

    override fun containsSourceFile(file: VB6File): Boolean {
        return moduleFilePaths.any { Files.isSameFile(file.path, it) }
    }


}