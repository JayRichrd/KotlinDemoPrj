package com.tencent.cain.main

import com.tencent.cain.*
import com.tencent.cain.Number
import com.tencent.cain.User
import com.tencent.cain.data.NameComponents
import com.tencent.cain.java.HandleComputation
import com.tencent.cain.person.Employeer
import com.tencent.cain.person.Person
import com.tencent.cain.user.*
import com.tencent.cain.util.*
import org.omg.CosNaming.NameComponent
import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener
import java.io.BufferedReader
import java.io.File
import java.io.StringReader
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.time.LocalDate
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

    println(getMnemonic(Color.BLUE))
    val color = Color.BLUE
    println(color.rgb())
    println(mix(Color.RED, Color.GREEN))

    val num = Num(1)
    val sum = Sum(Num(2), Num(4))
    println("result=${eval3(num) + eval3(sum)}")

    println()
    val number = Number(4)
    val summary = Summary(5, 6)
    println("sealed 测试：result=${eval4(number) + eval4(summary)}")

    println()
    for (i in 1..100) {
        print(fizzBuzz(i))
    }
    println()
    for (i in 100 downTo 1 step 2) {
        print(fizzBuzz(i))
    }
    println()
    for (i in 1 until 10) {
        print(fizzBuzz(i))
    }

    println()
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    for ((key, value) in binaryReps) {
        println("$key = $value")
    }

    println()
    val list = arrayListOf("10", "11", "12")
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }

    println()
    println("a is a letter: ${isLetter('a')}")

    println()
    println("Kotlin" in setOf("Kotlin", "Scala"))

    println()
    val listStr = listOf(1, 2, 3)
    println(joinToString(listStr, separator = "; ", prefix = "(", postfix = ")"))
    println(joinToString(listStr))
    println(joinToString(listStr, prefix = "(", postfix = ")"))

    println()
    println("Kotlin 的最后一个字符：${"Kotlin".lastChar("Kotlin".length)}")

    println()
    val listdemo = listOf(1, 2, 3)
    println("扩展方法：${listdemo.join2Str(prefix = "[", postfix = "]")}")

    println()
    val parent: Parent = Child()
    parent.click()

    println()
    val parent1: Parent = Child()
    parent1.showOff()

    println()
    val sb = StringBuilder("Kotlin")
    println("扩展属性，Kotlin的最后一个字符：${sb.lastChar}")
    sb.lastChar = '!'
    println("扩展属性，修改Kotlin后的最后一个字符：${sb.lastChar}")

    println()
    val arrayList = arrayOf(1, 2, 3)
    val listceshi = listOf(4, *arrayList)
    println("可变参数测试：$listceshi")

    println()
    println("12.345-6.A".split("\\.|-".toRegex()))
    println("12.345-6.A".split(".", "-"))

    println()
    parsePath("/Users/cainjiang/Downloads/log_analyzer.py")

    println()
    saveUser(User(1, "jay", "shenzhen"))

    println()
    val button = Button()
    button.click()
    button.hello()
    button.showOff()

    println()
    val privateUser = PrivateUser("jiangfengfn@163.com")
    println("privateUser:${privateUser.email}, ${privateUser.nickName}")

    val facebookUser = FacebookUser(123)
    println("facebookUser:${facebookUser.accoutId}, ${facebookUser.email}, ${facebookUser.nickName}")

    println()
    val user = com.tencent.cain.user.User("cain")
    user.address = "ShenZhen,GuangDong,China"
    println("${user.userName}'s address: ${user.address}")

    println()
    val client1 = Client("Alice", 34123)
    val client2 = Client("Alice", 34123)
    val processed = hashSetOf(Client("Alice", 34123))
    println("client1:${client1.toString()}")
    println("client1 = client2:${client1 == client2}")
    println("processed contain client1:${processed.contains(Client("Alice", 34123))}")

    println()
    val dataClient1 = DataClient("Cain", 51800)
    val dataClient2 = DataClient("Cain", 51800)
    val dataClient3 = DataClient("cain", 51800)
    val dataClient4 = dataClient1.copy("jiang", 23456)
    println("dataClient4:${dataClient4.toString()}")
    println("dataClient1:${dataClient1.toString()}")
    println("dataClient1 = dataClient2:${dataClient1 == dataClient2}, dataClient1 = dataClient3:${dataClient1 == dataClient3}")
    val process = hashSetOf(DataClient("Jiang", 12345))
    println("process contains:${process.contains(DataClient("Jiang", 12345))}")

    println()
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 1, 2))
    println("${cset.objectAdded} objects were added, ${cset.size} remain, elements: ${cset.innerSet}")

    println()
    val son = Employeer("Son", 200)
    val wife = Employeer("Ying", 7800)
    val husband = Employeer("Cain", 13000)
    Payroll.allEmployees.add(wife)
    Payroll.allEmployees.add(husband)
    Payroll.calculateSalary()
    println("family all incom will be:${Payroll.allSalaries}")

    println()
    val employees = listOf(wife, husband, son)
    println(employees.sortedWith(Employeer.EmployeerComparator))

    println()
    val subscribingUser = ObjectUser.newSubscribingUser("jiangfengfn12@126.com")
    val facebookObjectUser = ObjectUser.newFacebookUser(1179465696)
    println("subscribingUser nickName:${subscribingUser.nickName}, facebookObjectUser nickName:${facebookObjectUser.nickName}")

    println()
    val objectPerson = loadFromJson(ObjectPerson)
    println("objectPerson: ${objectPerson.name}")

    println()
    println("伴生对象扩展测试，objectPerson'name: ${ObjectPerson.transformJson("姜瑜").name}")
    GIFT

    println()
    val dataPerson = listOf(DataPerson("Alice", 29), DataPerson("Bobe", 29), DataPerson("Cain", 30))
    println(dataPerson.maxBy { it.age })

    println()
    val numLst = listOf(1, 2, 3, 4)
    println(numLst.filter { it % 2 == 0 })
    println(dataPerson.filter { it.age > 29 })
    println(numLst.map { it * it })
    println(dataPerson.map { it.name })
    println(dataPerson.filter { it.age > 29 }.map(DataPerson::name))
    println()
    println("比较枚举类型是否相等：${Color.GREEN == Color.GREEN}")
    val parent3 = Parent()
    val parent4 = Parent()
    println("比较对象是否相等：${parent3 == parent4}")

    println()
    val coutStr = "某某某{0},获得了{1}张{2}"
    println(coutStr.count {
        println("当前字符：$it, 与某是否相等：${it.toString().equals("某")}")
        it.toString().equals("")
    })

    val mapDemo = mapOf(0 to "zero", 1 to "one")
    println(mapDemo.mapValues { it.value.toUpperCase() })
    println()
    val hashmap = hashMapOf("0_t" to "1")
    val requiredType: Int = hashmap["t"]?.let {
        return@let Integer.parseInt(it)
    } ?: 0
    println("解析的结果是：$requiredType")

    println()
    val canBeInClu28 = { p: DataPerson -> p.age < 28 }
    println(dataPerson.all(canBeInClu28))
    println(dataPerson.any(canBeInClu28))
    println(dataPerson.count(canBeInClu28))
    println(dataPerson.find(canBeInClu28))

    println()
    println(dataPerson.groupBy { it.age }.filterKeys { it == 29 })

    println()
    val strings = listOf("abc", "bcd", "cde")
    println(strings.flatMap { it.toList() }.toSet())

    println()
    println(dataPerson.asSequence().map(DataPerson::name).filter { it.startsWith("A") }.toList())

    println()
    listOf(1, 2, 3, 4).asSequence().map { println("map($it)"); it * it }.filter { println("filter($it)");it % 2 == 0 }.toList()

    println()
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())

    val file = File("/Users/jiangyu/package-lock.json")
    println(file.isInsideHiddenDirectory())

    println()
    val handleComputation = HandleComputation()
    handleComputation.postponeComputation(1000) { println("handleComputation") }
    handleComputation.postponeComputation(100, object : Runnable {
        override fun run() {
            println("file:${file.absolutePath}")
        }
    })

    println()
    println(alphabet1())
    println(alphabet2())

    println()
    for (i in 0 until 0) {
        println("遍历结果：$i")
    }

    println()
    val transFormStr = "某某{0}获得了{1}张"
    val countStr = transFormStr.getSpecialStrCount("a")
    println("包含字符串的个数：$countStr")
    transFormStr.transForm()
    var nullStr: String? = null
    nullStr.isNullOrBlank()

    println()
    val elString = "abcdefg"
    println(elString.el(3))

    println()
    val numStr = "34"
    println("字符串得到的数字：${numStr.toInt()}")
    println("字符串得到的数字：${numStr.toLongOrNull()}")

    println()
    val reader = BufferedReader(StringReader("1\nabc\n42"))
    val numbers = readerNumbers(reader)
    addValidNumbers(numbers)

    println()
    val source: Collection<Int> = listOf(3, 4, 5)
    val target: MutableCollection<Int> = mutableListOf(2)
    copyElements(source, target)
    println("target: $target")

    println()
    val letters = Array(26) { i -> ('a' + i).toString() }
    println(letters.joinToString(""))

    println()
    val stringsArray = arrayListOf<String>("a", "b", "c")
    println("%s/%s/%s".format(*stringsArray.toTypedArray()))

    println()
    val fiveZero = IntArray(5)
    val fiveNum = intArrayOf(1, 2, 3, 4, 5)
    val squares = IntArray(5) { i -> (i + 1) * (i + 1) }
    val five = arrayListOf(1, 1, 1, 1)
    println("fiveZero: ${fiveZero.joinToString()}")
    println("fiveNum: ${fiveNum.joinToString()}")
    println("squares: ${squares.joinToString()}")
    println("five: $five")
    println("five to array: ${five.toIntArray().joinToString()}")

    println()
    val p = Point(10, 20)
    println("p[0] = ${p[0]}, p[1] = ${p[1]}")
    p[0] = 30
    p[1] = 40
    println("p[0] = ${p[0]}, p[1] = ${p[1]}")
    val (x, y) = p
    println("x = $x, y = $y")

    println()
    val rectangle = Rectangle(Point(10, 10), Point(20, 20))
    val p1 = Point(15, 15)
    val p2 = Point(15, 30)
    println("p1 is in rectangle: ${p1 in rectangle}, p2 is in rectangle: ${p2 in rectangle}")

    println()
    val now = LocalDate.now()
    val vacation = now.plusDays(10)
    println("now: $now, vocation: $vacation")
    for (date in now..vacation) {
        println(date)
    }

    println()
    val (name, ext) = splitFileName("example.kt")
    println("name: $name, ext: $ext")

    println()
    val woker1 = Worker("cainjiang", 28, 16000)
    val changeListener = PropertyChangeListener { event ->
        println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
    }
    woker1.addPropertyChangeListener(changeListener)
    woker1.age = 29
    woker1.salary = 20000
    woker1.removePropertyChangeListener(changeListener)
    val data = mapOf("gender" to "male")
    for ((attrName, value) in data) {
        woker1.setAttribute(attrName, value)
    }
    println("worker1 gender = ${woker1.gender}")

    println()
    twoAndThree { a, b -> a + b }
    twoAndThree { a, b -> a * b }

    println()


}

fun processTheAnswer(f: (Int) -> Int) {
    println("输出：${f(42)}")
}

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("高阶函数计算的结果：$result")
}

fun splitFileName(fullName: String): NameComponents {
    val (name, ext) = fullName.split('.', limit = 2)
    return NameComponents(name, ext)
}

fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>) {
    for (item in source) {
        target.add(item)
    }
}

fun readerNumbers(reader: BufferedReader): List<Int?> {
    val result = ArrayList<Int?>()
    for (line in reader.lineSequence()) {
        try {
            val number = line.toInt()
            result.add(number)
        } catch (e: NumberFormatException) {
            result.add(null)
        }
    }
    return result
}

fun addValidNumbers(numbers: List<Int?>) {
    val validNumbers = numbers.filterNotNull()
    println("numbers: $numbers")
    println("validNumbers: $validNumbers")
    println("Sunm of valid numbers: ${validNumbers.sum()}")
    println("Invalid numbers: ${numbers.size - validNumbers.size}")
}

fun alphabet1() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        this.append(letter)
    }
    this.append("\nNow I know the alphabet")
    this.toString()
}

fun alphabet2() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        this.append(letter)
    }
    append("\nNow I know the alphabet")
}.toString()

fun File.isInsideHiddenDirectory() = generateSequence(this) { it.parentFile }.any { it.isHidden }

fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")
    println("Dir:$directory, name:$fileName, ext:$extension")

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

fun getMnemonic(color: Color) = when (color) {
    Color.RED -> "Richard"
    Color.BLUE -> "Bluce"
    Color.GREEN -> "Geen"
}

fun mix(color1: Color, color2: Color) = when (setOf<Color>(color1, color2)) {
    setOf(Color.RED, Color.BLUE) -> "紫色"
    setOf(Color.RED, Color.GREEN) -> "朱红"
    else -> throw Exception("Dirty color")
}

fun eval(e: Expr): Int = if (e is Num) {
    e.value
} else if (e is Sum) {
    eval(e.left) + eval(e.right)
} else {
    throw IllegalArgumentException("Unknown expression")
}

fun eval2(e: Expr): Int = when (e) {
    is Num -> e.value
    is Sum -> eval2(e.left) + eval2(e.right)
    else -> throw IllegalArgumentException("Unknown expression")
}

fun eval3(e: Expr): Int = when (e) {
    is Num -> {
        println("num: ${e.value}")
        e.value
    }
    is Sum -> {
        val left = eval3(e.left)
        val right = eval3(e.right)
        println("sum: $left + $right")
        left + right
    }
    else -> throw IllegalArgumentException("Unknown expression")
}

fun eval4(num: NumberBility): Int = when (num) {
    is Number -> num.value
    is Summary -> num.left + num.right
}

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

fun saveUser(user: User) {
    fun validate(value: String, fileName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty $fileName")
        }
    }
    validate(user.name, "Name")
    validate(user.address, "Address")
    println("保存数据")
}

fun <T> loadFromJson(factory: IJsonFactory<T>): T {
    return factory.fromJson("jiangyu")
}


