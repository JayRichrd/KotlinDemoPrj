package com.tencent.cain

/**
 * @author cainjiang
 * @date 2018/10/10
 */
class Rectangle(val width: Int, val height: Int) {
    val isSquare: Boolean
        get() = width == height
}