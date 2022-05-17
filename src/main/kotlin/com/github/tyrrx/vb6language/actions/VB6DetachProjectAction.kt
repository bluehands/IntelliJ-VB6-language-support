package com.github.tyrrx.vb6language.actions

import com.github.tyrrx.vb6language.project.VB6Project
import com.github.tyrrx.vb6language.project.VB6WorkspaceService
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.components.service
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.openapi.ui.popup.PopupStep
import com.intellij.openapi.ui.popup.util.BaseListPopupStep

class VB6DetachProjectAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        saveAllDocuments()
        val workspaceService = project.service<VB6WorkspaceService>()
        val values = workspaceService.projects.values.toList()
        val detachList = DetachList(values) {
            workspaceService.detachVB6Project(it)
        }
        val chooserBuilder = JBPopupFactory.getInstance().createListPopup(detachList)
        chooserBuilder.showCenteredInCurrentWindow(project)
    }
}

class DetachList(values: List<VB6Project>, val onChosen: (VB6Project) -> Unit) : BaseListPopupStep<VB6Project>("Detach projects", values) {

    override fun getTextFor(value: VB6Project): String {
        return value.myVirtualFile.name
    }

    override fun onChosen(selectedValue: VB6Project, finalChoice: Boolean): PopupStep<*>? {
        onChosen(selectedValue)
        return super.onChosen(selectedValue, finalChoice)
    }
}
