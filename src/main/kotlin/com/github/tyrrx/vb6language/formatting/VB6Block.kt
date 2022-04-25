package com.github.tyrrx.vb6language.formatting

import com.github.tyrrx.vb6language.language.VB6IElementTypes
import com.github.tyrrx.vb6language.parser.VisualBasic6Parser
import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType
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
            if (childAstNode.isNotBlockWrapped()) return@mapNotNull null
            VB6Block(spacingBuilder, childAstNode, null, null)
        }
    }

    override fun getIndent(): Indent? {
        return when (myNode.elementType) {
            VB6IElementTypes.rules[VisualBasic6Parser.RULE_blockStmt] -> Indent.getNormalIndent()
            VB6IElementTypes.rules[VisualBasic6Parser.RULE_moduleConfigElement] -> Indent.getNormalIndent()
            VB6IElementTypes.rules[VisualBasic6Parser.RULE_enumerationConstant] -> Indent.getNormalIndent()
            VB6IElementTypes.rules[VisualBasic6Parser.RULE_typeStmtMember] -> Indent.getNormalIndent()
            else -> Indent.getNoneIndent()
        }
    }

    override fun getChildIndent(): Indent? {
        return Indent.getNormalIndent()
    }
}

private fun ASTNode.isNotBlockWrapped(): Boolean {
    if (this.textLength == 0) return true
    return when (this.elementType) {
        TokenType.WHITE_SPACE -> {
            return !this.textContains('_')
        }
        VB6IElementTypes.rules[VisualBasic6Parser.RULE_endOfLine] -> {
            val noComment = this.findChildByType(VB6IElementTypes.tokens[VisualBasic6Parser.COMMENT]) == null
            val noRemComment = this.findChildByType(VB6IElementTypes.tokens[VisualBasic6Parser.REMCOMMENT]) == null
            return noComment && noRemComment
        }
        VB6IElementTypes.rules[VisualBasic6Parser.RULE_endOfStatement] -> {
            return this.getChildren(null)
                    .map {
                        if (it.elementType == VB6IElementTypes.rules[VisualBasic6Parser.RULE_endOfLine]) {
                            it.isNotBlockWrapped()
                        } else {
                            false
                        }
                    }.fold(true) { acc, b -> acc && b }
        }
        else -> false
    }
}