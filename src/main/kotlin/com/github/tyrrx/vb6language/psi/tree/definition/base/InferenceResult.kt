package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.reference.VB6Reference

sealed interface InferenceResult {
    data class ComplexType(val typeReference: VB6Reference?) : InferenceResult
    data class BaseType(val typeName: String?) : InferenceResult
    object Unknown : InferenceResult
}