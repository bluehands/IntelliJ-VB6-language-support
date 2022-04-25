package com.github.tyrrx.vb6language.formatting

import com.github.tyrrx.vb6language.language.VB6IElementTypes
import com.github.tyrrx.vb6language.language.VB6Language
import com.github.tyrrx.vb6language.language.VB6TokenSets
import com.github.tyrrx.vb6language.parser.VisualBasic6Lexer
import com.github.tyrrx.vb6language.parser.VisualBasic6Parser
import com.intellij.formatting.SpacingBuilder
import com.intellij.psi.codeStyle.CodeStyleSettings

fun createSpacingBuilder(codeStyleSettings: CodeStyleSettings): SpacingBuilder {
    val commonSettings = codeStyleSettings.getCommonSettings(VB6Language.INSTANCE.id)
    return SpacingBuilder(codeStyleSettings, VB6Language.INSTANCE)
        .around(VB6TokenSets.binaryOperators)
        .spaceIf(true)
        .betweenInside(
            VB6IElementTypes.rules[VisualBasic6Parser.RULE_blockStmt],
            VB6IElementTypes.rules[VisualBasic6Parser.RULE_blockStmt],
            VB6IElementTypes.rules[VisualBasic6Parser.RULE_block]
        ).spacing(0, 0, 1, true, 2)
//        .after(VB6IElementTypes.tokens[VisualBasic6Lexer.COMMA])
//        .spaceIf(commonSettings.SPACE_AFTER_COMMA)
//        .before(VB6IElementTypes.tokens[VisualBasic6Lexer.COMMA])
//        .spaceIf(commonSettings.SPACE_BEFORE_COMMA)
//        .before(VB6IElementTypes.rules[VisualBasic6Parser.RULE_asTypeClause])
//        .spaceIf(true)
//        .between(VB6TokenSets.keywords, VB6TokenSets.keywords)
//        .spaceIf(true)


}
