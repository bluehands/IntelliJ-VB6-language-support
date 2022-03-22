package com.github.tyrrx.vb6language.psi.reference

import com.github.tyrrx.vb6language.psi.reference.visitor.SymbolResolveVisitor
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiReference

interface IVariableOrProcedureReference : PsiReference

class SymbolReference(
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
        return myElement.resolveInContext(SymbolResolveVisitor(myElement))
    }

    override fun getCanonicalText(): String {
        return myElement.referencingIdentifier.name ?: ""
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        return myElement.referencingIdentifier.setName(newElementName)
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
            is PsiNamedElement -> compareElements(otherElement)
            else -> false
        }
    }

    private fun compareElements(element: PsiNamedElement) =
        element.name == myElement.referencingIdentifier.name && element === resolve()

    override fun isSoft(): Boolean {
        return false
    }
}