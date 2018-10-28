package com.tencent.cain.person

data class Employeer(val name: String, val salary: Long) {
    object EmployeerComparator : Comparator<Employeer> {
        override fun compare(employeer1: Employeer, employeer2: Employeer): Int = employeer1.salary.compareTo(employeer2.salary)
    }
}