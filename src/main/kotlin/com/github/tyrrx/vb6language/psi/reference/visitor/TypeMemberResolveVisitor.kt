package com.github.tyrrx.vb6language.psi.reference.visitor

import com.github.tyrrx.vb6language.psi.tree.definition.VB6File
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6WithStmt
import com.github.tyrrx.vb6language.psi.tree.definition.conditional.VB6IfBlockStmt
import com.github.tyrrx.vb6language.psi.tree.definition.conditional.VB6IfElseBlockStmt
import com.github.tyrrx.vb6language.psi.tree.definition.conditional.VB6IfElseIfBlockStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6DoLoopStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6ForEachStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6ForNextStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6WhileWendStmt
import com.github.tyrrx.vb6language.psi.tree.definition.module.*

class TypeMemberResolveVisitor(
    override val referenceOwner: VB6ReferenceOwner,
    override val referencingIdentifier: VB6NamedElement,
) : ReferenceResolveVisitor {

    private fun compareNames(it: VB6NamedElementOwner) =
        it.name == referencingIdentifier.name

    override fun resolveFile(scope: VB6File): VB6NamedElementOwner? {
        throw IllegalStateException("Cannot resolve a member type inside a file")
    }

    override fun resolveModule(scope: VB6Module): VB6NamedElementOwner? {
        return scope
            .outsideVisibleNamedElementOwners
            .find { compareNames(it) }
    }

    override fun resolveWithStmt(scope: VB6WithStmt): VB6NamedElementOwner? {
        throw IllegalStateException("Cannot resolve a member type inside a with statement")
    }

    override fun resolveIfBlockStmt(scope: VB6IfBlockStmt): VB6NamedElementOwner? {
        throw IllegalStateException("Cannot resolve a member type inside an if statement")
    }

    override fun resolveIfElseBlockStmt(scope: VB6IfElseBlockStmt): VB6NamedElementOwner? {
        throw IllegalStateException("Cannot resolve a member type inside an if else statement")
    }

    override fun resolveIfElseIfStmt(scope: VB6IfElseIfBlockStmt): VB6NamedElementOwner? {
        throw IllegalStateException("Cannot resolve a member type inside an if else if")
    }

    override fun resolveDoLoopStmt(scope: VB6DoLoopStmt): VB6NamedElementOwner? {
        throw IllegalStateException("Cannot resolve a member type inside a do loop statement")
    }

    override fun resolveForEachStmt(scope: VB6ForEachStmt): VB6NamedElementOwner? {
        throw IllegalStateException("Cannot resolve a member type inside a for each statement")
    }

    override fun resolveForNextStmt(scope: VB6ForNextStmt): VB6NamedElementOwner? {
        throw IllegalStateException("Cannot resolve a member type inside a for next statement")
    }

    override fun resolveWhileWendStmt(scope: VB6WhileWendStmt): VB6NamedElementOwner? {
        throw IllegalStateException("Cannot resolve a member type inside a while wend statement")
    }

    override fun resolveFunctionStmt(scope: VB6FunctionStatement): VB6NamedElementOwner? {
        throw IllegalStateException("Cannot resolve a member type inside a function statement")
    }

    override fun resolveSubroutineStmt(scope: VB6SubroutineStatement): VB6NamedElementOwner? {
        throw IllegalStateException("Cannot resolve a member type inside a subroutine statement")
    }

    override fun resolvePropertyGetStmt(scope: VB6PropertyGetStatement): VB6NamedElementOwner? {
        throw IllegalStateException("Cannot resolve a member type inside a property get statement")
    }

    override fun resolvePropertySetStmt(scope: VB6PropertySetStatement): VB6NamedElementOwner? {
        throw IllegalStateException("Cannot resolve a member type inside a property set statement")
    }

    override fun resolvePropertyLetStmt(scope: VB6PropertyLetStatement): VB6NamedElementOwner? {
        throw IllegalStateException("Cannot resolve a member type inside a property let statement")
    }

    override fun resolveTypeStmt(scope: VB6TypeStmtImpl): VB6NamedElementOwner? {
        return scope
            .members
            .flatMap { it.outsideVisibleNamedElementOwners }
            .find { compareNames(it) }
    }

    override fun resolveEnumerationStmt(scope: VB6EnumerationStmtImpl): VB6NamedElementOwner? {
        return scope
            .enumMembers
            .flatMap { it.outsideVisibleNamedElementOwners }
            .find { compareNames(it) }
    }
}