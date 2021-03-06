package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.declarations.VB6ConstantDeclaration
import com.github.tyrrx.vb6language.psi.inference.InferenceResult
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByTypeOf
import com.github.tyrrx.vb6language.psi.visitor.NamedElementOwnerVisitor
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6EnumerationConstant : VB6ConstantDeclaration {
    val ofEnum: VB6EnumerationStmt?
}

class VB6EnumerationConstantImpl(node: ASTNode) : VB6PsiNode(node), VB6EnumerationConstant {

    override val ofEnum: VB6EnumerationStmt?
        get() = parent as? VB6EnumerationStmt

    override fun <TReturn> accept(namedElementOwnerVisitor: NamedElementOwnerVisitor<TReturn>): TReturn {
        return namedElementOwnerVisitor.visitEnumerationConstant(this)
    }

    override fun getNameIdentifier(): VB6NamedElement? {
        return findFirstChildByTypeOf(this)
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

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = listOf(this)

    override fun inferType(): InferenceResult {
        return InferenceResult.BaseType("Long")
    }

    object Factory : IPsiNodeFactory<VB6EnumerationConstant> {
        override fun createPsiNode(node: ASTNode): VB6EnumerationConstant {
            return VB6EnumerationConstantImpl(node)
        }
    }
}
