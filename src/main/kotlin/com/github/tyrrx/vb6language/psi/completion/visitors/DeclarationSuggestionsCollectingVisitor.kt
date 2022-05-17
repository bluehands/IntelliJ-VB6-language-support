package com.github.tyrrx.vb6language.psi.completion.visitors

import com.github.tyrrx.vb6language.psi.base.VB6BlockOwner
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.scope.*
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
import com.github.tyrrx.vb6language.psi.visitor.ScopeNodeVisitor

class DeclarationSuggestionsCollectingVisitor(
        val referenceOwner: VB6ReferenceOwner,
) : ScopeNodeVisitor<List<VB6NamedElementOwner>> {

    private fun visitBlock(scope: VB6BlockOwner): List<VB6NamedElementOwner> {
        return scope.blockVisibleElementsBefore(referenceOwner)
    }

    override fun visitFile(scope: VB6File): List<VB6NamedElementOwner> {
        return scope.globalVisibleDeclarationsOfStandardModulesWithStandardModules()
    }

    override fun visitModule(scope: VB6Module): List<VB6NamedElementOwner> {
        val moduleVisibleDeclarations = scope.moduleVisibleDeclarations()
        val contextAcceptOrElse = scope.contextAcceptOrElse(this, emptyList())
        return moduleVisibleDeclarations + contextAcceptOrElse
    }

    override fun visitWithStmt(scope: VB6WithStmt): List<VB6NamedElementOwner> {
        return scope.contextAccept(this) ?: emptyList()
    }

    override fun visitIfBlockStmt(scope: VB6IfBlockStmt): List<VB6NamedElementOwner> {
        return scope.contextAccept(this) ?: emptyList()
    }

    override fun visitIfElseBlockStmt(scope: VB6IfElseBlockStmt): List<VB6NamedElementOwner> {
        return scope.contextAccept(this) ?: emptyList()
    }

    override fun visitIfElseIfStmt(scope: VB6IfElseIfBlockStmt): List<VB6NamedElementOwner> {
        return scope.contextAccept(this) ?: emptyList()
    }

    override fun visitDoLoopStmt(scope: VB6DoLoopStmt): List<VB6NamedElementOwner> {
        return scope.contextAccept(this) ?: emptyList()
    }

    override fun visitForEachStmt(scope: VB6ForEachStmt): List<VB6NamedElementOwner> {
        return scope.contextAccept(this) ?: emptyList()
    }

    override fun visitForNextStmt(scope: VB6ForNextStmt): List<VB6NamedElementOwner> {
        return scope.contextAccept(this) ?: emptyList()
    }

    override fun visitWhileWendStmt(scope: VB6WhileWendStmt): List<VB6NamedElementOwner> {
        return scope.contextAccept(this) ?: emptyList()
    }

    override fun visitFunctionStmt(scope: VB6FunctionStatement): List<VB6NamedElementOwner> {
        val blockDeclarations = visitBlock(scope)
        val contextDeclarations = scope.contextAccept(this) ?: emptyList()
        return blockDeclarations + contextDeclarations
    }

    override fun visitSubroutineStmt(scope: VB6SubroutineStatement): List<VB6NamedElementOwner> {
        val blockDeclarations = visitBlock(scope)
        val contextDeclarations = scope.contextAccept(this) ?: emptyList()
        return blockDeclarations + contextDeclarations
    }

    override fun visitPropertyGetStmt(scope: VB6PropertyGetStatement): List<VB6NamedElementOwner> {
        val blockDeclarations = visitBlock(scope)
        val contextDeclarations = scope.contextAccept(this) ?: emptyList()
        return blockDeclarations + contextDeclarations
    }

    override fun visitPropertySetStmt(scope: VB6PropertySetStatement): List<VB6NamedElementOwner> {
        val blockDeclarations = visitBlock(scope)
        val contextDeclarations = scope.contextAccept(this) ?: emptyList()
        return blockDeclarations + contextDeclarations
    }

    override fun visitPropertyLetStmt(scope: VB6PropertyLetStatement): List<VB6NamedElementOwner> {
        val blockDeclarations = visitBlock(scope)
        val contextDeclarations = scope.contextAccept(this) ?: emptyList()
        return blockDeclarations + contextDeclarations
    }
}