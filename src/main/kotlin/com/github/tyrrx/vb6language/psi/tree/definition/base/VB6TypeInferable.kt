package com.github.tyrrx.vb6language.psi.tree.definition.base


interface VB6TypeInferable {
    fun inferType(): InferenceResult
}