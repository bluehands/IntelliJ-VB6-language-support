package com.github.tyrrx.vb6language.psi.reference.visitor

import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.declarations.VB6TypeDeclaration
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.scope.contextAccept
import com.github.tyrrx.vb6language.psi.tree.definition.VB6File
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6WithStmt
import com.github.tyrrx.vb6language.psi.tree.definition.conditional.VB6IfBlockStmt
import com.github.tyrrx.vb6language.psi.tree.definition.conditional.VB6IfElseBlockStmt
import com.github.tyrrx.vb6language.psi.tree.definition.conditional.VB6IfElseIfBlockStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6DoLoopStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6ForEachStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6ForNextStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6WhileWendStmt
import com.github.tyrrx.vb6language.psi.tree.definition.module.*

class TypeResolveVisitor(
        override val referenceOwner: VB6ReferenceOwner,
        override val referencingIdentifier: VB6NamedElement,
) : ReferenceResolveVisitor {

    private fun compareNames(it: VB6NamedElementOwner) =
            it.name == referencingIdentifier.name

    override fun visitFile(scope: VB6File): VB6NamedElementOwner? {
        val flatMap = scope.projects
                .flatMap { it.modules }
                .flatMap { it.outsideVisibleNamedElementOwners.filterIsInstance<VB6TypeDeclaration>() + it }

        return flatMap.find { it.name == referencingIdentifier.name }
    }

    override fun visitModule(scope: VB6Module): VB6NamedElementOwner? {
        return scope.namedElementOwners
                .filter { it is VB6EnumerationStmt || it is VB6TypeStmt }
                .find { compareNames(it) }
                ?: scope.contextAccept(this)
    }

    override fun visitWithStmt(scope: VB6WithStmt): VB6NamedElementOwner? {
        return scope.contextAccept(this)
    }

    override fun visitIfBlockStmt(scope: VB6IfBlockStmt): VB6NamedElementOwner? {
        return scope.contextAccept(this)
    }

    override fun visitIfElseBlockStmt(scope: VB6IfElseBlockStmt): VB6NamedElementOwner? {
        return scope.contextAccept(this)
    }

    override fun visitIfElseIfStmt(scope: VB6IfElseIfBlockStmt): VB6NamedElementOwner? {
        return scope.contextAccept(this)
    }

    override fun visitDoLoopStmt(scope: VB6DoLoopStmt): VB6NamedElementOwner? {
        return scope.contextAccept(this)
    }

    override fun visitForEachStmt(scope: VB6ForEachStmt): VB6NamedElementOwner? {
        return scope.contextAccept(this)
    }

    override fun visitForNextStmt(scope: VB6ForNextStmt): VB6NamedElementOwner? {
        return scope.contextAccept(this)
    }

    override fun visitWhileWendStmt(scope: VB6WhileWendStmt): VB6NamedElementOwner? {
        return scope.contextAccept(this)
    }

    override fun visitFunctionStmt(scope: VB6FunctionStatement): VB6NamedElementOwner? {
        return scope.contextAccept(this)
    }

    override fun visitSubroutineStmt(scope: VB6SubroutineStatement): VB6NamedElementOwner? {
        return scope.contextAccept(this)
    }

    override fun visitPropertyGetStmt(scope: VB6PropertyGetStatement): VB6NamedElementOwner? {
        return scope.contextAccept(this)
    }

    override fun visitPropertySetStmt(scope: VB6PropertySetStatement): VB6NamedElementOwner? {
        return scope.contextAccept(this)
    }

    override fun visitPropertyLetStmt(scope: VB6PropertyLetStatement): VB6NamedElementOwner? {
        return scope.contextAccept(this)
    }
}