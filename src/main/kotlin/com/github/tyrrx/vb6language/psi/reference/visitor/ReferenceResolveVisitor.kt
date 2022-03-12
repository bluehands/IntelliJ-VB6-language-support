package com.github.tyrrx.vb6language.psi.reference.visitor
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6WithStmt
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.conditional.VB6IfBlockStmt
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.conditional.VB6IfElseBlockStmt
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.conditional.VB6IfElseIfBlockStmt
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.loops.VB6DoLoopStmt
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.loops.VB6ForEachStmt
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.loops.VB6ForNextStmt
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.loops.VB6WhileWendStmt
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.*

interface ReferenceResolveVisitor {

    fun resolveModule(scope: VB6Module): VB6IdentifierOwner?
    fun resolveWithStmt(scope: VB6WithStmt): VB6IdentifierOwner?
    fun resolveIfBlockStmt(scope: VB6IfBlockStmt): VB6IdentifierOwner?
    fun resolveIfElseBlockStmt(scope: VB6IfElseBlockStmt): VB6IdentifierOwner?
    fun resolveIfElseIfStmt(scope: VB6IfElseIfBlockStmt): VB6IdentifierOwner?
    fun resolveDoLoopStmt(scope: VB6DoLoopStmt): VB6IdentifierOwner?
    fun resolveForEachStmt(scope: VB6ForEachStmt): VB6IdentifierOwner?
    fun resolveForNextStmt(scope: VB6ForNextStmt): VB6IdentifierOwner?
    fun resolveWhileWendStmt(scope: VB6WhileWendStmt): VB6IdentifierOwner?
    fun resolveFunctionStmt(scope: VB6FunctionStatement): VB6IdentifierOwner?
    fun resolveSubroutineStmt(scope: VB6SubroutineStatement): VB6IdentifierOwner?
    fun resolvePropertyGetStmt(scope: VB6PropertyGetStatement): VB6IdentifierOwner?
    fun resolvePropertySetStmt(scope: VB6PropertySetStatement): VB6IdentifierOwner?
    fun resolvePropertyLetStmt(scope: VB6PropertyLetStatement): VB6IdentifierOwner?
}