package com.github.tyrrx.vb6language.psi.tree.definition.general

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.language.VB6IElementTypes
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6TypeHint
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.utils.findInChildrenByAnyOfGivenElementTypes
import com.github.tyrrx.vb6language.psi.tree.utils.isIElementTypePresentInChildren
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType

interface VB6Argument :
    VB6NamedElementOwner,
    VB6TypeClauseOwner,
    VB6TypeHintOwner {
    fun isOptional(): Boolean //= false
    fun getPassType(): ByValOrRef //= ByValOrRef.BYVALUE (https://docs.microsoft.com/en-us/dotnet/visual-basic/programming-guide/language-features/procedures/passing-arguments-by-value-and-by-reference)
    fun isParameterArray(): Boolean //= false
    fun getArgumentDefaultValue(): VB6ArgumentDefaultValue?
}

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
            null -> ByValOrRef.BYREFERENCE
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

    override val typeClause: VB6AsTypeClause? get() = findFirstChildByType(this)



    override fun getArgumentDefaultValue(): VB6ArgumentDefaultValue? {
        return findFirstChildByType(this)
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override val isDefinition: Boolean
        get() = true

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = listOf(this)

    override val outsideVisibleNamedElements: List<VB6NamedElement>
        get() = TODO("Not yet implemented")

    override fun getNameIdentifier(): VB6NamedElement? {
        return findFirstChildByType(this)
    }

    override fun getTextOffset(): Int {
        return nameIdentifier?.textOffset ?: super.getTextOffset()
    }
}