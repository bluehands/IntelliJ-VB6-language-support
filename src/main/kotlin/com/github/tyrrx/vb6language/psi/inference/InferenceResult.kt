package com.github.tyrrx.vb6language.psi.inference

import com.intellij.psi.PsiElement

sealed interface InferenceResult {
    data class UserDefinedType(val typeDeclaration: VB6TypeDeclaration) : InferenceResult
    data class BaseType(val typeName: String?) : InferenceResult
    data class Unknown(val typeName: String?) : InferenceResult
}