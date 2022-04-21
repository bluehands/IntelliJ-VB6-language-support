package com.github.tyrrx.vb6language.completion

import com.github.tyrrx.vb6language.completion.providers.DeclarationCompletionProvider
import com.github.tyrrx.vb6language.completion.providers.MemberReferenceCompletionProvider
import com.intellij.codeInsight.completion.*

class VB6CompletionContributor : CompletionContributor() {
    init {
        extend(CompletionType.BASIC, psiElement(), MemberReferenceCompletionProvider())
        extend(CompletionType.BASIC, psiElement(), DeclarationCompletionProvider())
    }
}