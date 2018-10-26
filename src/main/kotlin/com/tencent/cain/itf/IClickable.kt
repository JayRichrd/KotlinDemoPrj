package com.tencent.cain.itf

interface IClickable {
    fun click()
    fun showOff() = println("I'm clickable.")
    fun hello() = println(" hello from clickable.")
}