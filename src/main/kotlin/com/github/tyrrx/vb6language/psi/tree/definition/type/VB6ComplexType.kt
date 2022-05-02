package com.github.tyrrx.vb6language.psi.tree.definition.type

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.inference.InferenceResult
import com.github.tyrrx.vb6language.psi.declarations.VB6TypeDeclaration
import com.github.tyrrx.vb6language.psi.inference.VB6TypeInferable
import com.github.tyrrx.vb6language.psi.reference.VB6MemberReferenceChain
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByTypeOf
import com.github.tyrrx.vb6language.psi.utils.findChildElementsByTypeOf
import com.intellij.lang.ASTNode

interface VB6ComplexType : VB6TypeElement, VB6MemberReferenceChain, VB6TypeInferable {
    val identifiers: List<VB6Identifier>
}

class VB6ComplexTypeImpl(node: ASTNode) : VB6PsiNode(node),
        VB6ComplexType {

    object Factory : IPsiNodeFactory<VB6ComplexType> {
        override fun createPsiNode(node: ASTNode): VB6ComplexType {
            return VB6ComplexTypeImpl(node)
        }
    }

    override val identifiers: List<VB6Identifier>
        get() = findChildElementsByTypeOf(this)

    override val referenceOwners: List<VB6ReferenceOwner>
        get() = listOfNotNull(findFirstChildByTypeOf<VB6FirstComplexTypeElement>(this)) +
                findChildElementsByTypeOf<VB6FollowingComplexTypeElement>(this)
    override fun inferType(): InferenceResult {
        return when (val resolveTarget = referenceOwners.lastOrNull()?.reference?.resolve()) {
            is VB6TypeDeclaration -> InferenceResult.UserDefinedType(resolveTarget)
            is VB6TypeInferable -> resolveTarget.inferType()
            else -> InferenceResult.Unknown(null)
        }
    }

}