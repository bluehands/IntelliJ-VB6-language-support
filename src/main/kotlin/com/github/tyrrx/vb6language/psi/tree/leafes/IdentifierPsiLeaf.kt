package com.github.tyrrx.vb6language.psi.tree.leafes

import com.github.tyrrx.vb6language.psi.ILeafFactory
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.impl.source.tree.LeafElement
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.psi.ANTLRPsiLeafNode

class IdentifierPsiLeaf(type: IElementType?, text: CharSequence?) : ANTLRPsiLeafNode(type, text), PsiNamedElement {
    override fun getName(): String {
        return text
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    object Factory : ILeafFactory {
        override fun createLeaf(type: IElementType, text: CharSequence): LeafElement {
            return IdentifierPsiLeaf(type, text)
        }
    }
}