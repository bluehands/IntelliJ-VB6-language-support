package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces

import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base.VB6PropertyStatement
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base.VB6ReturnsType
import com.github.tyrrx.vb6language.psi.tree.nodes.mixins.VB6GetTypeHintFromChildrenMixin

interface VB6PropertyGetStatement :
    VB6PropertyStatement,
    VB6ReturnsType,
    VB6GetTypeHintFromChildrenMixin {
}