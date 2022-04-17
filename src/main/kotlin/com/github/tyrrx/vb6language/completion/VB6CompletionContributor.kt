package com.github.tyrrx.vb6language.completion

import com.github.tyrrx.vb6language.completion.providers.MemberReferenceCompletionProvider
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6ModuleBody
import com.intellij.codeInsight.completion.*

class VB6CompletionContributor : CompletionContributor() {
    init {
        extend(CompletionType.BASIC, psiElement(), MemberReferenceCompletionProvider())
    }

    override fun beforeCompletion(context: CompletionInitializationContext) {

    }
}