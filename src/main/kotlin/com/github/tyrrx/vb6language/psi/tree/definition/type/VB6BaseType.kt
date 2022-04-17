package com.github.tyrrx.vb6language.psi.tree.definition.type

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.language.VB6IElementTypes
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findIdentifierOwnerRecursive
import com.github.tyrrx.vb6language.psi.utils.findReferenceOwnerRecursive
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType

interface VB6BaseType: VB6TypeElement, VB6NamedElement {

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

    override fun getName(): String? {
        return firstChild?.text
    }

    override val referenceOwner: VB6ReferenceOwner?
        get() = findReferenceOwnerRecursive(parent)

    override val namedElementOwner: VB6NamedElementOwner?
        get() = findIdentifierOwnerRecursive(parent)
}