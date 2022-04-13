package com.github.tyrrx.vb6language.highlighting

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6DeclareStmt
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6FunctionStatement
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6PropertyStatementBase
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6SubroutineStatement
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement

class CallableAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is VB6FunctionStatement -> highlightAsFunctionDeclaration(element, holder)
            is VB6SubroutineStatement -> highlightAsFunctionDeclaration(element, holder)
            is VB6PropertyStatementBase -> highlightAsFunctionDeclaration(element, holder)
            is VB6DeclareStmt -> highlightAsFunctionDeclaration(element, holder)
        }
    }

    private fun highlightAsFunctionDeclaration(
        element: VB6NamedElementOwner,
        holder: AnnotationHolder
    ) {
        element.nameIdentifier?.let {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(it)
                .textAttributes(VisualBasic6SyntaxHighlighter.FUNCTION_DECLARATION)
                .create()
        }
    }
}