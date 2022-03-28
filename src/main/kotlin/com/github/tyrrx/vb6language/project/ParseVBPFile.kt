package com.github.tyrrx.vb6language.project

import com.intellij.openapi.vfs.VirtualFile
import java.util.*
import java.util.stream.Collectors

fun parseVbpFile(file: VirtualFile): List<VBPFileContext> {
    return VBPParser(file).parse()
}

private class VBPParser(virtualFile: VirtualFile) {

    private val lines = virtualFile.inputStream.bufferedReader().lines().collect(Collectors.toList())
    private val context = Stack<VBPFileContext>()

    fun parse(): List<VBPFileContext> {
        context.clear()
        context.push(VBPFileContext.Default())
        lines.forEach {
            when {
                it.startsWith("[") -> context.push(parseTagLine(it))
                it.isEmpty() -> Unit
                else -> parseKeyValueLine(it, context.peek())
            }
        }
        return context.toList()
    }

    private fun parseTagLine(line: String): VBPFileContext {
        return VBPFileContext.Tag(line.trim { c -> c == '[' || c == ']' })
    }

    private fun parseKeyValueLine(line: String, context: VBPFileContext) {
        val keyValueList = line.split("=", limit = 2)
        context.addToContext(parseValue(keyValueList[0].trim(), keyValueList[1]))
    }

    private fun parseValue(key: String, value: String): VBPValue {
        return when {
            //key.startsWith("Reference") -> parseReference(value)
            key.startsWith("Object") -> parseObject(key, value)
            key.startsWith("Class") -> parseClass(key, value)
            key.startsWith("Module") -> parseModule(key, value)
            key.startsWith("Form") -> parseForm(key, value)

            key.startsWith("Title") -> parseTitle(key, value)
            key.startsWith("ExeName32") -> parseExeName32(key, value)
            key.startsWith("Command32") -> parseCommand32(key, value)
            key.startsWith("Name") -> parseName(key, value)
            key.startsWith("Description") -> parseDescription(key, value)
            else -> parseUnknown(key, value)
        }
    }

    private fun parseForm(key: String, value: String): VBPValue {
        return VBPValue.Form(key, value)
    }

    private fun parseUnknown(key: String, value: String): VBPValue.Unknown {
        return VBPValue.Unknown(key, value)
    }

    private fun parseDescription(key: String, value: String): VBPValue.Description {
        return VBPValue.Description(key, parseStringLiteral(value))
    }

    private fun parseName(key: String, value: String): VBPValue.Name {
        return VBPValue.Name(key, parseStringLiteral(value))
    }

    private fun parseCommand32(key: String, value: String): VBPValue.Command32 {
        return VBPValue.Command32(key, parseStringLiteral(value))
    }

    private fun parseExeName32(key: String, value: String): VBPValue.ExeName32 {
        return VBPValue.ExeName32(key, parseStringLiteral(value))
    }

    private fun parseTitle(key: String, value: String): VBPValue.Title {
        return VBPValue.Title(key, parseStringLiteral(value))
    }

    private fun parseClass(key: String, value: String): VBPValue.Class {
        val split = value.split("; ", ";", limit = 2)
        return VBPValue.Class(key, split[0], split[1])
    }

    private fun parseModule(key: String, value: String): VBPValue.Module {
        val split = value.split("; ", ";", limit = 2)
        return VBPValue.Module(key, split[0], split[1])
    }

    private fun parseObject(key: String, value: String): VBPValue.Object {
        return VBPValue.Object(key)
    }

    private fun parseStringLiteral(value: String): String {
        return value.trimStart { c -> c == '"' }.trimEnd { c -> c == '"' }
    }

}


