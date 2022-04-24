package com.github.tyrrx.vb6language.documentation

import com.github.tyrrx.vb6language.psi.base.VB6ArgumentOwner
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6AttributeStmt
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6LetStmt
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6LineLabel
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Argument
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6ForEachStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6ForNextStmt
import com.github.tyrrx.vb6language.psi.tree.definition.module.*
import com.github.tyrrx.vb6language.psi.tree.definition.variable.VB6ConstStmt
import com.github.tyrrx.vb6language.psi.tree.definition.variable.VB6VariableListElement
import com.github.tyrrx.vb6language.psi.visitor.NamedElementOwnerVisitor

class QuickNavigationInfoRendererForNamedElementOwners : NamedElementOwnerVisitor<String> {

    override fun visitAttribute(attributeStmt: VB6AttributeStmt): String {
        return buildString { renderAttribute(attributeStmt) }
    }

    override fun visitLetStmt(letStmt: VB6LetStmt): String {
        return buildString { renderLetStmt(letStmt, this@QuickNavigationInfoRendererForNamedElementOwners) }
    }

    override fun visitLineLabel(lineLabel: VB6LineLabel): String {
        return buildString { renderLineLabel(lineLabel) }
    }

    override fun visitArgument(argument: VB6Argument): String {
        return buildString { renderArgument(argument) }
    }

    override fun visitForEachStmt(forEachStmt: VB6ForEachStmt): String {
        return buildString { renderForEach(forEachStmt) }
    }

    override fun visitForNextStmt(forNextStmt: VB6ForNextStmt): String {
        return buildString { renderForNext(forNextStmt) }
    }

    override fun visitDeclareFunctionStmt(declareFunctionStmt: VB6DeclareFunctionStmt): String {
        return buildString { renderDeclareFunction(declareFunctionStmt) }
    }

    override fun visitDeclareSubStmt(declareSubStmt: VB6DeclareSubStmt): String {
        return buildString { renderDeclareSub(declareSubStmt) }
    }

    override fun visitEnumerationConstant(enumerationConstant: VB6EnumerationConstant): String {
        return buildString { renderEnumConst(enumerationConstant) }
    }

    override fun visitEnumerationStmt(enumerationStmt: VB6EnumerationStmt): String {
        return buildString { renderEnum(enumerationStmt) }
    }

    override fun visitEventStmt(eventStmt: VB6EventStmt): String {
        return buildString { renderEvent(eventStmt) }
    }

    override fun visitFunctionStmt(functionStatement: VB6FunctionStatement): String {
        return buildString { renderFunction(functionStatement) }
    }

    override fun visitModule(module: VB6Module): String {
        return buildString { renderModule(module) }
    }

    override fun visitModuleConfigElement(moduleConfigElement: VB6ModuleConfigElement): String {
        return buildString { renderModuleConfigElement(moduleConfigElement) }
    }

    override fun visitPropertyGetStmt(propertyGetStatement: VB6PropertyGetStatement): String {
        return buildString { renderPropertyGet(propertyGetStatement) }
    }

    override fun visitPropertyLetStmt(propertyLetStatement: VB6PropertyLetStatement): String {
        return buildString { renderPropertyLet(propertyLetStatement) }
    }

    override fun visitPropertySetStmt(propertySetStatement: VB6PropertySetStatement): String {
        return buildString { renderPropertySet(propertySetStatement) }
    }

    override fun visitSubroutineStmt(subroutineStatement: VB6SubroutineStatement): String {
        return buildString { renderSub(subroutineStatement) }
    }

    override fun visitTypeStmt(typeStmt: VB6TypeStmt): String {
        return buildString { renderType(typeStmt) }
    }

    override fun visitTypeStmtMember(typeStmtMember: VB6TypeStmtMember): String {
        return buildString { renderTypeMember(typeStmtMember) }
    }

    override fun visitConstStmt(constStmt: VB6ConstStmt): String {
        return buildString { renderConst(constStmt) }
    }

    override fun visitVariableDeclaration(variableDeclaration: VB6VariableListElement): String {
        return buildString { renderVariable(variableDeclaration) }
    }
}

private fun StringBuilder.renderForNext(forNextStmt: VB6ForNextStmt) {
    whiteSpaceAfterThis {
        bold { append("For") }
    }
    whiteSpaceAfterThis {
        append(forNextStmt.iteratorDeclaration?.text)
    }
    appendTypeInferable(forNextStmt)
    // todo add EQ expression TO expression \n NEXT

}

private fun StringBuilder.renderForEach(forEachStmt: VB6ForEachStmt) {
    whiteSpaceAfterThis {
        bold { append("For Each") }
    }
    whiteSpaceAfterThis {
        append(forEachStmt.iteratorDeclaration?.text)
    }
    whiteSpaceAfterThis {
        append("In")
    }
    append(forEachStmt.inCollection?.text)
}

private fun StringBuilder.renderAttribute(attributeStmt: VB6AttributeStmt) {
    append(attributeStmt.text)
}

private fun StringBuilder.renderDeclareSub(declareSubStmt: VB6DeclareSubStmt) {
    appendVisibility(declareSubStmt)
    whiteSpaceSurrounded {
        append("Declare")
    }
    if (declareSubStmt.isPtrSafe) {
        whiteSpaceAfterThis {
            append("PtrSafe")
        }
    }

    whiteSpaceAfterThis {
        bold {
            append("Sub")
        }
    }
    appendName(declareSubStmt)
    declareSubStmt.lib?.let {
        whiteSpaceSurrounded {
            append("Lib \"${it.stringLiteral?.value}\"")
        }
    }
    declareSubStmt.alias?.let {
        whiteSpaceSurrounded {
            append("Alias \"${it.stringLiteral?.value}\"")
        }
    }
    appendArguments(declareSubStmt)
}

private fun StringBuilder.renderEvent(eventStmt: VB6EventStmt) {
    whiteSpaceAfterThis {
        appendVisibility(eventStmt)
    }
    whiteSpaceAfterThis {
        bold { append("Event") }
    }
    appendName(eventStmt)
    appendArguments(eventStmt)
}

private fun StringBuilder.renderPropertySet(propertySetStatement: VB6PropertySetStatement) {
    whiteSpaceAfterThis {
        appendVisibility(propertySetStatement)
    }
    if (propertySetStatement.isStatic()) {
        whiteSpaceAfterThis { append("Static") }
    }
    whiteSpaceAfterThis {
        bold { append("Property Set") }
    }
    whiteSpaceAfterThis {
        appendName(propertySetStatement)
    }
    appendArguments(propertySetStatement)
}

private fun StringBuilder.renderPropertyLet(propertyLetStatement: VB6PropertyLetStatement) {
    whiteSpaceAfterThis {
        appendVisibility(propertyLetStatement)
    }
    if (propertyLetStatement.isStatic()) {
        whiteSpaceAfterThis { append("Static") }
    }
    whiteSpaceAfterThis {
        bold { append("Property Let") }
    }
    whiteSpaceAfterThis {
        appendName(propertyLetStatement)
    }
    appendArguments(propertyLetStatement)
}

private fun StringBuilder.renderArgument(argument: VB6Argument) {
    if (argument.isOptional()) {
        whiteSpaceAfterThis {
            append("Optional")
        }
    }
    whiteSpaceAfterThis {
        bold {
            append(argument.getPassType().humanName)
        }
    }
    if (argument.isOptional()) {
        whiteSpaceAfterThis {
            append("ParamArray")
        }
    }
    appendName(argument)
    appendTypeInferable(argument)
    argument.getArgumentDefaultValue()?.let {
        whiteSpaceBeforeThis { append(it.text) }
    }
}

private fun StringBuilder.renderDeclareFunction(resolve: VB6DeclareFunctionStmt) {
    appendVisibility(resolve)
    whiteSpaceSurrounded {
        append("Declare")
    }
    if (resolve.isPtrSafe) {
        whiteSpaceAfterThis {
            append("PtrSafe")
        }
    }
    bold {
        whiteSpaceAfterThis {
            if (resolve.function != null) {
                append("Function")
            } else {
                append("Sub")
            }
        }
    }
    appendName(resolve)
    resolve.lib?.let {
        whiteSpaceSurrounded {
            append("Lib \"${it.stringLiteral?.value}\"")
        }
    }
    resolve.alias?.let {
        whiteSpaceSurrounded {
            append("Alias \"${it.stringLiteral?.value}\"")
        }
    }
    appendArguments(resolve)
    appendTypeInferable(resolve)
}

private fun StringBuilder.renderModule(resolve: VB6Module) {
    if (resolve.isClass()) {
        append("Class ")
    } else {
        append("Module ")
    }
    appendName(resolve)
}

private fun StringBuilder.renderFunction(resolve: VB6FunctionStatement) {
    appendVisibility(resolve)
    bold { append(" Function ") }
    appendName(resolve)
    appendArguments(resolve)
    appendTypeInferable(resolve)
}

private fun StringBuilder.renderSub(resolve: VB6SubroutineStatement) {
    appendVisibility(resolve)
    bold { append(" Sub ") }
    appendName(resolve)
    appendArguments(resolve)
}

private fun StringBuilder.renderEnum(resolve: VB6EnumerationStmt) {
    appendVisibility(resolve)
    bold { append(" Enum ") }
    appendName(resolve)
}

private fun StringBuilder.renderEnumConst(resolve: VB6EnumerationConstant) {
    resolve.ofEnum?.let {
        renderEnum(it)
        append(":\n")
    }
    appendName(resolve)
    appendTypeInferable(resolve)
    // append(" = ")
    // todo value
}

private fun StringBuilder.renderType(resolve: VB6TypeStmt) {
    appendVisibility(resolve)
    bold { append(" Type ") }
    appendName(resolve)
}

private fun StringBuilder.renderTypeMember(resolve: VB6TypeStmtMember) {
    resolve.ofTypeStmt?.let {
        renderType(it)
        append(":\n")
    }
    appendName(resolve)
    appendTypeInferable(resolve)
}

private fun StringBuilder.renderConst(resolve: VB6ConstStmt) {
    if (resolve.isModuleConst) {
        appendVisibility(resolve)
        append(" ")
    }
    bold { append("Const ") }
    appendName(resolve)
    appendTypeInferable(resolve)
}

private fun StringBuilder.renderVariable(resolve: VB6VariableListElement) {
    if (resolve.isModuleVariable) {
        appendVisibility(resolve)
        bold { append(" Dim ") }
        if (resolve.withEvents) {
            append("Withevents ")
        }
    } else {
        bold {
            if (resolve.isStatic) {
                append("Static")
            } else {
                append("Dim ")
            }
        }
    }
    appendName(resolve)
    appendTypeInferable(resolve)
}

private fun StringBuilder.renderLetStmt(letStmt: VB6LetStmt, renderer: QuickNavigationInfoRendererForNamedElementOwners) {
    if (letStmt.isDefinition) {
        bold { append("Let ") }
        appendName(letStmt)
        appendTypeInferable(letStmt)
    } else {
        append(when (val resolve = letStmt.reference?.resolve()) {
            is VB6NamedElementOwner -> resolve.accept(renderer)
            else -> "Not implemented"
        })
    }
}

private fun StringBuilder.renderLineLabel(lineLabel: VB6LineLabel) {
    bold { append("LineLabel: ") }
    appendName(lineLabel)
}

private fun StringBuilder.renderModuleConfigElement(moduleConfigElement: VB6ModuleConfigElement) {
    whiteSpaceAfterThis {
        bold {
            append("Module Config:")
        }
    }
    appendName(moduleConfigElement)
    moduleConfigElement.getLiteral()?.let {
        whiteSpaceSurrounded { append("=") }
        append(it.text)
    }
}

private fun StringBuilder.renderPropertyGet(propertyGetStatement: VB6PropertyGetStatement) {
    whiteSpaceAfterThis {
        appendVisibility(propertyGetStatement)
    }
    if (propertyGetStatement.isStatic()) {
        whiteSpaceAfterThis { append("Static") }
    }
    whiteSpaceAfterThis {
        bold { append("Property Get") }
    }
    whiteSpaceAfterThis {
        appendName(propertyGetStatement)
    }
    appendArguments(propertyGetStatement)
    appendTypeInferable(propertyGetStatement)
}

private fun StringBuilder.appendArguments(argumentOwner: VB6ArgumentOwner) {
    append(argumentOwner.arguments.joinToString(", ") {
        buildString {
            renderArgument(it)
        }
    })
}