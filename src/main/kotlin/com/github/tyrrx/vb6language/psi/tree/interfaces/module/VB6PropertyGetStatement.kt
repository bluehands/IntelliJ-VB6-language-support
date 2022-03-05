package com.github.tyrrx.vb6language.psi.tree.interfaces.module

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PropertyStatement
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6ReturnsType
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6GetTypeHintFromChildrenMixin

interface VB6PropertyGetStatement :
    VB6PropertyStatement,
    VB6ReturnsType,
    VB6GetTypeHintFromChildrenMixin {
}