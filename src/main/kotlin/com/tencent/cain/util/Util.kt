@file:JvmName("Utils")

package com.tencent.cain.util

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

/**
 * String类的扩展函数
 */
fun String.lastChar(size: Int): Char {
    println("size of str: ${size}")
    return this.get(this.length - 1)
}