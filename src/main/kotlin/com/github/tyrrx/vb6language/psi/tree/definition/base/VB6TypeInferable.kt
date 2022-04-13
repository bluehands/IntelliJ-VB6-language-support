package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.reference.VB6Reference

sealed interface VB6TypeInferenceResult {
    data class ComplexTypeInferenceResult(val typeReference: VB6Reference?) : VB6TypeInferenceResult
    data class BaseTypeInferenceResult(val typeName: String?) : VB6TypeInferenceResult
    object Unknown : VB6TypeInferenceResult
}


interface VB6TypeInferable {
    val inferType: VB6TypeInferenceResult
}