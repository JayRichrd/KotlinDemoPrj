package com.tencent.cain

import com.tencent.cain.user.IUser

/**
 * @author cainjiang
 * @date 2018/10/12
 */
enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    BLUE(0, 0, 255),
    GREEN(0, 255, 0);

    fun rgb() = (r * 256 + g) * 256 + b
}

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

class ArgsUtil {
    @JvmOverloads
    fun <T> joinToString(collection: Collection<T>, separator: String = ", ", prefix: String = "", postfix: String = ""): String {
        val result = StringBuilder(prefix)
        for ((index, element) in collection.withIndex()) {
            if (index > 0) result.append(separator)
            result.append(element)
        }
        result.append(postfix)
        return result.toString()
    }
}

class User(val id: Int, val name: String, val address: String)

sealed class NumberBility
class Number(val value: Int) : NumberBility()
class Summary(val left: Int, val right: Int) : NumberBility()

class PrivateUser(override val email: String) : IUser
class SubscribingUser(_email: String) : IUser {
    override val email = _email
}

class FacebookUser(val accoutId: Int) : IUser {
    override val email = getFacebookName(accoutId)

    private fun getFacebookName(accoutId: Int) = accoutId.toString()
}



