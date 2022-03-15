package com.github.tyrrx.vb6language.psi.reference

import com.github.tyrrx.vb6language.psi.reference.visitor.CallReferenceResolveVisitor
import com.github.tyrrx.vb6language.psi.reference.visitor.VariableOrProcedureReferenceResolveVisitor
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PropertyStatementBase
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Argument
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6ForEachStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6ForNextStmt
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6FunctionStatement
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6SubroutineStatement
import com.github.tyrrx.vb6language.psi.tree.definition.variable.VB6VariableDefinitionBase
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiReference

interface IVariableOrProcedureReference : PsiReference

class VariableOrProcedureReference(
    private val myElement: VB6ReferenceOwner,
    private val textRange: TextRange
) : IVariableOrProcedureReference {
    override fun getElement(): PsiElement {
        return myElement
    }

    override fun getRangeInElement(): TextRange {
        return textRange
    }

    override fun resolve(): PsiElement? {
        return myElement.resolveInContext(VariableOrProcedureReferenceResolveVisitor(myElement))
    }

    override fun getCanonicalText(): String {
        return myElement.getIdentifier().name ?: ""
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        return myElement.getIdentifier().setName(newElementName)
    }

    override fun bindToElement(element: PsiElement): PsiElement {
        TODO("Not yet implemented")
    }

    override fun isReferenceTo(element: PsiElement): Boolean {

        if (element === myElement) {
            return true
        }

        val otherElement = when (element) {
            is VB6Identifier -> element.getOwner()
            else -> element
        }

        return when(otherElement) {
            is VB6VariableDefinitionBase -> compareNames(otherElement)
            is VB6SubroutineStatement -> compareNames(otherElement)
            is VB6FunctionStatement -> compareNames(otherElement)
            is VB6PropertyStatementBase -> compareNames(otherElement)
            is VB6Argument -> compareNames(otherElement)
            is VB6ForEachStmt -> compareNames(otherElement)
            is VB6ForNextStmt -> compareNames(otherElement)
            else -> false
        }
    }

    private fun compareNames(element: PsiNamedElement) =
        element.name == myElement.getIdentifier().name && element === resolve()

    override fun isSoft(): Boolean {
        return false
    }
}