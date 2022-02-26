package com.github.tyrrx.vb6language.psi.tree.leafes

import com.github.tyrrx.vb6language.VisualBasic6Language
import com.github.tyrrx.vb6language.parser.VisualBasic6Lexer
import com.github.tyrrx.vb6language.psi.ILeafFactory
import com.github.tyrrx.vb6language.psi.VB6TokenIElementTypes
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.impl.source.tree.LeafElement
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.psi.ANTLRPsiLeafNode
import org.antlr.intellij.adaptor.psi.Trees

class IdentifierPsiLeaf(type: IElementType?, text: CharSequence?) : ANTLRPsiLeafNode(type, text), PsiNamedElement {
	override fun getName(): String {
		return text
	}

	override fun setName(name: String): PsiElement {
		// Todo valid?
		val newIdentifier = Trees.createLeafFromText(
			project,
			VisualBasic6Language.INSTANCE,
			context,
			name,
			VB6TokenIElementTypes.tokens[VisualBasic6Lexer.IDENTIFIER]
		)
		return this.replace(newIdentifier)
	}

	object Factory : ILeafFactory {
		override fun createLeaf(type: IElementType, text: CharSequence): LeafElement {
			return IdentifierPsiLeaf(type, text)
		}
	}
}