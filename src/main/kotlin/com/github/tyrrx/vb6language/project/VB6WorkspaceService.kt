package com.github.tyrrx.vb6language.project

import com.github.tyrrx.vb6language.psi.tree.definition.VB6File
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6Module
import com.intellij.openapi.components.*
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.io.FileUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.util.io.isWritable
import com.intellij.util.io.systemIndependentPath
import org.jdom.Element
import java.nio.file.Paths

@State(name = "VB6Workspace", storages = [Storage(StoragePathMacros.WORKSPACE_FILE)])
class VB6WorkspaceService(val project: Project) : PersistentStateComponent<Element> {

    private val logger = Logger.getInstance(VB6WorkspaceService::class.java)
    val projects: MutableMap<VirtualFile, VB6Project> = HashMap()


    init {
        logger.debug("VB6WorkspaceService")
        logger.debug("Attached projects: ${projects.values.joinToString(", ")}")
    }


    /**
     * Seems like a source module (bas, cls) can be part of multiple projects.
     */
    fun findVB6Projects(file: VB6File): Iterable<VB6Project> {
        return projects.values.filter { it.containsVB6File(file) }
    }

    fun findVB6Projects(module: VB6Module): Iterable<VB6Project> {
        return when (val file = module.containingFile) {
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

    fun detachVB6Project(project: VB6Project) {
        projects.remove(project.myVirtualFile)
    }

    override fun getState(): Element {
        val state = Element("state")
        val projectsElement = Element("projects")
        state.addContent(projectsElement)
        projects.keys.forEach {
            val attribute = Element("project")
                    .setAttribute("path", it.toNioPath().systemIndependentPath)
            projectsElement.addContent(attribute)
        }
        return state
    }

    override fun loadState(state: Element) {
        val projectsOfState = state.getChild("projects")
        val projectElementsOfState = projectsOfState.getChildren("project")
        projectElementsOfState
                .mapNotNull { it.getAttributeValue("path") }
                .mapNotNull { Paths.get(it) }
                .mapNotNull {
                    service<VirtualFileManager>().findFileByNioPath(it)
                }
                .forEach { attachVB6Project(it) }
    }
}