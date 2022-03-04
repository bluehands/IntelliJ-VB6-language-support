package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6AmbiguousIdentifier
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6Visibility
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6VisibilityEnum
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6ConstSubStmt
import com.github.tyrrx.vb6language.psi.tree.nodes.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

class VB6ConstSubStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6ConstSubStmt {

    object Factory : IPsiNodeFactory<VB6ConstSubStmt> {
        override fun createPsiNode(node: ASTNode): VB6ConstSubStmt {
            return VB6ConstSubStmtImpl(node)
        }
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun getNameIdentifier(): VB6AmbiguousIdentifier? {
        return findFirstChildByType(this)
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getVisibility(): VB6VisibilityEnum {
        return PsiTreeUtil.getPrevSiblingOfType(this, VB6Visibility::class.java)
            ?.getEnumValue() ?: VB6VisibilityEnum.PUBLIC
    }

    override fun getAsTypeClause(): VB6AsTypeClause? {
        return findFirstChildByType(this)
    }
}