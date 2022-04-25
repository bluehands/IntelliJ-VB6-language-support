package com.github.tyrrx.vb6language.formatting

import com.github.tyrrx.vb6language.language.VB6IElementTypes
import com.github.tyrrx.vb6language.language.VB6Language
import com.github.tyrrx.vb6language.language.VB6TokenSets
import com.github.tyrrx.vb6language.parser.VisualBasic6Parser
import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.formatter.common.AbstractBlock

class VB6Block(private val spacingBuilder: SpacingBuilder, node: ASTNode, wrap: Wrap?, alignment: Alignment?) :
    AbstractBlock(node, wrap, alignment) {

    override fun getSpacing(child1: Block?, child2: Block): Spacing? {
        return spacingBuilder.getSpacing(this, child1, child2)
    }

    override fun isLeaf(): Boolean {
        return myNode.firstChildNode == null
    }

    override fun buildChildren(): List<Block> {
        return myNode.getChildren(null).mapNotNull { childAstNode ->
            if (childAstNode.textLength == 0) return@mapNotNull null
            if (childAstNode.isNotBlockWrapped()) return@mapNotNull null
            VB6Block(spacingBuilder, childAstNode, null, null)
        }
    }

    override fun getIndent(): Indent? {
        return when (myNode.elementType) {
            VB6IElementTypes.rules[VisualBasic6Parser.RULE_blockStmt] -> Indent.getNormalIndent()
            VB6IElementTypes.rules[VisualBasic6Parser.RULE_moduleConfigElement] -> Indent.getNormalIndent()
            else -> Indent.getNoneIndent()
        }
    }

    override fun getChildIndent(): Indent? {
        return Indent.getNormalIndent()
    }
}

private fun ASTNode.isNotBlockWrapped(): Boolean {

    return when (this.elementType) {
        TokenType.WHITE_SPACE -> true
        VB6IElementTypes.rules[VisualBasic6Parser.RULE_endOfLine] -> !this.text.contains("'") && !this.text.toLowerCase().contains("rem")
        VB6IElementTypes.rules[VisualBasic6Parser.RULE_endOfStatement] -> !this.text.contains(":")
        else -> false
    }
}