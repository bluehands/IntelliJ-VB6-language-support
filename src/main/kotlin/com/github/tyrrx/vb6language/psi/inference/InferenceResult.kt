package com.github.tyrrx.vb6language.psi.inference

import com.github.tyrrx.vb6language.psi.reference.references.VB6Reference

sealed interface InferenceResult {
    data class ComplexType(val typeReference: VB6Reference?) : InferenceResult
    data class BaseType(val typeName: String?) : InferenceResult
    data class Unknown(val typeName: String?) : InferenceResult
}