package com.github.tyrrx.vb6language.psi

import com.github.tyrrx.vb6language.psi.tree.IdentifierPsiLeaf
import com.intellij.lang.DefaultASTFactoryImpl
import com.intellij.psi.impl.source.tree.LeafElement
import com.intellij.psi.impl.source.tree.PsiWhiteSpaceImpl
import com.intellij.psi.tree.IElementType

class ASTFactory : DefaultASTFactoryImpl() {
    override fun createLeaf(type: IElementType, text: CharSequence): LeafElement {

        return when (type) {
            VisualBasic6ParserDefinition.IDENTIFIER -> IdentifierPsiLeaf(type, text)
            in VisualBasic6ParserDefinition.WHITESPACES -> PsiWhiteSpaceImpl(text)
            else -> super.createLeaf(type, text)
        }
    }
}