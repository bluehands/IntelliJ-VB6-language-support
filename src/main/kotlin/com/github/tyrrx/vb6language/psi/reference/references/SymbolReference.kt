package com.github.tyrrx.vb6language.psi.reference.references

import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.reference.visitor.SymbolResolveVisitor
import com.github.tyrrx.vb6language.psi.scope.contextAccept
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

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
        return myReferenceOwner.contextAccept(
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
}

//    private fun getVariantsFromElement(resolveResult: PsiElement?): Array<String> {
//        val res =  when (resolveResult) {
//            is VB6TypeDeclaration -> resolveResult.processTypeDeclarations(TypeDeclarationVariantsVisitor())
//            is VB6TypeInferable -> when(val result = resolveResult.inferType) {
//                is VB6TypeInferenceResult.ComplexTypeInferenceResult -> getVariantsFromElement(result.typeReference?.resolve())
//                else -> emptyArray()
//            }
//            else -> emptyArray()
//        }
//        return res
//    }
//}
//
//class TypeDeclarationVariantsVisitor : TypeDeclarationVisitor<Array<String>> {
//    override fun processModuleDeclarations(module: VB6Module): Array<String> {
//        return module.outsideVisibleNamedElementOwners.mapNotNull { it.name }.toTypedArray()
//    }
//
//    override fun processTypeStmtDeclarations(type: VB6TypeStmtImpl): Array<String> {
//        return type.members.mapNotNull { it.name }.toTypedArray()
//    }
//
//    override fun processEnumerationStmtDeclarations(enum: VB6EnumerationStmtImpl): Array<String> {
//        return enum.enumMembers.mapNotNull { it.name }.toTypedArray()
//    }
//}
