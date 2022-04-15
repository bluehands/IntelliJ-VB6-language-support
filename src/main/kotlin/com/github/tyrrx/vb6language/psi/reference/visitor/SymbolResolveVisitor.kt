package com.github.tyrrx.vb6language.psi.reference.visitor

import com.github.tyrrx.vb6language.project.VB6Project
import com.github.tyrrx.vb6language.psi.tree.definition.VB6File
import com.github.tyrrx.vb6language.psi.base.VB6BlockOwner
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6BlockStmt
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6WithStmt
import com.github.tyrrx.vb6language.psi.tree.definition.conditional.VB6IfBlockStmt
import com.github.tyrrx.vb6language.psi.tree.definition.conditional.VB6IfElseBlockStmt
import com.github.tyrrx.vb6language.psi.tree.definition.conditional.VB6IfElseIfBlockStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6DoLoopStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6ForEachStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6ForNextStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6WhileWendStmt
import com.github.tyrrx.vb6language.psi.tree.definition.module.*
import com.github.tyrrx.vb6language.psi.utils.findFirstParentOfType

class SymbolResolveVisitor(
        override val referenceOwner: VB6ReferenceOwner,
        override val referencingIdentifier: VB6NamedElement,
) : ReferenceResolveVisitor {

    private fun compareNames(it: VB6NamedElementOwner) =
        it.name == referencingIdentifier.name

    private fun resolveBlock(scope: VB6BlockOwner): VB6NamedElementOwner? {
        val textOffsetOfEnclosingBlockStatement = findFirstParentOfType<VB6BlockStmt>(referenceOwner)?.textOffset
        val textOffsetOfReferenceOwner = referenceOwner.textOffset

        return scope.block
            ?.outsideVisibleNamedElementOwners
            ?.takeWhile { // remove elements that are after the reference owner to avoid endless recursion in filter it.isDefinition as this calls resolve too
                it.isBeforeEnclosingStatementOrReferenceOwner(
                    textOffsetOfEnclosingBlockStatement,
                    textOffsetOfReferenceOwner
                )
            }
            ?.filter { it.isDefinition }
            ?.find { compareNames(it) }
    }

    private fun VB6NamedElementOwner.isBeforeEnclosingStatementOrReferenceOwner(
        textOffsetOfEnclosingBlockStatement: Int?,
        textOffsetOfReferenceOwner: Int
    ) = this.textOffset < (textOffsetOfEnclosingBlockStatement ?: textOffsetOfReferenceOwner)

    /**
     * A [com.github.tyrrx.vb6language.psi.reference.SymbolReference] on project level can resolve to:
     *      - Standard module
     *      - Enum type
     *      - Enum member
     *      - Function
     *      - Sub
     *      - Property
     *      - Const (Standard module, todo Class module?)
     *      - Variable (Standard module, todo Class module?)
     *      - Declare Sub / Function
     *  if visible.
     */
    override fun resolveFile(scope: VB6File): VB6NamedElementOwner? {
        return scope.projects
            .flatMap { standardModules(it) + visibleElementsOfProjectModules(it) }
            .find { it.name == referencingIdentifier.name }
    }

    private fun visibleElementsOfProjectModules(project: VB6Project) =
        project.modules.flatMap { module -> module.outsideVisibleNamedElementOwners }

    private fun standardModules(project: VB6Project) =
        project.modules.filter { module -> !module.isClass() }

    override fun resolveModule(scope: VB6Module): VB6NamedElementOwner? {
        return scope
            .namedElementOwners
            .flatMap { it.outsideVisibleNamedElementOwners }
            .find { compareNames(it) }
            ?: scope.resolveInContext(this)
    }

    override fun resolveWithStmt(scope: VB6WithStmt): VB6NamedElementOwner? {
        return scope.resolveInContext(this)
    }

    override fun resolveIfBlockStmt(scope: VB6IfBlockStmt): VB6NamedElementOwner? {
        return scope.resolveInContext(this)
    }

    override fun resolveIfElseBlockStmt(scope: VB6IfElseBlockStmt): VB6NamedElementOwner? {
        return scope.resolveInContext(this)
    }

    override fun resolveIfElseIfStmt(scope: VB6IfElseIfBlockStmt): VB6NamedElementOwner? {
        return scope.resolveInContext(this)
    }

    override fun resolveDoLoopStmt(scope: VB6DoLoopStmt): VB6NamedElementOwner? {
        return scope.resolveInContext(this)
    }

    override fun resolveForEachStmt(scope: VB6ForEachStmt): VB6NamedElementOwner? {
        // todo resolve to self
        return scope.resolveInContext(this)
    }

    override fun resolveForNextStmt(scope: VB6ForNextStmt): VB6NamedElementOwner? {
        // todo resolve to self
        return scope.resolveInContext(this)
    }

    override fun resolveWhileWendStmt(scope: VB6WhileWendStmt): VB6NamedElementOwner? {
        return scope.resolveInContext(this)
    }

    override fun resolveFunctionStmt(scope: VB6FunctionStatement): VB6NamedElementOwner? {
        return resolveBlock(scope)
            ?: scope.arguments.find { compareNames(it) }
            ?: scope.resolveInContext(this)
    }

    override fun resolveSubroutineStmt(scope: VB6SubroutineStatement): VB6NamedElementOwner? {
        return resolveBlock(scope)
            ?: scope.arguments.find { compareNames(it) }
            ?: scope.resolveInContext(this)
    }

    override fun resolvePropertyGetStmt(scope: VB6PropertyGetStatement): VB6NamedElementOwner? {
        return resolveBlock(scope)
            ?: scope.arguments.find { compareNames(it) }
            ?: scope.resolveInContext(this)
    }

    override fun resolvePropertySetStmt(scope: VB6PropertySetStatement): VB6NamedElementOwner? {
        return resolveBlock(scope)
            ?: scope.arguments.find { compareNames(it) }
            ?: scope.resolveInContext(this)
    }

    override fun resolvePropertyLetStmt(scope: VB6PropertyLetStatement): VB6NamedElementOwner? {
        return resolveBlock(scope)
            ?: scope.arguments.find { compareNames(it) }
            ?: scope.resolveInContext(this)
    }
}