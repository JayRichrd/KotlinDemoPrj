package com.tencent.cain

import com.tencent.cain.user.Worker
import java.beans.PropertyChangeSupport
import kotlin.reflect.KProperty

class ObservablePropertyKot(var propValue: Int, val changeSupport: PropertyChangeSupport) {
    operator fun getValue(worker: Worker, prop: KProperty<*>): Int = propValue
    operator fun setValue(worker: Worker, prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

}