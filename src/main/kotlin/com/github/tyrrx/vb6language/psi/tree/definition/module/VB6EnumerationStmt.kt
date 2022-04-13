package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Visibility
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6VisibilityEnum
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInDirectChildrenByType
import com.github.tyrrx.vb6language.psi.tree.visitor.TypeDeclarationVisitor
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6EnumerationStmt :
    VB6TypeDeclaration,
    VB6EnclosingVisibleNamedElements,
    VB6PsiElement,
    VB6NamedElementOwner,
    VB6VisibilityOwner {
    val enumMembers: List<VB6EnumerationConstant>
}

class VB6EnumerationStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6EnumerationStmt {

    object Factory : IPsiNodeFactory<VB6EnumerationStmt> {
        override fun createPsiNode(node: ASTNode): VB6EnumerationStmt {
            return VB6EnumerationStmtImpl(node)
        }
    }

    override val enumMembers: List<VB6EnumerationConstant>
        get() = findPsiElementsInDirectChildrenByType(this)

    override fun <TReturn> processTypeDeclarations(visitor: TypeDeclarationVisitor<TReturn>): TReturn {
        return visitor.processEnumerationStmtDeclarations(this)
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = listOf(this) + enumMembers

    override val outsideVisibleNamedElements: List<VB6NamedElement>
        get() = emptyList() // todo also this?

    override fun getNameIdentifier(): VB6NamedElement? {
        return findFirstChildByType(this)
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override val isDefinition: Boolean
        get() = true

    override fun setName(name: String): PsiElement {
        nameIdentifier?.setName(name)
        return this
    }

    override val visibility: VB6VisibilityEnum
        get() = findFirstChildByType<VB6Visibility>(this)?.getEnumValue() ?: VB6VisibilityEnum.PUBLIC

    override fun getTextOffset(): Int {
        return nameIdentifier?.textOffset ?: super.getTextOffset()
    }
}