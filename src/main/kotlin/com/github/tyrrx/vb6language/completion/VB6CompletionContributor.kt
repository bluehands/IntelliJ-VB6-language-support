package com.github.tyrrx.vb6language.completion

import com.github.tyrrx.vb6language.completion.providers.IdentifierCompletionProvider
import com.github.tyrrx.vb6language.completion.providers.MemberReferenceCompletionProvider
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6ModuleBody
import com.intellij.codeInsight.completion.*

class VB6CompletionContributor : CompletionContributor() {
    init {
        extend(CompletionType.BASIC, psiElement(), MemberReferenceCompletionProvider())
        extend(CompletionType.BASIC, psiElement(), IdentifierCompletionProvider())
    }
}