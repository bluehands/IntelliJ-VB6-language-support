package com.github.tyrrx.vb6language.psi.reference.visitor

import com.github.tyrrx.vb6language.psi.reference.resolveInContext
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6BlockOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6BlockScopeOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6IdentifierOwner
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
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.refactoring.suggested.endOffset

class SymbolResolveVisitor(override val referenceOwner: VB6ReferenceOwner) :
    ReferenceResolveVisitor {

    private fun compareNames(it: VB6IdentifierOwner) =
        it.name == referenceOwner.getIdentifier().name

    private fun resolveBlock(scope: VB6BlockOwner): VB6IdentifierOwner? {
        referenceOwner.textRangeInParent

        return scope.block
            ?.definitions
            ?.takeWhile { it.textOffset < referenceOwner.textOffset }
            ?.find { compareNames(it) }
    }

//    private fun resolveSelf(scope: VB6IdentifierOwner) =
//        if (compareNames(scope)) {
//            scope
//        } else {
//            null
//        }

    override fun resolveModule(scope: VB6Module): VB6IdentifierOwner? {
        return scope.definitions.find { compareNames(it) }
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
        return resolveBlock(scope)
            ?: scope.arguments.find { compareNames(it) }
            ?: scope.resolveInContext(this)
    }

    override fun resolveSubroutineStmt(scope: VB6SubroutineStatement): VB6IdentifierOwner? {
        return resolveBlock(scope)
            ?: scope.arguments.find { compareNames(it) }
            ?: scope.resolveInContext(this)
    }

    override fun resolvePropertyGetStmt(scope: VB6PropertyGetStatement): VB6IdentifierOwner? {
        return resolveBlock(scope)
            ?: scope.arguments.find { compareNames(it) }
            ?: scope.resolveInContext(this)
    }

    override fun resolvePropertySetStmt(scope: VB6PropertySetStatement): VB6IdentifierOwner? {
        return resolveBlock(scope)
            ?: scope.arguments.find { compareNames(it) }
            ?: scope.resolveInContext(this)
    }

    override fun resolvePropertyLetStmt(scope: VB6PropertyLetStatement): VB6IdentifierOwner? {
        return resolveBlock(scope)
            ?: scope.arguments.find { compareNames(it) }
            ?: scope.resolveInContext(this)
    }
}