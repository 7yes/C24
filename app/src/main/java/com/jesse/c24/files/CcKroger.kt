package com.jesse.c24.files

fun main() {
    // caja donde se ingresa dinero y el valor del producto CH and PP, se da change
    val input = listOf("12.53;12.10", "1.00;1.00", "0;5")
    input.forEach {
        println(checkChange(it))
    }
}

fun checkChange(input: String): String {
    val parts = input.split(";")
    val CH = (parts[0].toDouble() * 100).toInt()
    val PP = (parts[1].toDouble() * 100).toInt()
    val ch = CH - PP
    return when {
        ch > 0 -> getChange(ch)
        ch == 0 -> "ZERO"
        else -> "ERROR"
    }
}

fun getChange(ch: Int): String {
    var input = Response(ch, "")

    Money.entries.forEach {
        println(input)
        input = getCoins(it.value, it.moneyName, input)
    }
    return input.answer.dropLast(1)
}

fun getCoins(value: Int, moneyName: String, input: Response): Response {

    val times = input.quantity / value
    var s = input.answer
    for (i in 0..times - 1) {
        s += "$moneyName,"
    }
    return Response(input.quantity - times * value, s)
}

data class Response(var quantity: Int, var answer: String)

enum class Money(val value: Int, val moneyName: String) {
    ONE_HUNDRED(10000, "ONE HUNDRED"),
    FIFTY(5000, "FIFTY"),
    TWENTY(2000, "TWENTY"),
    TEN(1000, "TEN"),
    FIVE(500, "FIVE"),
    DOLLAR(100, "DOLLAR"),
    HALF_DOLLAR(50, "HALF DOLLAR"),
    QUARTER(25, "QUARTER"),
    DIME(10, "DIME"),
    NICKEL(5, "NICKEL"),
    PENNY(1, "PENNY")
}


