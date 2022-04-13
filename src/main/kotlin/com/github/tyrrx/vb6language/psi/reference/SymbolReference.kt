package com.github.tyrrx.vb6language.psi.reference

import com.github.tyrrx.vb6language.psi.reference.visitor.SymbolResolveVisitor
import com.github.tyrrx.vb6language.psi.reference.visitor.resolveInContext
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6TypeDeclaration
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6EnumerationStmt
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6Module
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6TypeStmt
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.util.containers.toArray

/**
 * Can reference:
 *      declare
 *      enumeration (member and type.member)
 *      const
 *      variable
 *      function
 *      sub
 *      property (get, let, set)
 */
class SymbolReference(
    override val myReferenceOwner: VB6ReferenceOwner,
    override val referencingNamedElement: VB6NamedElement,
    override val textRange: TextRange
) : VB6Reference {
    override fun getElement(): PsiElement {
        return myReferenceOwner
    }

    override fun getRangeInElement(): TextRange {
        return textRange
    }

    override fun resolve(): PsiElement? {
        return myReferenceOwner.resolveInContext(
            SymbolResolveVisitor(
                myReferenceOwner,
                referencingNamedElement
            )
        )
    }

    override fun getCanonicalText(): String {
        return referencingNamedElement.name ?: ""
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        return referencingNamedElement.setName(newElementName)
    }

    override fun bindToElement(element: PsiElement): PsiElement {
        TODO("Not yet implemented")
    }

    override fun isReferenceTo(element: PsiElement): Boolean {
        val otherElement = when (element) {
            is VB6NamedElement -> element.namedElementOwner
            else -> element
        }

        if (otherElement === myReferenceOwner) {
            return true
        }

        val resolve = resolve()
        return otherElement === resolve
    }

    override fun isSoft(): Boolean {
        return false
    }

    override fun getVariants(): Array<VB6NamedElementOwner> {
        return when (val resolveResult = resolve()) {
            is VB6TypeDeclaration ->
                when (resolveResult) {
                    is VB6Module -> resolveResult.outsideVisibleNamedElementOwners.toTypedArray()
                    is VB6EnumerationStmt -> resolveResult.enumMembers.toTypedArray()
                    is VB6TypeStmt -> resolveResult.members.toTypedArray()
                    else -> emptyArray()
                }
            else -> emptyArray()
        }
    }
}