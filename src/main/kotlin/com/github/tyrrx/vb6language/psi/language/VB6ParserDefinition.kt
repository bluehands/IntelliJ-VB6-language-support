package com.github.tyrrx.vb6language.psi.language

import com.github.tyrrx.vb6language.parser.VisualBasic6Lexer
import com.github.tyrrx.vb6language.parser.VisualBasic6Parser
import com.github.tyrrx.vb6language.psi.tree.definition.VB6FileImpl
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

class VB6ParserDefinition : ParserDefinition {

    companion object {
        init {
            PSIElementTypeFactory.defineLanguageIElementTypes(
                VB6Language.INSTANCE,
                VisualBasic6Parser.tokenNames,
                VisualBasic6Parser.ruleNames
            )
        }
    }

    override fun createLexer(project: Project?): Lexer {
        val lexer = VisualBasic6Lexer(null)
        return ANTLRLexerAdaptor(VB6Language.INSTANCE, lexer)
    }

    override fun createParser(project: Project?): PsiParser {
        val parser = VisualBasic6Parser(null)
        return VB6ParserAdaptor(parser)
    }

    override fun getFileNodeType(): IFileElementType {
        return VB6IElementTypes.file
    }

    override fun getCommentTokens(): TokenSet {
        return VB6TokenSets.comments
    }

    override fun getStringLiteralElements(): TokenSet {
        return VB6TokenSets.stringLiterals
    }

    override fun createElement(node: ASTNode): PsiElement {
        return PSIFactory.createElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return VB6FileImpl(viewProvider)
    }
}