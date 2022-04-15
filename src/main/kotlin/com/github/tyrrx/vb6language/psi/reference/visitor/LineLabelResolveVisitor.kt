package com.github.tyrrx.vb6language.psi.reference.visitor

import com.github.tyrrx.vb6language.psi.tree.definition.VB6File
import com.github.tyrrx.vb6language.psi.base.VB6BlockOwner
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6LineLabel
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6WithStmt
import com.github.tyrrx.vb6language.psi.tree.definition.conditional.VB6IfBlockStmt
import com.github.tyrrx.vb6language.psi.tree.definition.conditional.VB6IfElseBlockStmt
import com.github.tyrrx.vb6language.psi.tree.definition.conditional.VB6IfElseIfBlockStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6DoLoopStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6ForEachStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6ForNextStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6WhileWendStmt
import com.github.tyrrx.vb6language.psi.tree.definition.module.*

class LineLabelResolveVisitor(
        override val referenceOwner: VB6ReferenceOwner,
        override val referencingIdentifier: VB6NamedElement,
) : ReferenceResolveVisitor {

    private fun compareNames(it: VB6NamedElementOwner) =
        it.name == referencingIdentifier.name

    private fun resolveBlock(scope: VB6BlockOwner): VB6NamedElementOwner? {
        return scope
            .block
            ?.outsideVisibleNamedElementOwners
            ?.filterIsInstance<VB6LineLabel>()
            ?.find(::compareNames)
    }

    override fun resolveFile(scope: VB6File): VB6NamedElementOwner? {
        throw IllegalStateException("Cannot resolve a line label in a file scope. Only enclosing block of functions, properties or subs are valid.")
    }

    override fun resolveModule(scope: VB6Module): VB6NamedElementOwner? {
        throw IllegalStateException("Cannot resolve a line label in a module scope. Only enclosing block of functions, properties or subs are valid.")
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
        return scope.resolveInContext(this)
    }

    override fun resolveForNextStmt(scope: VB6ForNextStmt): VB6NamedElementOwner? {
        return scope.resolveInContext(this)
    }

    override fun resolveWhileWendStmt(scope: VB6WhileWendStmt): VB6NamedElementOwner? {
        return scope.resolveInContext(this)
    }

    override fun resolveFunctionStmt(scope: VB6FunctionStatement): VB6NamedElementOwner? {
        return resolveBlock(scope)
    }

    override fun resolveSubroutineStmt(scope: VB6SubroutineStatement): VB6NamedElementOwner? {
        return resolveBlock(scope)
    }

    override fun resolvePropertyGetStmt(scope: VB6PropertyGetStatement): VB6NamedElementOwner? {
        return resolveBlock(scope)
    }

    override fun resolvePropertySetStmt(scope: VB6PropertySetStatement): VB6NamedElementOwner? {
        return resolveBlock(scope)
    }

    override fun resolvePropertyLetStmt(scope: VB6PropertyLetStatement): VB6NamedElementOwner? {
        return resolveBlock(scope)
    }
}