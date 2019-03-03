package com.tencent.cain

interface FieldValicator<in T> {
    fun validate(inpute: T): Boolean
}