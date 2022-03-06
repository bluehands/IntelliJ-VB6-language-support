package com.github.tyrrx.vb6language.psi.tree.interfaces.module

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6ArgumentOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6BlockScope
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6ReturnsType
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6GetTypeHintFromChildrenMixin
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6IsStaticInChildrenMixin
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6GetVisibilityFromChildrenMixin

interface VB6FunctionStatement :
    VB6BlockScope,
    VB6IdentifierOwner,
    VB6ArgumentOwner,
    VB6ReturnsType,
    VB6GetVisibilityFromChildrenMixin,
    VB6IsStaticInChildrenMixin,
    VB6GetTypeHintFromChildrenMixin {

}