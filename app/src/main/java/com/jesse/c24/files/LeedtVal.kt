package com.jesse.c24.files

fun main() {
    val imput = "alabares"
    val possibilities = listOf("la", "e", "es")
    getWords(imput, possibilities)
}

fun getWords(imput: String, possibilities: List<String>) {
    for (i in 0..< imput.length-1) {
       val ss = imput.substring(i, i+2)
        println(ss)
        if (possibilities.contains(ss)) {
            println("true")
        }
    }
}
