package com.github.tyrrx.vb6language.psi.tree.definition.type

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.utils.findIdentifierOwnerRecursive
import com.github.tyrrx.vb6language.psi.tree.utils.findReferenceOwnerRecursive
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6BaseType: VB6Type, VB6NamedElement {

}

class VB6BaseTypeImpl(node: ASTNode) : VB6PsiNode(node), VB6BaseType {

    object Factory : IPsiNodeFactory<VB6BaseType> {
        override fun createPsiNode(node: ASTNode): VB6BaseType {
            return VB6BaseTypeImpl(node)
        }
    }

    override fun setName(name: String): PsiElement {
        return this // todo not allowed
    }

    override val referenceOwner: VB6ReferenceOwner?
        get() = findReferenceOwnerRecursive(parent)

    override val namedElementOwner: VB6NamedElementOwner?
        get() = findIdentifierOwnerRecursive(parent)
}