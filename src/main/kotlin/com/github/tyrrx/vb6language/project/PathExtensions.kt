package com.github.tyrrx.vb6language.project
import com.github.tyrrx.vb6language.psi.tree.definition.VB6File
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6Module
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.psi.PsiManager
import java.nio.file.Files
import java.nio.file.Path

fun Path.isSameFile(other: Path): Boolean {
    return Files.isSameFile(this, other)
}

fun Iterable<Path>.containsFile(path: Path): Boolean {
    return this.any { it.isSameFile(path) }
}

fun Iterable<Path>.resolveAllModulesInProject(project: Project): List<VB6Module> {
    val virtualFileManager = service<VirtualFileManager>()
    val psiManager = project.service<PsiManager>()
    return this
        .mapNotNull { virtualFileManager.findFileByNioPath(it) }
        .mapNotNull { psiManager.findFile(it) }
        .filterIsInstance<VB6File>()
        .mapNotNull { it.module }

}