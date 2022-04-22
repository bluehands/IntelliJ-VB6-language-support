package com.github.tyrrx.vb6language.psi.scope

import com.github.tyrrx.vb6language.psi.inference.VB6TypeDeclaration
import com.github.tyrrx.vb6language.psi.tree.definition.VB6File
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6Module

class GlobalVisibleScope(private val file: VB6File) {

    val modules: List<VB6Module>
        get() = file.projects.flatMap { it.modules }

    val standardModules: Iterable<VB6Module>
        get() = modules.filter { !it.isClass() }

    val classModules: Iterable<VB6Module>
        get() = modules.filter { it.isClass() }

    private val moduleTypeDeclarations
        get() = standardModules.flatMap { standardModule ->
            standardModule.outsideVisibleNamedElementOwners.filterIsInstance<VB6TypeDeclaration>()
        }

    val typeDeclarations: Iterable<VB6TypeDeclaration>
        get() = standardModules + moduleTypeDeclarations


}