package com.github.tyrrx.vb6language

import com.github.tyrrx.vb6language.parser.VisualBasic6Parser
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree
import org.jetbrains.annotations.NotNull

class VisualBasic6ParserAdaptor(@NotNull parser: VisualBasic6Parser) :
    ANTLRParserAdaptor(VisualBasic6Language.INSTANCE, parser) {
    override fun parse(parser: Parser?, root: IElementType?): ParseTree {
        if (root is IFileElementType) {
            return (parser as VisualBasic6Parser).startRule()
        }
        // Todo change
        TODO("Not implemented")
    }
}