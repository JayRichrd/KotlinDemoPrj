package com.tencent.cain

object DefaultStringValidator : FieldValicator<String> {
    override fun validate(inpute: String): Boolean = inpute.isNotEmpty()
}