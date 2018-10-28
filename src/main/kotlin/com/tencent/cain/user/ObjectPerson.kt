package com.tencent.cain.user

class ObjectPerson(val name: String) {
    companion object : IJsonFactory<ObjectPerson> {
        override fun fromJson(jsonText: String): ObjectPerson = ObjectPerson(jsonText)
    }
}