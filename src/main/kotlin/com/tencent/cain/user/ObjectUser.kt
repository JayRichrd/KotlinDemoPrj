package com.tencent.cain.user

class ObjectUser private constructor(val nickName: String) {
    companion object {
        fun newSubscribingUser(email: String) = ObjectUser(email.substringBefore('@'))

        fun newFacebookUser(accoutId: Int):ObjectUser{
            return ObjectUser(getFacebookName(accoutId))
        }

        fun getFacebookName(accoutId: Int): String = accoutId.toString()
    }

    fun getFacebookName(accoutId: Int): String = accoutId.toString()
}