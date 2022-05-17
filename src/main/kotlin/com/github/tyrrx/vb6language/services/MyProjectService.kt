package com.github.tyrrx.vb6language.services

import com.github.tyrrx.vb6language.MyBundle
import com.github.tyrrx.vb6language.language.VB6Language
import com.github.tyrrx.vb6language.parser.VisualBasic6Parser
import com.intellij.openapi.project.Project
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
        PSIElementTypeFactory.defineLanguageIElementTypes(
            VB6Language.INSTANCE,
            VisualBasic6Parser.tokenNames,
            VisualBasic6Parser.ruleNames
        )
    }
}
