package com.github.tyrrx.vb6language.project

sealed interface VBPValue {
    val key: String

    data class Object(override val key: String) : VBPValue
    data class Class(override val key: String, val name: String, val path: String) : VBPValue
    data class Module(override val key: String, val name: String, val path: String) : VBPValue
    data class Form(override val key: String, val path: String) : VBPValue
    data class Title(override val key: String, val title: String) : VBPValue
    data class ExeName32(override val key: String, val name: String) : VBPValue
    data class Command32(override val key: String, val name: String) : VBPValue
    data class Name(override val key: String, val name: String) : VBPValue
    data class Description(override val key: String, val text: String) : VBPValue
    data class Unknown(override val key: String, val value: String) : VBPValue
}

val Iterable<VBPFileContext>.defaultContext get() = this.firstOrNull { it is VBPFileContext.Default }
val Iterable<VBPFileContext>.standardModules get() = this.defaultContext?.values?.filterIsInstance<VBPValue.Module>()
val Iterable<VBPFileContext>.classes get() = this.defaultContext?.values?.filterIsInstance<VBPValue.Class>()
val Iterable<VBPFileContext>.name get() = this.defaultContext?.values?.filterIsInstance<VBPValue.Name>()?.firstOrNull()