package com.github.tyrrx.vb6language.psi.tree.definition.base

interface VB6MemberReferenceChain : VB6PsiElement {
    /**
     * All reference owners in the complete reference chain
     */
    val referenceOwners: List<VB6ReferenceOwner>

    fun previousReferenceOwnerOf(referenceOwner: VB6ReferenceOwner): VB6ReferenceOwner? {
        val chainRoot = this.chainRoot()
        val iterator = chainRoot.referenceOwners.listIterator(chainRoot.referenceOwners.indexOf(referenceOwner))
        return if (iterator.hasPrevious()) {
            iterator.previous()
        } else {
            null
        }
    }

    fun chainRoot(): VB6MemberReferenceChain {
        return when (val myParentChain = parent) {
            is VB6MemberReferenceChain -> myParentChain.chainRoot()
            else -> this
        }
    }
}

