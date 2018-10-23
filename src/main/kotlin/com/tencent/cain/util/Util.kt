@file:JvmName("Utils")

package com.tencent.cain.util

import com.tencent.cain.Child
import com.tencent.cain.Parent

@JvmOverloads
fun <T> joinToString(collection: Collection<T>, separator: String = ", ", prefix: String = "", postfix: String = ""): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

@JvmOverloads
fun <T> Collection<T>.join2Str(separator: String = ", ", prefix: String = "", postfix: String = ""): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun Parent.showOff() = println("I'm Parent!")

fun Child.showOff() = println("I'm child!")

// 扩展属性
var StringBuilder.lastChar: Char
    get() = this.get(this.length - 1)
    set(value: Char) {
        this.setCharAt(this.length - 1, value)
    }

/**
 * String类的扩展函数
 */
fun String.lastChar(size: Int): Char {
    println("size of str: ${size}")
    return this.get(this.length - 1)
}