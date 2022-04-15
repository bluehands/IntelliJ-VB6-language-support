package com.github.tyrrx.vb6language.psi.inference

import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6BaseType
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6ComplexType
import com.intellij.psi.PsiElement

interface VB6TypeClauseOwner : VB6TypeInferable {
    val typeClause: VB6AsTypeClause?
    override fun inferType(): InferenceResult = when (val type = typeClause?.typeRule?.type) {
        is VB6BaseType -> InferenceResult.BaseType(type.name)
        is VB6ComplexType -> type.inferType()
        else -> InferenceResult.Unknown(null)
    }

}