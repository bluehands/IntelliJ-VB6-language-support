package com.github.tyrrx.vb6language.psi.tree.visitor
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

interface ScopeNodeVisitor<TReturn> {

    fun resolveFile(scope: VB6File): TReturn
    fun resolveModule(scope: VB6Module): TReturn
    fun resolveWithStmt(scope: VB6WithStmt): TReturn
    fun resolveIfBlockStmt(scope: VB6IfBlockStmt): TReturn
    fun resolveIfElseBlockStmt(scope: VB6IfElseBlockStmt): TReturn
    fun resolveIfElseIfStmt(scope: VB6IfElseIfBlockStmt): TReturn
    fun resolveDoLoopStmt(scope: VB6DoLoopStmt): TReturn
    fun resolveForEachStmt(scope: VB6ForEachStmt): TReturn
    fun resolveForNextStmt(scope: VB6ForNextStmt): TReturn
    fun resolveWhileWendStmt(scope: VB6WhileWendStmt): TReturn
    fun resolveFunctionStmt(scope: VB6FunctionStatement): TReturn
    fun resolveSubroutineStmt(scope: VB6SubroutineStatement): TReturn
    fun resolvePropertyGetStmt(scope: VB6PropertyGetStatement): TReturn
    fun resolvePropertySetStmt(scope: VB6PropertySetStatement): TReturn
    fun resolvePropertyLetStmt(scope: VB6PropertyLetStatement): TReturn
}