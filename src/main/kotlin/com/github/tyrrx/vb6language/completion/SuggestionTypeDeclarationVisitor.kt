package com.github.tyrrx.vb6language.completion

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6EnumerationStmtImpl
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6Module
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6TypeStmtImpl
import com.github.tyrrx.vb6language.psi.tree.visitor.TypeDeclarationVisitor

class SuggestionTypeDeclarationVisitor : TypeDeclarationVisitor<List<VB6NamedElementOwner>> {
    override fun processModuleDeclarations(module: VB6Module): List<VB6NamedElementOwner> {
        return module.outsideVisibleNamedElementOwners
    }

    override fun processTypeStmtDeclarations(type: VB6TypeStmtImpl): List<VB6NamedElementOwner> {
        return type.members
    }

    override fun processEnumerationStmtDeclarations(enum: VB6EnumerationStmtImpl): List<VB6NamedElementOwner> {
        return enum.enumMembers
    }
}