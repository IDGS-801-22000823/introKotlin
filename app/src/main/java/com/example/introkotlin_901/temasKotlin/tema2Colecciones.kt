package com.example.introkotlin_901.temasKotlin

fun main(){
    /*
    List, MutableList
    set MutableSet
    Map, MutableMap
     */

    var readOnlyList: List<String> = listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes")
    println(readOnlyList)
    println("El primer dia es: ${readOnlyList[0]}")
    println("El primer dia es: ${readOnlyList.first()}")
    println("El numero de dias es: ${readOnlyList.count()}")
    println("El numero de dias es: ${readOnlyList.size}")
    println("Martes" in readOnlyList)

    var figuras: MutableList<String> = mutableListOf("Circulo", "Cuadrado", "Triangulo")
    println(figuras)
    figuras.add("Pentagono")
    println(figuras)
    figuras.removeAt(0)
    println(figuras)
    figuras.remove("Cuadrado")
    println(figuras)

    //----------------------------------------------------------------------------------------------

    val readOnlyFrutas = mapOf("Manzana" to 1500, "Platano" to 2000, "Sandia" to 2500)
    println(readOnlyFrutas)
    println(readOnlyFrutas["Manzana"])
    println(readOnlyFrutas.keys)
    println(readOnlyFrutas.values)



}