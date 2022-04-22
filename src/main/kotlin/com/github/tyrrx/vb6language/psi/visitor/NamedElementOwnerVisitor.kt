package com.github.tyrrx.vb6language.psi.visitor

import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6AttributeStmt
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6LetStmt
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6LineLabel
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Argument
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6ForEachStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6ForNextStmt
import com.github.tyrrx.vb6language.psi.tree.definition.module.*
import com.github.tyrrx.vb6language.psi.tree.definition.variable.VB6ConstStmt
import com.github.tyrrx.vb6language.psi.tree.definition.variable.VB6VariableDeclaration

interface NamedElementOwnerVisitor<TReturn> {
    fun visitAttribute(attributeStmt: VB6AttributeStmt): TReturn
    fun visitLetStmt(letStmt: VB6LetStmt): TReturn
    fun visitLineLabel(lineLabel: VB6LineLabel): TReturn
    fun visitArgument(argument: VB6Argument): TReturn
    fun visitForEachStmt(forEachStmt: VB6ForEachStmt): TReturn
    fun visitForNextStmt(forNextStmt: VB6ForNextStmt): TReturn
    fun visitDeclareFunctionStmt(declareFunctionStmt: VB6DeclareFunctionStmt): TReturn
    fun visitDeclareSubStmt(declareSubStmt: VB6DeclareSubStmt): TReturn
    fun visitEnumerationConstant(enumerationConstant: VB6EnumerationConstant): TReturn
    fun visitEnumerationStmt(enumerationStmt: VB6EnumerationStmt): TReturn
    fun visitEventStmt(eventStmt: VB6EventStmt): TReturn
    fun visitFunctionStmt(functionStatement: VB6FunctionStatement): TReturn
    fun visitModule(module: VB6Module): TReturn
    fun visitModuleConfigElement(moduleConfigElement: VB6ModuleConfigElement): TReturn
    fun visitPropertyGetStmt(propertyGetStatement: VB6PropertyGetStatement): TReturn
    fun visitPropertyLetStmt(propertyLetStatement: VB6PropertyLetStatement): TReturn
    fun visitPropertySetStmt(propertySetStatement: VB6PropertySetStatement): TReturn
    fun visitSubroutineStmt(subroutineStatement: VB6SubroutineStatement): TReturn
    fun visitTypeStmt(typeStmt: VB6TypeStmt): TReturn
    fun visitTypeStmtMember(typeStmtMember: VB6TypeStmtMember): TReturn
    fun visitConstStmt(constStmt: VB6ConstStmt): TReturn
    fun visitVariableDeclaration(variableDeclaration: VB6VariableDeclaration): TReturn

}