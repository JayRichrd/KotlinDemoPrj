package com.tencent.cain

import com.tencent.cain.person.ContactPerson

class ContactListFilter {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false
    fun getPredicate(): (ContactPerson) -> Boolean {
        // 定义一个函数变量，需要明确指定它的类型
        val startsWithPrefix = { contactPerson: ContactPerson ->
            contactPerson.firstName.startsWith(prefix) || contactPerson.secondName.startsWith(prefix)
        }
        if (!onlyWithPhoneNumber) {
            return startsWithPrefix
        }
        return { startsWithPrefix(it) && it.phoneNum != null }
    }
}