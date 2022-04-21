package com.github.tyrrx.vb6language.completion.visitors

import com.github.tyrrx.vb6language.project.VB6Project
import com.github.tyrrx.vb6language.psi.tree.definition.VB6File
import com.github.tyrrx.vb6language.psi.base.VB6BlockOwner
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.reference.visitor.acceptToContext
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
import com.github.tyrrx.vb6language.psi.visitor.ScopeNodeVisitor

class DeclarationSuggestionsCollectingVisitor(
        val referenceOwner: VB6ReferenceOwner,
) : ScopeNodeVisitor<List<VB6NamedElementOwner>> {

    private fun visitBlock(scope: VB6BlockOwner): List<VB6NamedElementOwner> {
        val textOffsetOfEnclosingBlockStatement = findFirstParentOfType<VB6BlockStmt>(referenceOwner)?.textOffset
        val textOffsetOfReferenceOwner = referenceOwner.textOffset

        val declarations = scope.block
                ?.outsideVisibleNamedElementOwners
                ?.takeWhile { // remove elements that are after the reference owner to avoid endless recursion in filter it.isDefinition as this calls resolve too
                    it.isBeforeEnclosingStatementOrReferenceOwner(
                            textOffsetOfEnclosingBlockStatement,
                            textOffsetOfReferenceOwner
                    )
                }
                ?.filter { it.isDefinition }
                ?: emptyList()
        return declarations
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
    override fun visitFile(scope: VB6File): List<VB6NamedElementOwner> {
        return scope.projects
                .flatMap { standardModules(it) + visibleElementsOfProjectModules(it) }
    }

    private fun visibleElementsOfProjectModules(project: VB6Project) =
            project.modules.flatMap { module -> module.outsideVisibleNamedElementOwners }

    private fun standardModules(project: VB6Project) =
            project.modules.filter { module -> !module.isClass() } // todo filter?

    override fun visitModule(scope: VB6Module): List<VB6NamedElementOwner> {
        val moduleDeclarations = scope
                .namedElementOwners
                .flatMap { it.outsideVisibleNamedElementOwners }
        val contextDeclarations = scope.acceptToContext(this) ?: emptyList()
        return moduleDeclarations + contextDeclarations
    }

    override fun visitWithStmt(scope: VB6WithStmt): List<VB6NamedElementOwner> {
        return scope.acceptToContext(this) ?: emptyList()
    }

    override fun visitIfBlockStmt(scope: VB6IfBlockStmt): List<VB6NamedElementOwner> {
        return scope.acceptToContext(this) ?: emptyList()
    }

    override fun visitIfElseBlockStmt(scope: VB6IfElseBlockStmt): List<VB6NamedElementOwner> {
        return scope.acceptToContext(this) ?: emptyList()
    }

    override fun visitIfElseIfStmt(scope: VB6IfElseIfBlockStmt): List<VB6NamedElementOwner> {
        return scope.acceptToContext(this) ?: emptyList()
    }

    override fun visitDoLoopStmt(scope: VB6DoLoopStmt): List<VB6NamedElementOwner> {
        return scope.acceptToContext(this) ?: emptyList()
    }

    override fun visitForEachStmt(scope: VB6ForEachStmt): List<VB6NamedElementOwner> {
        // todo resolve to self
        return scope.acceptToContext(this) ?: emptyList()
    }

    override fun visitForNextStmt(scope: VB6ForNextStmt): List<VB6NamedElementOwner> {
        // todo resolve to self
        return scope.acceptToContext(this) ?: emptyList()
    }

    override fun visitWhileWendStmt(scope: VB6WhileWendStmt): List<VB6NamedElementOwner> {
        return scope.acceptToContext(this) ?: emptyList()
    }

    override fun visitFunctionStmt(scope: VB6FunctionStatement): List<VB6NamedElementOwner> {
        val blockDeclarations = visitBlock(scope)
        val contextDeclarations = scope.acceptToContext(this) ?: emptyList()
        return blockDeclarations + contextDeclarations
    }

    override fun visitSubroutineStmt(scope: VB6SubroutineStatement): List<VB6NamedElementOwner> {
        val blockDeclarations = visitBlock(scope)
        val contextDeclarations = scope.acceptToContext(this) ?: emptyList()
        return blockDeclarations + contextDeclarations
    }

    override fun visitPropertyGetStmt(scope: VB6PropertyGetStatement): List<VB6NamedElementOwner> {
        val blockDeclarations = visitBlock(scope)
        val contextDeclarations = scope.acceptToContext(this) ?: emptyList()
        return blockDeclarations + contextDeclarations
    }

    override fun visitPropertySetStmt(scope: VB6PropertySetStatement): List<VB6NamedElementOwner> {
        val blockDeclarations = visitBlock(scope)
        val contextDeclarations = scope.acceptToContext(this) ?: emptyList()
        return blockDeclarations + contextDeclarations
    }

    override fun visitPropertyLetStmt(scope: VB6PropertyLetStatement): List<VB6NamedElementOwner> {
        val blockDeclarations = visitBlock(scope)
        val contextDeclarations = scope.acceptToContext(this) ?: emptyList()
        return blockDeclarations + contextDeclarations
    }
}