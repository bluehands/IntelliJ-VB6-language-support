package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6BaseType
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6ComplexType

interface VB6TypeClauseOwner : VB6TypeInferable {
    val typeClause: VB6AsTypeClause?
    override val inferType: VB6TypeInferenceResult
        get() = when (val type = typeClause?.typeRule?.type) {
            is VB6BaseType -> VB6TypeInferenceResult.BaseTypeInferenceResult(type.name)
            is VB6ComplexType -> VB6TypeInferenceResult.ComplexTypeInferenceResult(typeClause?.reference)
            else -> VB6TypeInferenceResult.Unknown
        }
}