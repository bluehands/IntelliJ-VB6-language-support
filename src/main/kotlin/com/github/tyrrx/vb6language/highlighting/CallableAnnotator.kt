package com.github.tyrrx.vb6language.highlighting

import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.declarations.VB6PropertyDeclaration
import com.github.tyrrx.vb6language.psi.tree.definition.module.*
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement

class CallableAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is VB6FunctionStatement -> highlightAsFunctionDeclaration(element, holder)
            is VB6SubroutineStatement -> highlightAsFunctionDeclaration(element, holder)
            is VB6PropertyDeclaration -> highlightAsFunctionDeclaration(element, holder)
            is VB6DeclareFunctionStmt -> highlightAsFunctionDeclaration(element, holder)
            is VB6DeclareSubStmt -> highlightAsFunctionDeclaration(element, holder)
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