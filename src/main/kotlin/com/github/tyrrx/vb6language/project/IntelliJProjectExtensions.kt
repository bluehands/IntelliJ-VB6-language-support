package com.github.tyrrx.vb6language.project

import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project

val Project.vb6Workspace get() = service<VB6WorkspaceService>()