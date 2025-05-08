package com.example.introkotlin_901.temasKotlin

//For

fun main() {
    for (number in 1..5) {
    print(number)
    }

    val nombres = listOf("Ronald", "Mario", "Veronica")

    for(nombre in nombres){
        println("\n"+ nombre)
    }

    //while do-while

    var x = 0
    while(x < 5){
        println(x)
        x++
    }

    do{
        println(x)
        x++
    }while(x < 5)




}