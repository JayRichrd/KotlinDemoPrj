package com.tencent.cain.user

class User(val userName:String) {
    var address:String = "unspecified"
    set(value) {
        println("""Address was changed for $userName:
            |"$field" -> "$value"""".trimMargin())
        field = value
    }
}