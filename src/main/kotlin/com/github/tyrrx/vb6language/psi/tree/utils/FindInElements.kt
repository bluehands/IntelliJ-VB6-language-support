package com.github.tyrrx.vb6language.psi.tree.utils

import com.github.tyrrx.vb6language.psi.tree.definition.module.VB6Module

inline fun <reified TStatement> VB6Module.getModuleBodyStatementsByType() : List<TStatement> {
    return getModuleBody()
        ?.getStatements()
        ?.filterIsInstance<TStatement>() ?: emptyList()
}