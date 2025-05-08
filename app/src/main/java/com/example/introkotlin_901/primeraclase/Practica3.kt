package com.example.introkotlin_901.primeraclase

fun main() {
    var niveles: Int

    do {
        print("Ingrese el numero de niveles (0 salir): ")

        niveles = when (val input = readLine()?.toIntOrNull()) {
            null -> {
                println("Debe ingresar un numero valido")
                -1  // para que siga o F sjsj
            }
            else -> input
        }

        when {
            niveles == 0 -> {
                println("Fin xD")
            }
            niveles < 0 -> {
            }
            else -> {
                construirPiramide(niveles)
            }
        }
    } while (niveles != 0)
}

fun construirPiramide(niveles: Int) {
    println("\nPiramide de $niveles niveles:")
    for (i in 1..niveles) {
        print(" ".repeat(niveles - i))
        println("*".repeat(i))
    }
}