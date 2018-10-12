package com.tencent.cain

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
class Num(val value:Int):Expr
class Sum(val left:Expr,val right:Expr):Expr