package com.github.tyrrx.vb6language.psi.tree.nodes

import com.github.tyrrx.vb6language.VB6Language
import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.VB6IElementTypes
import com.github.tyrrx.vb6language.psi.tree.*
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import org.antlr.intellij.adaptor.SymtabUtils

class VB6FunctionImpl(node: ASTNode) : VB6PsiNode(node), VB6Function {
    override fun getVisibility(): VB6VisibilityEnum {
        return findPsiElementInSubtree<VB6Visibility>(this)
            ?.getEnumValue() ?: VB6VisibilityEnum.PUBLIC
    }

    override fun isStatic(): Boolean {
        return findLeafInChildrenByElementType(this, VB6IElementTypes.STATIC) != null
    }

    override fun resolve(element: PsiNamedElement?): PsiElement? {
        return SymtabUtils.resolve(
            this, VB6Language.INSTANCE,
            element, "/ambiguousIdentifier/IDENTIFIER"
        )
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getName(): String? {
        return nameIdentifier?.text
    }

    override fun getNameIdentifier(): PsiElement? {
        return this.findIdentifierInSubtree()
    }

    object Factory : IPsiNodeFactory<VB6FunctionImpl> {
        override fun createPsiNode(node: ASTNode): VB6FunctionImpl {
            return VB6FunctionImpl(node)
        }
    }
}