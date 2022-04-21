package com.github.tyrrx.vb6language.psi.visitor

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

    fun visitFile(scope: VB6File): TReturn
    fun visitModule(scope: VB6Module): TReturn
    fun visitWithStmt(scope: VB6WithStmt): TReturn
    fun visitIfBlockStmt(scope: VB6IfBlockStmt): TReturn
    fun visitIfElseBlockStmt(scope: VB6IfElseBlockStmt): TReturn
    fun visitIfElseIfStmt(scope: VB6IfElseIfBlockStmt): TReturn
    fun visitDoLoopStmt(scope: VB6DoLoopStmt): TReturn
    fun visitForEachStmt(scope: VB6ForEachStmt): TReturn
    fun visitForNextStmt(scope: VB6ForNextStmt): TReturn
    fun visitWhileWendStmt(scope: VB6WhileWendStmt): TReturn
    fun visitFunctionStmt(scope: VB6FunctionStatement): TReturn
    fun visitSubroutineStmt(scope: VB6SubroutineStatement): TReturn
    fun visitPropertyGetStmt(scope: VB6PropertyGetStatement): TReturn
    fun visitPropertySetStmt(scope: VB6PropertySetStatement): TReturn
    fun visitPropertyLetStmt(scope: VB6PropertyLetStatement): TReturn
}