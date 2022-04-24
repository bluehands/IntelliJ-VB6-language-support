package com.github.tyrrx.vb6language.psi.scope

import com.github.tyrrx.vb6language.project.VB6Project
import com.github.tyrrx.vb6language.psi.base.VB6BlockOwner
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6File
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6Module
import com.github.tyrrx.vb6language.psi.tree.definition.module.namedElementOwners
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset

fun VB6BlockOwner.blockVisibleElementsBefore(referenceOwner: VB6ReferenceOwner) =
        this.block?.outsideVisibleNamedElementOwners
                ?.takeWhile {
                    it.endOffset < referenceOwner.startOffset
                }
                ?.filter { it.isDefinition }
                ?: emptyList()

fun VB6File.globalVisibleDeclarationsOfStandardModulesWithStandardModules(): List<VB6NamedElementOwner> {
    return this.projects
            .flatMap {
                val standardModules = standardModulesOf(it)
                standardModules + visibleNamedElementOwnersOf(standardModules)
            }
}

fun VB6Module.moduleVisibleDeclarations(): List<VB6NamedElementOwner> {
    return this.namedElementOwners
            .flatMap { it.outsideVisibleNamedElementOwners }
}

fun visibleNamedElementOwnersOf(modules: Iterable<VB6Module>): Iterable<VB6NamedElementOwner> {
    return modules.flatMap { it.outsideVisibleNamedElementOwners }
}

fun standardModulesOf(project: VB6Project) =
        project.modules.filter { module -> !module.isClass() }