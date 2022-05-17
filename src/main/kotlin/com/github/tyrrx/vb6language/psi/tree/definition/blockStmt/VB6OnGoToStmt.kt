package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceFactory
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.reference.references.LineLabelReference
import com.github.tyrrx.vb6language.psi.reference.references.VB6Reference
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findFirstParentOfType
import com.intellij.lang.ASTNode

interface VB6OnGoToStmt : VB6PsiElement {

}

class VB6OnGoToStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6OnGoToStmt {

    object Factory : IPsiNodeFactory<VB6OnGoToStmt> {
        override fun createPsiNode(node: ASTNode): VB6OnGoToStmt {
            return VB6OnGoToStmtImpl(node)
        }
    }


}