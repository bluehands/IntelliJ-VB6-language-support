package com.github.tyrrx.vb6language.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.openapi.ui.DialogPanel

class VB6DetachProjectAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        saveAllDocuments()

//        val descriptor = FileChooserDescriptorFactory.createSingleFileNoJarsDescriptor()
//            .withFileFilter { it.name.endsWith(".vbp") }
//            .withTitle("Select visual basic 6.0 project file")
//            .apply { isForcedToUseIdeaFileChooser = true }
//
//        val file = FileChooser.chooseFile(descriptor, project, null)
//            ?: return
//
//        if (!file.name.endsWith(".vbp")) {
//            Messages.showErrorDialog("Expected visual basic 6.0, got ${file.name}", "Invalid file type")
//            return
//        }
//
//        if (project.vb6Workspace.isAttachedVB6Project(file)) {
//            Messages.showErrorDialog("The visual basic 6.0 project ${file.name} is already attached", "Already attached project")
//            return
//        }
//        project.vb6Workspace.attachVB6Project(file)

        val x = listOf<String>("aa", "bb")
        val chooserBuilder = JBPopupFactory.getInstance().createPopupChooserBuilder(x)
        val popup = chooserBuilder.createPopup()
        popup.showCenteredInCurrentWindow(project)
    }


    private fun showError(error: Throwable) {
        ApplicationManager.getApplication().invokeLater {
            Messages.showErrorDialog(error.message, "Failed to attach visual basic 6.0 project")
        }
    }
}
