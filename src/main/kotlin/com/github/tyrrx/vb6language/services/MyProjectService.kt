package com.github.tyrrx.vb6language.services

import com.intellij.openapi.project.Project
import com.github.tyrrx.vb6language.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
