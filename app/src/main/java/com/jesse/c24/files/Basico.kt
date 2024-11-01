@file:Suppress("MagicNumber")
package com.jesse.c24.files

fun main(){
    var short = 32500
    var myShort = short.toShort()

   for(i in myShort..myShort+300){
       println( "$i $myShort ")
       myShort++

   }
}
