package com.tencent.cain

object DefaultIntValidator : FieldValicator<Int> {
    override fun validate(inpute: Int): Boolean = inpute >= 0
}