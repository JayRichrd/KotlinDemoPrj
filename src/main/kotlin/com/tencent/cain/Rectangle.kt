package com.tencent.cain

/**
 * @author cainjiang
 * @date 2018/10/10
 */
data class Rectangle(val upperLeft: Point, val lowerRight: Point) {

}

operator fun Rectangle.contains(p: Point): Boolean {
    return p.x in upperLeft.x until lowerRight.x && p.y in upperLeft.y until lowerRight.y
}