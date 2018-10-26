package com.tencent.cain.user

import com.tencent.cain.itf.IClickable
import com.tencent.cain.itf.IFocusable

class Button : IClickable, IFocusable {
    override fun showOff() {
        super<IClickable>.showOff()
        super<IFocusable>.showOff()
        println("button showoff")
    }

    override fun click() {
        println("button click.")
    }
}