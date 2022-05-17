package com.github.tyrrx.vb6language.psi.completion

import com.github.tyrrx.vb6language.psi.completion.providers.DeclarationCompletionProvider
import com.github.tyrrx.vb6language.psi.completion.providers.MemberReferenceCompletionProvider
import com.intellij.codeInsight.completion.*

class VB6CompletionContributor : CompletionContributor() {
    init {
        extend(CompletionType.BASIC, psiElement(), MemberReferenceCompletionProvider())
        extend(CompletionType.BASIC, psiElement(), DeclarationCompletionProvider())
    }
}