package com.github.tyrrx.vb6language.psi.inference

import com.github.tyrrx.vb6language.psi.reference.references.TypeReference
import com.github.tyrrx.vb6language.psi.reference.references.VB6Reference
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6BaseType
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6ComplexType
import com.intellij.psi.PsiElement

interface VB6TypeClauseOwner : VB6TypeInferable {
    val typeClause: VB6AsTypeClause?
    override fun inferType(): InferenceResult = when (val type = typeClause?.typeRule?.type) {
        is VB6BaseType -> InferenceResult.BaseType(type.name)
        is VB6ComplexType -> inferComplexType()
        else -> InferenceResult.Unknown(null)
    }

    private fun inferComplexType(): InferenceResult {
        return typeDeclarationOf(typeClause)
                ?.let {
                    InferenceResult.UserDefinedType(it)
                } ?: InferenceResult.Unknown(null)
    }


    private fun typeDeclarationOf(typeClause: VB6AsTypeClause?) =
            typeReferenceOf(typeClause)
                    ?.resolve()
                    ?.let { assertIsTypeDeclaration(it) }

    private fun typeReferenceOf(typeClause: VB6AsTypeClause?): TypeReference? =
            typeClause?.let { clause ->
                clause.reference?.let {
                    assertTypeReference(it)
                }
            }

    private fun assertIsTypeDeclaration(typeDeclaration: PsiElement) =
            when (typeDeclaration) {
                is VB6TypeDeclaration -> typeDeclaration
                else -> error("Expecting type declaration but got ${typeDeclaration.javaClass.simpleName} instead")
            }

    private fun assertTypeReference(ref: VB6Reference) = when (ref) {
        is TypeReference -> ref
        else -> error("Expecting type reference but got ${ref.javaClass.simpleName} instead")
    }
}