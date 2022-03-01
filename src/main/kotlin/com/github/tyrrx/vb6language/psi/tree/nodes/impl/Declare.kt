package com.github.tyrrx.vb6language.psi.tree.nodes.impl

import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.utils.findIdentifierInSubtree
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner

// Todo is the ScopeNode interface necessary?
class Declare(node: ASTNode) : VB6PsiNode(node), PsiNameIdentifierOwner {
	override fun setName(name: String): PsiElement {
		TODO("Not yet implemented")
	}

	override fun getName(): String? {
		return this.nameIdentifier?.text
	}

	override fun getNameIdentifier(): PsiElement? {
		return this.findIdentifierInSubtree()
	}

	object Factory : IPsiNodeFactory<Declare> {
		override fun createPsiNode(node: ASTNode): Declare {
			return Declare(node)
		}
	}
}