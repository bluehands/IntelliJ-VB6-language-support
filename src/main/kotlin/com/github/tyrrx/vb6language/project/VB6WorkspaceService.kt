package com.github.tyrrx.vb6language.project

import com.github.tyrrx.vb6language.psi.tree.definition.VB6File
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6Module
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

class VB6WorkspaceService(val project: Project) {

    private val logger = Logger.getInstance(VB6WorkspaceService::class.java)
    private val projects: MutableMap<VirtualFile, VB6Project> = HashMap()
    private val activeProjects: Set<VB6Project> = HashSet()

    init {
        println("VB6WorkspaceService")

//        ProjectRootManager.getInstance(project).fileIndex.iterateContent {
//            if (it.extension?.toLowerCase() == "vbp") {
//                attachVB6Project(it)
//            }
//            return@iterateContent true
//        }
    }


    /**
     * Seems like a source module (bas, cls) can be part of multiple projects.
     */
    fun findVB6Projects(file: VB6File): Iterable<VB6Project> {
        return projects.values.filter { it.containsVB6File(file) }
    }

    fun findVB6Projects(module: VB6Module): Iterable<VB6Project> {
        return when(val file = module.containingFile) {
            is VB6File -> findVB6Projects(file)
            else -> throw IllegalStateException("A module must be inside a VB6File")
        }
    }

    fun isAttachedVB6Project(file: VirtualFile): Boolean {
        return projects.containsKey(file)
    }

    fun attachVB6Project(file: VirtualFile) {
        if (!isAttachedVB6Project(file)) {
            val vb6Project = VB6ProjectImpl(file, project)
            projects[file] = vb6Project
            logger.info("Attached project ${vb6Project.projectName}")
            vb6Project.modules.forEach { logger.info("Project: ${vb6Project.projectName}, Module: ${it.name}") }
        } else {
            logger.error("Failed to add project ${file.name} to the workspace because it is already loaded")
        }
    }
}