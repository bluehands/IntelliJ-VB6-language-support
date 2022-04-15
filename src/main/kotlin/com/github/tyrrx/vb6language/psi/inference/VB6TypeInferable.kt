package com.github.tyrrx.vb6language.psi.inference

import com.github.tyrrx.vb6language.psi.inference.InferenceResult


interface VB6TypeInferable {
    fun inferType(): InferenceResult
}