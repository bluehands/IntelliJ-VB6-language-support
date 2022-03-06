package com.github.tyrrx.vb6language

import com.github.tyrrx.vb6language.parser.VisualBasic6Parser
import com.github.tyrrx.vb6language.psi.language.VB6IElementTypes
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree
import org.jetbrains.annotations.NotNull

class VB6ParserAdaptor(@NotNull parser: VisualBasic6Parser) :
    ANTLRParserAdaptor(VB6Language.INSTANCE, parser) {
    override fun parse(parser: Parser?, root: IElementType?): ParseTree {

        val vbParser = parser as VisualBasic6Parser
        // Todo change
        return when(root) {
            is IFileElementType -> vbParser.startRule()
            VB6IElementTypes.rules[VisualBasic6Parser.RULE_ambiguousIdentifier] -> vbParser.ambiguousIdentifier()
            else -> TODO("Not implemented")
        }
    }
}