package com.github.tyrrx.vb6language.psi.reference.visitor

import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6EnumerationStmt
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6Module
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6TypeStmt
import com.github.tyrrx.vb6language.psi.visitor.TypeDeclarationVisitor

class TypeMemberDeclarationsVisitor(
        private val referencingIdentifier: VB6NamedElement,
) : TypeDeclarationVisitor<VB6NamedElementOwner?> {

    private fun compareNames(it: VB6NamedElementOwner) =
        it.name == referencingIdentifier.name

    override fun visitModule(module: VB6Module): VB6NamedElementOwner? {
        return module
            .outsideVisibleNamedElementOwners
            .find { compareNames(it) }
    }

    override fun visitType(type: VB6TypeStmt): VB6NamedElementOwner? {
        return type
            .members
            .flatMap { it.outsideVisibleNamedElementOwners }
            .find { compareNames(it) }
    }

    override fun visitEnum(enum: VB6EnumerationStmt): VB6NamedElementOwner? {
        return enum
            .enumMembers
            .flatMap { it.outsideVisibleNamedElementOwners }
            .find { compareNames(it) }
    }
}