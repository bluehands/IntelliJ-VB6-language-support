package com.github.tyrrx.vb6language.psi.completion.visitors

import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.module.*
import com.github.tyrrx.vb6language.psi.visitor.TypeDeclarationVisitor

class SuggestionTypeDeclarationVisitor : TypeDeclarationVisitor<List<VB6NamedElementOwner>> {
    override fun visitModule(module: VB6Module): List<VB6NamedElementOwner> {
        return module.outsideVisibleNamedElementOwners
    }

    override fun visitType(type: VB6TypeStmt): List<VB6NamedElementOwner> {
        return type.members
    }

    override fun visitEnum(enum: VB6EnumerationStmt): List<VB6NamedElementOwner> {
        return enum.enumMembers
    }
}