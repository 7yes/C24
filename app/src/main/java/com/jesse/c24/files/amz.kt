package com.jesse.c24.files

fun main() {
    //getMaxP(data)// 7 y 9

    //aca amz count grops
    val input = arrayOf("1010", "0100", "1010", "0001")
    println(countGroups(input)) // Output should be 2 for this example
}

fun countGroups(input: Array<String>): Int {
    val n = input.size
    val people = BooleanArray(n) { false }
    var groupCount = 0

    for (i in 0 until n) {
        if (!people[i]) {
            dfs(i, people, input, n)
            groupCount++
        }
    }

    return groupCount
}

private fun dfs(person: Int, visited: BooleanArray, input: Array<String>, n: Int) {
    visited[person] = true

    for (other in 0 until n) {
        if (input[person][other] == '1' && !visited[other]) {
            dfs(other, visited, input, n)
        }
    }
}

fun getMaxP(data: Array<Int>) {
    val myList = data.sorted().toMutableList()
    var middle = 0
    myList.forEach {
        middle += it
    }
    middle /= 2
    var pos = 0
    var count = 0
    while (count < middle) {
        count += myList[pos++]
    }
    val answer = Array<Int>(myList.size + 1 - pos) { 0 }
    var posA = 0
    for (i in pos - 1..myList.size - 1) {
        answer[posA++] = myList[i]
    }
    println(answer.joinToString())
    answer.forEach {
        print("$it ")
    }
}
