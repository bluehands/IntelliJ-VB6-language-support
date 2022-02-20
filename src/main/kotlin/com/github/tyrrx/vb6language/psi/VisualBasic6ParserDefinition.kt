package com.github.tyrrx.vb6language.psi

import com.github.tyrrx.vb6language.VisualBasic6Language
import com.github.tyrrx.vb6language.VisualBasic6ParserAdaptor
import com.github.tyrrx.vb6language.parser.VisualBasic6Lexer
import com.github.tyrrx.vb6language.parser.VisualBasic6Parser
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class VisualBasic6ParserDefinition : ParserDefinition {

    companion object {


        init {
            PSIElementTypeFactory.defineLanguageIElementTypes(
                VisualBasic6Language.INSTANCE,
                VisualBasic6Parser.tokenNames,
                VisualBasic6Parser.ruleNames
            )
        }

        @JvmStatic
        val tokens: List<TokenIElementType> = PSIElementTypeFactory.getTokenIElementTypes(VisualBasic6Language.INSTANCE)

        @JvmStatic
        val rules: List<RuleIElementType> = PSIElementTypeFactory.getRuleIElementTypes(VisualBasic6Language.INSTANCE)

        @JvmStatic
        val FILE = IFileElementType(VisualBasic6Language.INSTANCE)

        val COMMENTS: TokenSet = PSIElementTypeFactory.createTokenSet(
            VisualBasic6Language.INSTANCE,
            VisualBasic6Lexer.COMMENT
        )

        val STRING: TokenSet = PSIElementTypeFactory.createTokenSet(
            VisualBasic6Language.INSTANCE,
            VisualBasic6Lexer.STRINGLITERAL
        )

        val WHITESPACES: TokenSet = PSIElementTypeFactory.createTokenSet(
            VisualBasic6Language.INSTANCE,
            VisualBasic6Lexer.WS,
            VisualBasic6Lexer.NEWLINE
        )
        val IDENTIFIER: IElementType = tokens[VisualBasic6Lexer.IDENTIFIER]

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
        return PSIFactory.createElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return VisualBasic6ClassPsiFileRoot(viewProvider)
    }
}