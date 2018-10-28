package com.tencent.cain.util

import com.tencent.cain.person.Employeer

object Payroll {
    val allEmployees = arrayListOf<Employeer>()
    var allSalaries = 0L

    fun calculateSalary() {
        for (employeer in allEmployees) {
            println("${employeer.name} contribute ${employeer.salary}")
            allSalaries += employeer.salary
        }
    }
}