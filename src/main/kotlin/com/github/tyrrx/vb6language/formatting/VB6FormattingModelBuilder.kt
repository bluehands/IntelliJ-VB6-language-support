package com.github.tyrrx.vb6language.formatting

import com.intellij.formatting.*

class VB6FormattingModelBuilder : FormattingModelBuilder {
    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        return FormattingModelProvider.createFormattingModelForPsiFile(
                formattingContext.containingFile,
                VB6Block(formattingContext.node, Wrap.createWrap(WrapType.NONE, false), null),
                formattingContext.codeStyleSettings
        )
    }
}