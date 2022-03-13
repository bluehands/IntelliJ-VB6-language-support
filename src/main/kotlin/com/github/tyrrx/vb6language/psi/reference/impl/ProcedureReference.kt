package com.github.tyrrx.vb6language.psi.reference.impl

import com.github.tyrrx.vb6language.psi.reference.ProcedureReference
import com.github.tyrrx.vb6language.psi.reference.resolveInContext
import com.github.tyrrx.vb6language.psi.reference.visitor.ProcedureReferenceResolveVisitor
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PropertyStatement
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6FunctionStatement
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6SubroutineStatement
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.refactoring.suggested.startOffset

class ProcedureReference(private val myElement: VB6ReferenceOwner) :
    ProcedureReference {
    override fun getElement(): PsiElement {
        return myElement
    }

    override fun getRangeInElement(): TextRange {
        val length = myElement.getIdentifier().textLength
        val start = myElement.textLength - length
        return TextRange(start, length + start)
    }

    override fun resolve(): PsiElement? {
        return myElement.resolveInContext(ProcedureReferenceResolveVisitor(myElement))
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
        val otherElement = when(element) {
            is VB6Identifier -> element.getOwner()
            else -> element
        }
        return isReferenceToProcedure(otherElement)
    }

    private fun isReferenceToProcedure(element: PsiElement) = when(element) {
        is VB6SubroutineStatement -> compareNames(element)
        is VB6FunctionStatement -> compareNames(element)
        else -> false
    }

    private fun compareNames(element: VB6IdentifierOwner) =
        element.name == myElement.getIdentifier().name

    override fun isSoft(): Boolean {
        return false
    }
}