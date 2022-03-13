package com.github.tyrrx.vb6language.psi.reference.visitor

import com.github.tyrrx.vb6language.psi.reference.compareReferenceAndScopeNameOrResolveInContext
import com.github.tyrrx.vb6language.psi.reference.resolveInContext
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6WithStmt
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.conditional.VB6IfBlockStmt
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.conditional.VB6IfElseBlockStmt
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.conditional.VB6IfElseIfBlockStmt
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.loops.VB6DoLoopStmt
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.loops.VB6ForEachStmt
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.loops.VB6ForNextStmt
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.loops.VB6WhileWendStmt
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.*

open class ProcedureReferenceResolveVisitor(override val referenceOwner: VB6ReferenceOwner) : ReferenceResolveVisitor {

    override fun resolveModule(scope: VB6Module): VB6IdentifierOwner? {
        return listOf(
            scope.getFunctions(),
            scope.getSubroutines()
        )
            .flatten()
            .find { fn -> fn.name == referenceOwner.getIdentifier().name }
    }

    override fun resolveWithStmt(scope: VB6WithStmt): VB6IdentifierOwner? {
        return scope.resolveInContext(this)
    }

    override fun resolveIfBlockStmt(scope: VB6IfBlockStmt): VB6IdentifierOwner? {
        return scope.resolveInContext(this)
    }

    override fun resolveIfElseBlockStmt(scope: VB6IfElseBlockStmt): VB6IdentifierOwner? {
        return scope.resolveInContext(this)
    }

    override fun resolveIfElseIfStmt(scope: VB6IfElseIfBlockStmt): VB6IdentifierOwner? {
        return scope.resolveInContext(this)
    }

    override fun resolveDoLoopStmt(scope: VB6DoLoopStmt): VB6IdentifierOwner? {
        return scope.resolveInContext(this)
    }

    override fun resolveForEachStmt(scope: VB6ForEachStmt): VB6IdentifierOwner? {
        return scope.resolveInContext(this)
    }

    override fun resolveForNextStmt(scope: VB6ForNextStmt): VB6IdentifierOwner? {
        return scope.resolveInContext(this)
    }

    override fun resolveWhileWendStmt(scope: VB6WhileWendStmt): VB6IdentifierOwner? {
        return scope.resolveInContext(this)
    }

    override fun resolveFunctionStmt(scope: VB6FunctionStatement): VB6IdentifierOwner? {
        return this.compareReferenceAndScopeNameOrResolveInContext(scope)
    }

    override fun resolveSubroutineStmt(scope: VB6SubroutineStatement): VB6IdentifierOwner? {
        return this.compareReferenceAndScopeNameOrResolveInContext(scope)
    }

    override fun resolvePropertyGetStmt(scope: VB6PropertyGetStatement): VB6IdentifierOwner? {
        return scope.resolveInContext(this)
    }

    override fun resolvePropertySetStmt(scope: VB6PropertySetStatement): VB6IdentifierOwner? {
        return scope.resolveInContext(this)
    }

    override fun resolvePropertyLetStmt(scope: VB6PropertyLetStatement): VB6IdentifierOwner? {
        return scope.resolveInContext(this)
    }
}