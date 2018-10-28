package com.tencent.cain.user

interface IUser {
    val email: String
    val nickName: String
        get() = email.substringBefore('@')
}