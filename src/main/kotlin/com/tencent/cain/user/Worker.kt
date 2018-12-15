package com.tencent.cain.user

import com.tencent.cain.ObservableProperty
import com.tencent.cain.ObservablePropertyKot
import com.tencent.cain.PropertyChangeAware
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Worker(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    //    val _age = ObservableProperty("age", age, changeSupport)
//    var age: Int
//        get() = _age.getValue()
//        set(value) {
//            _age.setValue(value)
//        }
//
//    val _salary = ObservableProperty("salary", salary, changeSupport)
//    var salary: Int
//        get() = _salary.getValue()
//        set(value) {
//            _salary.setValue(value)
//        }
//    var age: Int by ObservablePropertyKot(age, changeSupport)
//    var salary: Int by ObservablePropertyKot(salary, changeSupport)
    private val observerInt = { prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

    var age: Int by Delegates.observable(age, observerInt)
    var salary: Int by Delegates.observable(salary, observerInt)

    private val _attributes = hashMapOf<String, String>()
    val gender: String by _attributes

    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }
}