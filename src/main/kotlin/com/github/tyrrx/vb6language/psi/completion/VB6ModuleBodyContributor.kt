package com.github.tyrrx.vb6language.psi.completion

import com.github.tyrrx.vb6language.parser.VisualBasic6Parser
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6Module
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6ModuleBody
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6ModuleDeclarations
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionInitializationContext
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.psi.PsiErrorElement

/**
 * Adds structures for module body completion.
 */
class VB6ModuleBodyContributor : CompletionContributor() {

    /**
     * Inject a dummy sub and test in [fillCompletionVariants] if the parser produced a valid tree
     */
    override fun beforeCompletion(context: CompletionInitializationContext) {
        val ctx = context.file.findElementAt(context.startOffset)

        if (ctx?.parent?.parent is VB6ModuleBody
                || ctx?.parent?.prevSibling is VB6ModuleBody
                || (ctx?.parent?.prevSibling is VB6ModuleDeclarations && ctx.parent?.nextSibling is VB6ModuleBody)) {
            context.dummyIdentifier = "Public Sub dummy\n End Sub"
        }
    }

    /**
     * The parser produces an [PsiErrorElement] as next sibling of the [VisualBasic6Parser.module] rule if the injected dummy is invalid at the current position.
     * Otherwise, the next sibling is null.
     */
    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val expectingVB6Module = parameters.position.parent?.parent?.parent?.parent?.parent

        if (expectingVB6Module is VB6Module && expectingVB6Module.nextSibling == null) {
            result.addElement(LookupElementBuilder.create("Public Function newFunction() As Variant\n\nEnd Function").withPresentableText("Public Function")
                    .withIcon(AllIcons.Nodes.Function))
            result.addElement(LookupElementBuilder.create("Public Sub newSub\n\nEnd Sub").withPresentableText("Public Sub")
                    .withIcon(AllIcons.Nodes.Method))
            result.addElement(LookupElementBuilder.create("Public Property Get newProperty As Variant\n\nEnd Property").withPresentableText("Public Property Get")
                    .withIcon(AllIcons.Nodes.Property))
            result.addElement(LookupElementBuilder.create("Public Property Let newProperty\n\nEnd Property").withPresentableText("Public Property Let")
                    .withIcon(AllIcons.Nodes.Property))
            result.addElement(LookupElementBuilder.create("Public Property Set newProperty\n\nEnd Property").withPresentableText("Public Property Set")
                    .withIcon(AllIcons.Nodes.Property))
        }
    }
}