package com.github.tyrrx.vb6language.psi.tree.nodes.impl


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.VB6IElementTypes
import com.github.tyrrx.vb6language.psi.tree.leafes.IdentifierPsiLeaf
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.*
import com.github.tyrrx.vb6language.psi.tree.nodes.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.nodes.utils.findInChildrenByAnyOfGivenElementTypes
import com.github.tyrrx.vb6language.psi.tree.nodes.utils.isIElementTypePresentInChildren
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType

class VB6ArgumentImpl(node: ASTNode) : VB6PsiNode(node), VB6Argument {

    object Factory : IPsiNodeFactory<VB6Argument> {
        override fun createPsiNode(node: ASTNode): VB6Argument {
            return VB6ArgumentImpl(node)
        }
    }

    override fun isOptional(): Boolean {
        return VB6IElementTypes.OPTIONAL.isIElementTypePresentInChildren(this)
    }

    override fun getPassType(): ByValOrRef {
        val findResult = findInChildrenByAnyOfGivenElementTypes(
            this,
            listOf(VB6IElementTypes.BYVAL, VB6IElementTypes.BYREF)
        )
        return when (findResult.elementType) {
            null -> ByValOrRef.BYVALUE
            VB6IElementTypes.BYVAL -> ByValOrRef.BYVALUE
            VB6IElementTypes.BYREF -> ByValOrRef.BYREFERENCE
            else -> throw NotImplementedError("Only BYVAL or BYREF implemented")
        }
    }

    override fun isParameterArray(): Boolean {
        return VB6IElementTypes.PARAMARRAY.isIElementTypePresentInChildren(this)
    }

    override fun getTypeHint(): VB6TypeHint? {
        return findFirstChildByType(this)
    }

    override fun getAsTypeClause(): VB6AsTypeClause? {
        return findFirstChildByType(this)
    }

    override fun getArgumentDefaultValue(): VB6ArgumentDefaultValue? {
        return findFirstChildByType(this)
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): VB6AmbiguousIdentifier? {
        return findFirstChildByType(this)
    }
}