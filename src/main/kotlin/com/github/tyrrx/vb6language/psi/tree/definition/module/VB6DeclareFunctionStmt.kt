package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.language.VB6IElementTypes
import com.github.tyrrx.vb6language.psi.declarations.VB6FunctionDeclaration
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.mixins.VB6VisibilityOwnerMixin
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Argument
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6ArgumentList
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.utils.isIElementTypePresentInChildren
import com.github.tyrrx.vb6language.psi.visitor.NamedElementOwnerVisitor
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6DeclareFunctionStmt :
        VB6FunctionDeclaration,
        VB6VisibilityOwnerMixin {
    val lib: VB6DeclareLib?
    val alias: VB6DeclareAlias?
    val function: VB6DeclareFunction?
    val isPtrSafe: Boolean
}

class VB6DeclareFunctionStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6DeclareFunctionStmt {

    object Factory : IPsiNodeFactory<VB6DeclareFunctionStmt> {
        override fun createPsiNode(node: ASTNode): VB6DeclareFunctionStmt {
            return VB6DeclareFunctionStmtImpl(node)
        }
    }

    override fun getNameIdentifier(): VB6NamedElement? {
        return findFirstChildByType(this)
    }


    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun setName(name: String): PsiElement {
        nameIdentifier?.setName(name)
        return this
    }

    override val typeClause: VB6AsTypeClause? = findFirstChildByType(this)

    override val arguments: List<VB6Argument>
        get() = findFirstChildByType<VB6ArgumentList>(this)?.arguments() ?: emptyList()

    override val isDefinition: Boolean
        get() = true

    override val lib: VB6DeclareLib?
        get() = findFirstChildByType(this)

    override val alias: VB6DeclareAlias?
        get() = findFirstChildByType(this)

    override val function: VB6DeclareFunction?
        get() = findFirstChildByType(this)

    override val isPtrSafe: Boolean
        get() = VB6IElementTypes.PTRSAFE.isIElementTypePresentInChildren(this)

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = listOf(this)

    override fun getTextOffset(): Int {
        return nameIdentifier?.textOffset ?: super.getTextOffset()
    }

    override fun <TReturn> accept(namedElementOwnerVisitor: NamedElementOwnerVisitor<TReturn>): TReturn {
        return namedElementOwnerVisitor.visitDeclareFunctionStmt(this)
    }
}