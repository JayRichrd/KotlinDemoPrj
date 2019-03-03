package com.tencent.cain

import java.lang.IllegalArgumentException
import kotlin.reflect.KCallable
import kotlin.reflect.KClass

object Validators {
    private val validators = mutableMapOf<KClass<*>, FieldValicator<*>>()

    fun <T : Any> registerValidator(kClass: KClass<T>, fieldValicator: FieldValicator<T>) {
        validators[kClass] = fieldValicator
    }

    operator fun <T : Any> get(kClass: KClass<T>): FieldValicator<T> = validators[kClass] as? FieldValicator<T>
            ?: throw IllegalArgumentException("No validator for ${kClass.simpleName}")
}