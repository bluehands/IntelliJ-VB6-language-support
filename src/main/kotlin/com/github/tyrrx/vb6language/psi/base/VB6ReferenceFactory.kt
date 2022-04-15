package com.github.tyrrx.vb6language.psi.base

import com.github.tyrrx.vb6language.psi.reference.VB6Reference

interface VB6ReferenceFactory {
    fun createReference(): VB6Reference?
}