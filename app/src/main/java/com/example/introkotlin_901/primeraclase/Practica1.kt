package com.example.introkotlin_901.primeraclase

import kotlin.math.*

fun main() {
    var opcion: Int

    do {
        println("1. Circulo")
        println("2. Cuadrado")
        println("3. Pentagono")
        println("4. Triangulo")
        println("5. Salir")

        opcion = when (val input = readLine()?.toIntOrNull()) {
            null -> {
                println("Pon un numero valido hijo")
                -1
            }
            !in 1..5 -> {
                println("Que no ves que dice del 1 al 5")
                -1
            }
            else -> input
        }

        when (opcion) {
            1 -> calcularAreaCirculo()
            2 -> calcularAreaCuadrado()
            3 -> calcularAreaPentagono()
            4 -> calcularAreaTriangulo()
            5 -> println("FIN XD")
        }
    } while (opcion != 5)
}

fun calcularAreaCirculo() {
    print("Ingrese el radio del circulo: ")
    val radio = readLine()?.toDoubleOrNull() ?: run {
        println("Valor nop")
        return
    }
    val area = PI * radio * radio
    println("El area del circulo es: ${"%.2f".format(area)}")
}

fun calcularAreaCuadrado() {
    print("Ingrese el lado del cuadrado: ")
    val lado = readLine()?.toDoubleOrNull() ?: run {
        println("Nop")
        return
    }
    val area = lado * lado
    println("El area del cuadrado es: ${"%.2f".format(area)}")
}

fun calcularAreaPentagono() {
    print("Ingrese la longitud de un lado del pentagono: ")
    val lado = readLine()?.toDoubleOrNull() ?: run {
        println("Valor no valido")
        return
    }
    print("Ingrese la apotema del pentagono: ")
    val apotema = readLine()?.toDoubleOrNull() ?: run {
        println("No valido")
        return
    }
    val area = (5 * lado * apotema) / 2
    println("El area del pentagono es: ${"%.2f".format(area)}")
}

fun calcularAreaTriangulo() {
    print("Ingrese la base del triangulo: ")
    val base = readLine()?.toDoubleOrNull() ?: run {
        println("Valido? no ")
        return
    }
    print("Ingrese la altura del triangulo: ")
    val altura = readLine()?.toDoubleOrNull() ?: run {
        println("Nooooo")
        return
    }
    val area = (base * altura) / 2
    println("El area del triangulo es: ${"%.2f".format(area)}")
}