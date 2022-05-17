package com.github.tyrrx.vb6language.psi.completion

import com.github.tyrrx.vb6language.language.VB6IElementTypes
import com.github.tyrrx.vb6language.language.VB6Language
import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6ModuleBodyImpl
import com.intellij.patterns.ElementPattern
import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType

inline fun <reified I : PsiElement> genericPsiElement(): PsiElementPattern.Capture<I> {
    return PlatformPatterns.psiElement(I::class.java)
}

fun psiElement(): PsiElementPattern.Capture<PsiElement> {
    return PlatformPatterns.psiElement(PsiElement::class.java).withLanguage(VB6Language.INSTANCE)
}

val Int.pattern: PsiElementPattern.Capture<PsiElement>
    get() = psiElement().withElementType(VB6IElementTypes.tokens[this])

fun <E> ElementPattern<E>.or(vararg pattern: ElementPattern<E>): ElementPattern<E> {
    return PlatformPatterns.or(this, *pattern)
}

fun <E> ElementPattern<E>.and(vararg pattern: ElementPattern<E>): ElementPattern<E> {
    return PlatformPatterns.and(this, *pattern)
}

fun afterAll(vararg patterns: IElementType): PsiElementPattern.Capture<PsiElement> {
    return patterns.map { psiElement().withElementType(it) }
            .reduceRight { psiElementPattern, acc -> acc.afterLeaf(psiElementPattern) }
}

val IElementType.pattern: PsiElementPattern.Capture<PsiElement>
    get() = psiElement().withElementType(this)


object CompletionPatterns {
    val vb6LanguagePsiElement = PlatformPatterns.psiElement().withLanguage(VB6Language.INSTANCE)
    val afterAsNew = psiElement().afterLeaf(afterAll(VB6IElementTypes.AS, VB6IElementTypes.NEW).or(VB6IElementTypes.AS.pattern))
    val moduleBodyElement: PsiElementPattern.Capture<PsiElement> = psiElement().withSuperParent(2, genericPsiElement<VB6ModuleBodyImpl>())

}