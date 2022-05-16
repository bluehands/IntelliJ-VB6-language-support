package com.github.tyrrx.vb6language.psi.reference.visitor

import com.github.tyrrx.vb6language.psi.tree.definition.VB6File
import com.github.tyrrx.vb6language.psi.base.VB6BlockOwner
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.scope.*
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6WithStmt
import com.github.tyrrx.vb6language.psi.tree.definition.conditional.VB6IfBlockStmt
import com.github.tyrrx.vb6language.psi.tree.definition.conditional.VB6IfElseBlockStmt
import com.github.tyrrx.vb6language.psi.tree.definition.conditional.VB6IfElseIfBlockStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6DoLoopStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6ForEachStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6ForNextStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6WhileWendStmt
import com.github.tyrrx.vb6language.psi.tree.definition.module.*

class CallOrValueResolveVisitor(
        override val referenceOwner: VB6ReferenceOwner,
        override val referencingIdentifier: VB6NamedElement,
) : ReferenceResolveVisitor {

    /**
     * A [com.github.tyrrx.vb6language.psi.reference.references.CallOrValueReference] on project level can resolve to:
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

    override fun visitFile(scope: VB6File): VB6NamedElementOwner? {
        return scope
                .globalVisibleDeclarationsOfStandardModulesWithStandardModules()
                .findNameOfReferencingIdentifier()
    }

    override fun visitModule(scope: VB6Module): VB6NamedElementOwner? {
        return scope
                .moduleVisibleDeclarations()
                .findNameOfReferencingIdentifier()
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
        if (isResolveTarget(scope)) return scope
        return scope.contextAccept(this)
    }

    override fun visitForNextStmt(scope: VB6ForNextStmt): VB6NamedElementOwner? {
        if (isResolveTarget(scope)) return scope
        return scope.contextAccept(this)
    }

    override fun visitWhileWendStmt(scope: VB6WhileWendStmt): VB6NamedElementOwner? {
        return scope.contextAccept(this)
    }

    override fun visitFunctionStmt(scope: VB6FunctionStatement): VB6NamedElementOwner? {
        return visitBlock(scope)
                ?: scope.arguments.findNameOfReferencingIdentifier()
                ?: scope.contextAccept(this)
    }

    override fun visitSubroutineStmt(scope: VB6SubroutineStatement): VB6NamedElementOwner? {
        return visitBlock(scope)
                ?: scope.arguments.findNameOfReferencingIdentifier()
                ?: scope.contextAccept(this)
    }

    override fun visitPropertyGetStmt(scope: VB6PropertyGetStatement): VB6NamedElementOwner? {
        return visitBlock(scope)
                ?: scope.arguments.findNameOfReferencingIdentifier()
                ?: scope.contextAccept(this)
    }

    override fun visitPropertySetStmt(scope: VB6PropertySetStatement): VB6NamedElementOwner? {
        return visitBlock(scope)
                ?: scope.arguments.findNameOfReferencingIdentifier()
                ?: scope.contextAccept(this)
    }

    override fun visitPropertyLetStmt(scope: VB6PropertyLetStatement): VB6NamedElementOwner? {
        return visitBlock(scope)
                ?: scope.arguments.findNameOfReferencingIdentifier()
                ?: orSearchInContextOf(scope, this)
    }


    private fun orSearchInContextOf(scope: VB6ScopeNode, using: ReferenceResolveVisitor): VB6NamedElementOwner? {
        return scope.contextAccept(using)
    }

    private fun visitBlock(scope: VB6BlockOwner): VB6NamedElementOwner? {
//        val blockStatement = findFirstParentOfType<VB6BlockStmt>(referenceOwner)!!
        return scope
                .blockVisibleElementsBefore(referenceOwner)
                .findNameOfReferencingIdentifier()
    }

    private fun Iterable<VB6NamedElementOwner>.findNameOfReferencingIdentifier(): VB6NamedElementOwner? {
        return this.find { compareNames(it) }
    }

    private fun compareNames(it: VB6NamedElementOwner) =
            it.name == referencingIdentifier.name

    private fun isResolveTarget(scope: VB6NamedElementOwner): Boolean {
        if (scope.isDefinition && compareNames(scope)) {
            return true
        }
        return false
    }
}