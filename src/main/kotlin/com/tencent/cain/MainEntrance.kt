package com.tencent.cain

import com.tencent.cain.person.Person
import java.util.*

fun main(args: Array<String>) {
    val txt = """
        |天上白玉京，
        |十二楼五城。
        |仙人抚我顶，
        |结发受长生。
        """.trimMargin()
    println(txt)
    val s1 = "2.34"
    val d: Double = s1.toDouble()
    println("d:${d}")

    val str = "fkjava.org"
    println("str首字母大写后输出：${str.capitalize()}")
    println("str首字母小写后输出：${str.decapitalize()}")

    var str2 = "crazyit.org"
    println("返回两个字符串相同的前缀：${str2.commonPrefixWith("crazyjava.org")}")
    println("返回两个字符串相同的后缀：${str2.commonSuffixWith("fkit.org")}")

    val books = arrayOf("Swift", "Kotlin", "C", "C++")
    for (index in 0 until books.size) {
        println("第${index + 1}种语言是：${books[index]}")
    }

    val age = Random().nextInt(80)
    println(age)
    var result = when (age) {
        in 10..25 -> "当时年少青衫薄"
        in 26..50 -> "风景依稀似去年"
        in 51..80 -> "醉听清吟胜管弦"
        else -> "其他"
    }
    println(result)

    var arr4 = Array(5, { (it * 2 + 97).toChar() })
    var arr5 = Array(6, { "fkit" })

    for (item in arr4)
        println("item：${item}")
    for (item in arr5)
        println("item：${item}")

    var booksTest = arrayOf("Java企业级应用", "疯狂Java讲义", "疯狂Android讲义")
    for ((index, value) in booksTest.withIndex())
        println("索引为${index}的元素是：${value}")

    var booksSet = setOf("疯狂Android讲义", "疯狂Java讲义", "疯狂Kotlin讲义")
    booksSet.forEach({ println(it) })

    val mapVar = sortedMapOf("Java" to 86, "Kotlin" to 92, "Go" to 71)
    println(mapVar)
    for (en in mapVar.entries) {
        println("${en.key} -> ${en.value}")
    }
    for ((key, value) in mapVar) {
        println("${key} -> ${value}")
    }
    mapVar.forEach({ println("${it.key} -> ${it.value}") })

    println("fn(10)的结果是：${fn(10)}")

    var myFun: (Int, Int) -> Int
    myFun = ::pow
    println("myFun(3,4) = ${myFun.invoke(3, 4)}")

    println("------访问Person属性------")
    var person = Person()
    person.name = "姜瑜"
    person.age = 28
    println("person name : ${person.name} ,age : ${person.age}")

    val rectangle = Rectangle(23,23)
    println("this is square：${rectangle.isSquare}")
}

fun fn(n: Int): Int {
    if (n == 0) {
        return 1
    } else if (n == 1) {
        return 4
    } else {
        return 2 * fn(n - 1) + fn(n - 2)
    }
}

fun pow(base: Int, exponent: Int): Int {
    var result = 1
    for (i in 1..exponent) {
        result *= base
    }
    return result
}