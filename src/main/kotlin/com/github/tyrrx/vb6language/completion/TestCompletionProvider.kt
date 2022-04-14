package com.github.tyrrx.vb6language.completion

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.tree.definition.call.VB6BlockMembersCall
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.util.ProcessingContext

class TestCompletionProvider: CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        val pos = parameters.position
        val referenceOwner = when(val parent = pos.parent) {
            is VB6NamedElement -> parent.referenceOwner
            else -> null
        }



        val blockMembersCall = pos.parent.parent.parent
        val ref = when(blockMembersCall) {
            is VB6BlockMembersCall -> blockMembersCall.inlineCall?.finalReference
            else -> null
        }
        val target = ref?.resolve()
        val testElement = LookupElementBuilder.create("test")
        result.withPrefixMatcher(".")
        result.addElement(testElement)
    }
}