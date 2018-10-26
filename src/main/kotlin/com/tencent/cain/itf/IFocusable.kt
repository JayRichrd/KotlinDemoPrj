package com.tencent.cain.itf

interface IFocusable {
    fun setFocus(b:Boolean) = println("b:$b")
    fun showOff() = println("I'm focus.")
}