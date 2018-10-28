package com.tencent.cain.user

class Client(val name: String, val postalColde: Int) {
    override fun toString() = "Client(name=$name, postalColde=$postalColde)"
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client)
            return false
        return name == other.name && postalColde == other.postalColde
    }

    override fun hashCode() = name.hashCode() * 31 + postalColde
}