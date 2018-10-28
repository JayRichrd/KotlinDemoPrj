package com.tencent.cain.user

interface IJsonFactory<T> {
    fun fromJson(jsonText: String): T
}