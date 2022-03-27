package com.github.tyrrx.vb6language.project

import com.github.tyrrx.vb6language.psi.tree.definition.VB6File
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.vfs.VirtualFile
import java.nio.file.Path

class VB6WorkspaceService(val project: Project) {

    private val logger = Logger.getInstance(VB6WorkspaceService::class.java)
    private val projects: MutableMap<VirtualFile, VB6Project> = HashMap()

    init {
        println("VB6WorkspaceService")
        ProjectRootManager.getInstance(project).fileIndex.iterateContent {
            if (it.extension?.toLowerCase() == "vbp") {
                attachVB6Project(it)
            }
            return@iterateContent true
        }
    }


    fun findVB6ProjectForVB6FilePath(file: Path): VB6Project? {
        return projects.values.find { it.contains(file) }
    }

    fun isAttachedVB6Project(file: VirtualFile): Boolean {
        return projects.containsKey(file)
    }

    fun attachVB6Project(file: VirtualFile) {
        if (!isAttachedVB6Project(file)) {
            val vB6Project = VB6ProjectImpl(file)
            projects[file] = vB6Project
            logger.info("Attached project ${vB6Project.projectName}")
        } else {
            logger.error("Failed to add project ${file.name} to the workspace because it is already loaded")
        }
    }
}