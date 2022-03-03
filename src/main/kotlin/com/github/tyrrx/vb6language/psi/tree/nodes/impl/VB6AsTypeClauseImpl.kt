package com.github.tyrrx.vb6language.psi.tree.nodes.impl


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.VB6IElementTypes
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6FieldLength
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6TypeRule
import com.github.tyrrx.vb6language.psi.tree.nodes.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.nodes.utils.isIElementTypePresentInChildren
import com.intellij.lang.ASTNode

class VB6AsTypeClauseImpl(node: ASTNode) : VB6PsiNode(node), VB6AsTypeClause {

    object Factory : IPsiNodeFactory<VB6AsTypeClause> {
        override fun createPsiNode(node: ASTNode): VB6AsTypeClause {
            return VB6AsTypeClauseImpl(node)
        }
    }

    override fun isAutoInitialized(): Boolean {
        return VB6IElementTypes.NEW.isIElementTypePresentInChildren(this)
    }

    override fun getFieldLength(): VB6FieldLength? {
        return findFirstChildByType(this)
    }

    override fun getType(): VB6TypeRule {
       return findFirstChildByType(this)!!
    }
}