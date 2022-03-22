package com.github.tyrrx.vb6language.psi.reference

import com.github.tyrrx.vb6language.psi.reference.visitor.CallReferenceResolveVisitor
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6FunctionStatement
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6SubroutineStatement
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiReference

interface ICallReference : PsiReference {
}

class CallReference(
    private val myElement: VB6ReferenceOwner
) : ICallReference {
    override fun getElement(): PsiElement {
        return myElement
    }

    override fun getRangeInElement(): TextRange {
        return myElement.identifier.textRangeInParent
    }

    override fun resolve(): PsiElement? {
        return myElement.resolveInContext(CallReferenceResolveVisitor(myElement))
    }

    override fun getCanonicalText(): String {
        return myElement.identifier.name ?: ""
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        return myElement.identifier.setName(newElementName)
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
        return isReferenceToProcedure(otherElement)
    }

    private fun isReferenceToProcedure(element: PsiElement) = when (element) {
        is VB6SubroutineStatement -> compareNames(element)
        is VB6FunctionStatement -> compareNames(element)
        else -> false
    }

    private fun compareNames(element: PsiNamedElement) =
        element.name == myElement.identifier.name

    override fun isSoft(): Boolean {
        return false
    }
}