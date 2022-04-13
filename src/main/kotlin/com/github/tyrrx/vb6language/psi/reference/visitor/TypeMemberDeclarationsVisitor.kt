package com.github.tyrrx.vb6language.psi.reference.visitor

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.module.*
import com.github.tyrrx.vb6language.psi.tree.visitor.TypeDeclarationVisitor

class TypeMemberDeclarationsVisitor(
    private val referencingIdentifier: VB6NamedElement,
) : TypeDeclarationVisitor<VB6NamedElementOwner?> {

    private fun compareNames(it: VB6NamedElementOwner) =
        it.name == referencingIdentifier.name

    override fun processModuleDeclarations(module: VB6Module): VB6NamedElementOwner? {
        return module
            .outsideVisibleNamedElementOwners
            .find { compareNames(it) }
    }

    override fun processTypeStmtDeclarations(type: VB6TypeStmtImpl): VB6NamedElementOwner? {
        return type
            .members
            .flatMap { it.outsideVisibleNamedElementOwners }
            .find { compareNames(it) }
    }

    override fun processEnumerationStmtDeclarations(enum: VB6EnumerationStmtImpl): VB6NamedElementOwner? {
        return enum
            .enumMembers
            .flatMap { it.outsideVisibleNamedElementOwners }
            .find { compareNames(it) }
    }
}