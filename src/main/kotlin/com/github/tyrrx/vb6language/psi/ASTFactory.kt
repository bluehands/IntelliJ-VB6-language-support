package com.github.tyrrx.vb6language.psi

import com.github.tyrrx.vb6language.psi.tree.leafes.IdentifierPsiLeaf
import com.intellij.lang.DefaultASTFactoryImpl
import com.intellij.openapi.diagnostic.Logger
import com.intellij.psi.impl.source.tree.LeafElement
import com.intellij.psi.impl.source.tree.PsiWhiteSpaceImpl
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet

class ASTFactory : DefaultASTFactoryImpl() {

    private val logger = Logger.getInstance(ASTFactory::class.java)

    private val factoriesMap = mergeAll(
        VB6TokenSets.identifiers mapsTo IdentifierPsiLeaf.Factory,
        VB6TokenSets.whitespaces mapsTo object : ILeafFactory {
            override fun createLeaf(type: IElementType, text: CharSequence): LeafElement {
                return PsiWhiteSpaceImpl(text)
            }
        }
    )

    override fun createLeaf(type: IElementType, text: CharSequence): LeafElement {
        return if (factoriesMap.containsKey(type)) {
            factoriesMap[type]?.createLeaf(type, text)!!
        } else {
            super.createLeaf(type, text)
        }
    }

    private fun mergeAll(vararg maps: Map<IElementType, ILeafFactory>): HashMap<IElementType, ILeafFactory> {
        val resultHashMap = HashMap<IElementType, ILeafFactory>()
        maps
            .flatMap { it.entries }
            .forEach {
                if (!resultHashMap.containsKey(it.key)) {
                    resultHashMap[it.key] = it.value
                } else {
                    logger.error(
                        "Duplicate usage of IElementType ${it.key.debugName} " +
                                "as key for value ${it.value.javaClass.simpleName} " +
                                "and value ${resultHashMap[it.key]?.javaClass?.simpleName}"
                    )
                }
            }
        return resultHashMap
    }
}

private infix fun TokenSet.mapsTo(that: ILeafFactory): Map<IElementType, ILeafFactory> {
    return this.types.associateWith { that }
}

