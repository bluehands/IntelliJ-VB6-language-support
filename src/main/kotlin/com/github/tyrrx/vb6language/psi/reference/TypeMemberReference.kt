package com.github.tyrrx.vb6language.psi.reference

import com.github.tyrrx.vb6language.psi.reference.visitor.TypeMemberResolveVisitor
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ScopeNode
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6TypeStmtMember
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

class TypeMemberReference(
    override val myReferenceOwner: VB6ReferenceOwner,
    override val referencingNamedElement: VB6NamedElement,
    override val textRange: TextRange,
    private val previousReference: VB6Reference?
) : VB6Reference {
    override fun getElement(): PsiElement {
        return myReferenceOwner
    }

    override fun getRangeInElement(): TextRange {
        return textRange
    }

    override fun resolve(): PsiElement? {

        val result = previousReference?.let {
            val previousElement = it.resolve()
            return when (previousElement) {
                is VB6ScopeNode -> previousElement.resolve(
                    TypeMemberResolveVisitor(
                        myReferenceOwner,
                        referencingNamedElement
                    )
                )
                is VB6TypeStmtMember -> previousElement.asTypeClause?.reference?.resolve()
                else -> null
            }
        }
        return result
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

        val resolve = resolve()
        return otherElement === resolve
    }

    override fun isSoft(): Boolean {
        return false
    }
}