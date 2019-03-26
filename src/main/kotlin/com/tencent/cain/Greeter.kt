package com.tencent.cain

class Greeter(val greeter: String) {
    operator fun invoke(name: String) {
        println("$greeter, $name")
    }
}