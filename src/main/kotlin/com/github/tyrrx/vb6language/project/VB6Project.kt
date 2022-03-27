package com.github.tyrrx.vb6language.project

import com.intellij.openapi.vfs.VirtualFile
import java.nio.file.Files
import java.nio.file.Path

interface VB6Project {
    // todo val externalComReferences:
    val virtualProjectFile: VirtualFile
    val projectName: String
    fun contains(pathOfVB6File: Path): Boolean
}

class VB6ProjectImpl(override val virtualProjectFile: VirtualFile) : VB6Project {
    private val vbpContext: List<VBPContext> = parseVbpFile(virtualProjectFile)
    private val vbpDefaultContext = vbpContext.first { it is VBPContext.Default }

    private val vbpModules = vbpDefaultContext.values.filterIsInstance<VBPValue.Module>()
    private val vbpClasses = vbpDefaultContext.values.filterIsInstance<VBPValue.Class>()
    private val vbpForms = vbpDefaultContext.values.filterIsInstance<VBPValue.Form>()

    private val vbpName = vbpDefaultContext.values.filterIsInstance<VBPValue.Name>().first()


    override val projectName: String get() = vbpName.name


    override fun contains(pathOfVB6File: Path): Boolean {
        val modules = vbpModules
            .map { virtualProjectFile.toNioPath().resolveSibling(it.path) } + vbpClasses
            .map { virtualProjectFile.toNioPath().resolveSibling(it.path) }
        return modules.any { Files.isSameFile(pathOfVB6File, it) }
    }


}