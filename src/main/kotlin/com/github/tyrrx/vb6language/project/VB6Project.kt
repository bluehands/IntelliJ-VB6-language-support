package com.github.tyrrx.vb6language.project

import com.github.tyrrx.vb6language.psi.tree.definition.VB6File
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6EnumerationStmt
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6Module
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6TypeStmt
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

interface VB6Project {
    // todo val externalComReferences:
    val myVirtualFile: VirtualFile
    val myIntellijProject: Project
    val projectName: String

    val modules: Iterable<VB6Module>
    fun containsModule(module: VB6Module): Boolean
    fun containsVB6File(file: VB6File): Boolean
}

class VB6ProjectImpl(
        override val myVirtualFile: VirtualFile,
        override val myIntellijProject: Project
) : VB6Project {
    private val vbpFileContext: List<VBPFileContext> = parseVbpFile(myVirtualFile)

    private val standardModulePaths
        get() = vbpFileContext.standardModules
                ?.mapNotNull { myVirtualFile.toNioPath().resolveSibling(it.path) } ?: emptyList()

    private val classModulePaths
        get() = vbpFileContext.classes?.mapNotNull { myVirtualFile.toNioPath().resolveSibling(it.path) } ?: emptyList()

    private val modulePathsUnion = standardModulePaths + classModulePaths

    override val projectName: String
        get() = vbpFileContext.defaultContext?.values?.filterIsInstance<VBPValue.Name>()?.first()?.name!!

    override val modules: Iterable<VB6Module>
        get() = modulePathsUnion.resolveAllModulesInProject(myIntellijProject)

    override fun containsModule(module: VB6Module): Boolean {
        return modules.any { it == module }
    }

    override fun containsVB6File(file: VB6File): Boolean {
        return modulePathsUnion.containsFile(file.path)
    }
}
