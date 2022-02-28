package com.github.tyrrx.vb6language.psi.tree.nodes

import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.findIdentifierInSubtree
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

// Todo is the ScopeNode interface necessary?
class DeclareDefinition(node: ASTNode) : VB6PsiNode(node), PsiNameIdentifierOwner {
	override fun setName(name: String): PsiElement {
		TODO("Not yet implemented")
	}

	override fun getName(): String? {
		return this.nameIdentifier?.text
	}

	override fun getNameIdentifier(): PsiElement? {
		return this.findIdentifierInSubtree()
	}

	object Factory : IPsiNodeFactory<DeclareDefinition> {
		override fun createPsiNode(node: ASTNode): DeclareDefinition {
			return DeclareDefinition(node)
		}
	}
}