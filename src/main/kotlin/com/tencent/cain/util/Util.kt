@file:JvmName("Utils")

package com.tencent.cain.util

import com.tencent.cain.Child
import com.tencent.cain.Parent
import com.tencent.cain.Point
import com.tencent.cain.data.Os
import com.tencent.cain.data.SiteVisit
import com.tencent.cain.java.CommentItem
import com.tencent.cain.user.ObjectPerson
import java.time.LocalDate

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

fun ObjectPerson.Companion.transformJson(json: String): ObjectPerson {
    return ObjectPerson(json)
}

const val GIFT = 1004

fun String.transForm() {
    println("替换后的结果：$this")
    val result = this.replace("{0}", "姜瑜")
    println("替换前的结果：$result")
}

/**
 * 查询字符串中，包含某个字符的个数
 */
fun String.getSpecialStrCount(specialStr: String) = this.count {
    it.toString().equals(specialStr)
}

fun transFormation(source: String) {
    println("替换后的结果：$source")
    source.replaceFirst("某某", "姜瑜")
    println("替换前的结果：$source")
}

fun String.el(limit: Int): String {
    var result: String = this
    if (this.length > limit) {
        result = this.substring(0, limit) + "..."
    }
    return result
}

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
        object : Iterator<LocalDate> {
            var current = start
            /**
             * Returns `true` if the iteration has more elements.
             */
            override fun hasNext(): Boolean = current <= endInclusive

            /**
             * Returns the next element in the iteration.
             */
            override fun next(): LocalDate = current.apply {
                current = plusDays(1)
            }

        }

//fun List<SiteVisit>.averageDurationFor(os: Os) = filter { it.os == os }.map(SiteVisit::duration).average()
fun List<SiteVisit>.averageDurationFor(predicate:(SiteVisit) -> Boolean) =
        filter(predicate).map(SiteVisit::duration).average()

/**
 * 评论去重,根据评论CommentItem中的commentId来判断是否重复
 * @param comments 待去重的屏幕列表
 *
 */
fun deduplicateComments(comments: MutableList<CommentItem>): List<CommentItem> {
    val tempCommentsSet: MutableSet<CommentItem> = mutableSetOf()
    comments.forEach {
        tempCommentsSet.add(it)
    }
    return tempCommentsSet.distinct()
}

