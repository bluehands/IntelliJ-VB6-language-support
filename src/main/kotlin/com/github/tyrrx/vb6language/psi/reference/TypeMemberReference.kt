package com.github.tyrrx.vb6language.psi.reference

import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.inference.InferenceResult
import com.github.tyrrx.vb6language.psi.inference.VB6TypeDeclaration
import com.github.tyrrx.vb6language.psi.inference.VB6TypeInferable
import com.github.tyrrx.vb6language.psi.reference.visitor.TypeMemberDeclarationsVisitor
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
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
            resolveInElement(previousElement)
        }
        return result
    }

    private fun resolveInElement(element: PsiElement?): PsiElement? {
        return when (element) {
            is VB6TypeDeclaration -> element.processTypeDeclarations(
                TypeMemberDeclarationsVisitor(
                    referencingNamedElement
                )
            )
            is VB6TypeInferable -> resolveInInferenceResult(element)
            else -> null
        }
    }

    private fun resolveInInferenceResult(typeInferable: VB6TypeInferable) =
        when (val result = typeInferable.inferType()) {
            is InferenceResult.ComplexType -> {
                val resolvedType = result.typeReference?.resolve()
                resolveInElement(resolvedType)
            }
            else -> null
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

    override fun getVariants(): Array<Any> {
        return super.getVariants()
    }
}