package com.github.tyrrx.vb6language.psi.tree.utils

import com.intellij.lang.Language
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.impl.PsiFileFactoryImpl
import com.intellij.psi.tree.IElementType

fun createElementFromText(
    project: Project,
    language: Language,
    context: PsiElement?,
    text: String,
    type: IElementType
): PsiElement? {
    val factory = PsiFileFactory.getInstance(project) as PsiFileFactoryImpl
    return factory.createElementFromText(text, language, type, context)
}