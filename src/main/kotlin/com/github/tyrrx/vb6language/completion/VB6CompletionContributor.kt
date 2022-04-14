package com.github.tyrrx.vb6language.completion

import com.github.tyrrx.vb6language.language.VB6Language
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.patterns.PlatformPatterns

class VB6CompletionContributor: CompletionContributor() {
    init {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement().withLanguage(VB6Language.INSTANCE), TestCompletionProvider())
    }
}