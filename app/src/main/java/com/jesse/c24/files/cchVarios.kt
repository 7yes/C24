package com.jesse.c24.files

fun main() {
    println(findMax(arrayOf(1, 2, 3, 7, 5, 6)))
    println(reserveString("Holaa"))
}

fun findMax(array: Array<Int>): Any {
    var max = 0
    array.forEach {
        if (it > max) {
            max = it
        }
    }
    return max
}

fun reserveString(s: String): String {
    println(s)
    var r = ""
    for (i in s.length - 1 downTo 0) {
        r += s[i]
    }
    return r
}
