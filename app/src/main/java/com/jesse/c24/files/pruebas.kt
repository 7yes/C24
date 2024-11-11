package com.jesse.c24.files

fun main() {
//println(isPalindrome("madxdam"))
//println(removeDuplicates(arrayOf(1, 2, 2, 3, 4, 4, 5)).joinToString()) // Output: [1, 2, 3, 4, 5]
//println(areAnagrams("alisten", "dsilent"))
//   println(myAnagram2("listen", "silent"))

   // val inputLists = listOf(listOf(1, 4, 5), listOf(1, 3, 4), listOf(2, 6))
    //println(mergeKSortedList(inputLists))
    println(halloween1(arrayOf(4, 5, 6, 2), 3))
}

fun halloween1(potion: Array<Int>, goal: Int): Any {

    for (i in potion.indices) {
        for (j in i + 1 until potion.size) {
              if (potion[i] + potion[j] == goal) {
                return "$i+ $j"
            }
        }
    }
    return "undefined"
}

fun mergeKSortedList(lists: List<List<Int>>): Any {
    val a = lists.flatten().sorted() //[1, 1, 2, 3, 4, 4, 5, 6]
    println(a)
    val b = a.groupBy { it } //{1=[1, 1], 2=[2], 3=[3], 4=[4, 4], 5=[5], 6=[6]}
    println(b)
    return b
    return true
}


fun myAnagram2(word1: String, word2: String): Boolean {
    val a = 'a'.code
    val letters = IntArray(26)
    if (word1.length != word2.length) return false
    for (i in word1.indices) {
        letters[word1[i].code - a]++
        letters[word2[i].code - a]--
    }
    val x = Array<Int>(26) { 2 }
    println(x.joinToString())
    for (i in letters) {
        if (i != 0) return false
    }
    return true
}

fun areAnagrams(string1: String, string2: String): Boolean {
    if (string1.length != string2.length) return false

    val count = IntArray(26)
    for (i in string1.indices) {
        println("${string1[i] - 'a'} @")
        count[string1[i] - 'a']++
        count[string2[i] - 'a']--
    }

    for (i in count) {
        if (i != 0) return false
    }
    return true
}

fun isPalindrome(input: String): Boolean {
    val cleanedInput = input.lowercase().filter { it != ' ' }
    val length = cleanedInput.length

    for (i in 0 until length / 2) {
        if (cleanedInput[i] != cleanedInput[length - i - 1]) {
            return false
        }
    }
    return true
}

fun removeDuplicates(numbers: Array<Int>): Array<Int> {
    val uniqueNumbers = mutableListOf<Int>()
    for (i in numbers.indices) {
        if (!uniqueNumbers.contains(numbers[i])) {
            uniqueNumbers.add(numbers[i])
        }
    }
    return uniqueNumbers.toTypedArray()
}
