package com.github.tyrrx.vb6language.psi.reference

import com.github.tyrrx.vb6language.psi.reference.references.VB6Reference

interface VB6ReferenceFactory {
    fun createReference(): VB6Reference?
}