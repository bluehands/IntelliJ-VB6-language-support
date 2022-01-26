package com.github.tyrrx.vb6language

import com.github.tyrrx.vb6language.parser.VisualBasic6Lexer
import com.github.tyrrx.vb6language.parser.VisualBasic6Parser
import com.github.tyrrx.vb6language.psi.VisualBasic6ClassPsiFileRoot
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.lexer.TokenIElementType
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

class VisualBasic6ParserDefinition : ParserDefinition {

    companion object {
        init {
            PSIElementTypeFactory.defineLanguageIElementTypes(
                VisualBasic6Language.INSTANCE,
                VisualBasic6Lexer.tokenNames,
                VisualBasic6Lexer.ruleNames
            )
        }

        val tokens: List<TokenIElementType> = PSIElementTypeFactory.getTokenIElementTypes(VisualBasic6Language.INSTANCE)
        val rules: List<RuleIElementType> = PSIElementTypeFactory.getRuleIElementTypes(VisualBasic6Language.INSTANCE)

        val FILE = IFileElementType(VisualBasic6Language.INSTANCE)

        val COMMENTS = PSIElementTypeFactory.createTokenSet(
            VisualBasic6Language.INSTANCE,
            VisualBasic6Lexer.COMMENT
        )!!

        val STRING = PSIElementTypeFactory.createTokenSet(
            VisualBasic6Language.INSTANCE,
            VisualBasic6Lexer.STRINGLITERAL
        )!!
    }

    override fun createLexer(project: Project?): Lexer {
        val lexer = VisualBasic6Lexer(null)
        return ANTLRLexerAdaptor(VisualBasic6Language.INSTANCE, lexer)
    }

    override fun createParser(project: Project?): PsiParser {
        val parser = VisualBasic6Parser(null)
        return VisualBasic6ParserAdaptor(parser)
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun getCommentTokens(): TokenSet {
        return COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        return STRING
    }

    override fun createElement(node: ASTNode): PsiElement {
        val elType = node.elementType
        if (elType is TokenIElementType) {
            return ANTLRPsiNode(node)
        }
        if (elType !is RuleIElementType) {
            return ANTLRPsiNode(node)
        }
        return ANTLRPsiNode(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return VisualBasic6ClassPsiFileRoot(viewProvider)
    }
}