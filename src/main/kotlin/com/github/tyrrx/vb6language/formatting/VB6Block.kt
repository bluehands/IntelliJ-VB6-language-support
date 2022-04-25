package com.github.tyrrx.vb6language.formatting

import com.github.tyrrx.vb6language.language.VB6IElementTypes
import com.github.tyrrx.vb6language.parser.VisualBasic6Parser
import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType
import com.intellij.psi.formatter.common.AbstractBlock

class VB6Block(node: ASTNode, wrap: Wrap?, alignment: Alignment?) : AbstractBlock(node, wrap, alignment) {
    override fun getSpacing(child1: Block?, child2: Block): Spacing? {
        return null
    }

    override fun isLeaf(): Boolean {
        return myNode.firstChildNode == null
    }

    override fun buildChildren(): List<Block> {
        return myNode.getChildren(null).mapNotNull { iteratedAstNode ->
            if (iteratedAstNode.textLength == 0) {
                null
            } else {
                if (iteratedAstNode.elementType == TokenType.WHITE_SPACE) {
                    null
                } else {
                    VB6Block(iteratedAstNode, null, null)
                }
            }
        }
    }

    override fun getIndent(): Indent? {
        if (myNode.elementType == VB6IElementTypes.rules[VisualBasic6Parser.RULE_blockStmt]) {
            println("$myNode")
            return Indent.getSpaceIndent(4)
        }
        return Indent.getNoneIndent()
    }

//    override fun getChildIndent(): Indent? {
//        return Indent.getSpaceIndent(4)
//    }
}