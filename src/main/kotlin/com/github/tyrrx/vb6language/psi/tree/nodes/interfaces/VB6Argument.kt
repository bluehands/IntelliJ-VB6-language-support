package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces

import com.intellij.psi.PsiNameIdentifierOwner

interface VB6Argument: PsiNameIdentifierOwner {
    fun isOptional(): Boolean //= false
    fun getPassType(): ByValOrRef //= ByValOrRef.BYVALUE (https://docs.microsoft.com/en-us/dotnet/visual-basic/programming-guide/language-features/procedures/passing-arguments-by-value-and-by-reference)
    fun isParameterArray(): Boolean //= false
    fun getTypeHint(): VB6TypeHint?
    fun getAsTypeClause(): VB6AsTypeClause?
    fun getArgumentDefaultValue(): VB6ArgumentDefaultValue?
}