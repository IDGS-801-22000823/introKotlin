package com.example.introkotlin_901.tarea_figuras

import kotlin.math.PI
import kotlin.math.pow

abstract class Figura {
    abstract fun calcularArea(): Double
    abstract fun solicitarDatos()
}

class Circulo : Figura() {
    private var radio: Double = 0.0

    override fun solicitarDatos() {
        print("Ingrese el radio: ")
        radio = readLine()?.toDoubleOrNull() ?: run {
            println("Valor no valido")
            0.0
        }
    }

    override fun calcularArea(): Double {
        return PI * radio.pow(2)
    }
}

class Cuadrado : Figura() {
    private var lado: Double = 0.0

    override fun solicitarDatos() {
        print("Ingrese el lado del cuadrado: ")
        lado = readLine()?.toDoubleOrNull() ?: run {
            println("Valor? no creo")
            0.0
        }
    }

    override fun calcularArea(): Double {
        return lado * lado
    }
}

class Pentagono : Figura() {
    private var lado: Double = 0.0
    private var apotema: Double = 0.0

    override fun solicitarDatos() {
        print("Ingrese el tamaño del lado del pentagono: ")
        lado = readLine()?.toDoubleOrNull() ?: run {
            println("Que no entiende")
            0.0
        }

        print("Ingrese la apotema del pentagono: ")
        apotema = readLine()?.toDoubleOrNull() ?: run {
            println("Tu no entiendes verdad")
            0.0
        }
    }

    override fun calcularArea(): Double {
        return (5 * lado * apotema) / 2
    }
}

class Triangulo : Figura() {
    private var base: Double = 0.0
    private var altura: Double = 0.0

    override fun solicitarDatos() {
        print("Ingrese la base del triangulo: ")
        base = readLine()?.toDoubleOrNull() ?: run {
            println("Nop")
            0.0
        }

        print("Ingrese la altura del triangulo: ")
        altura = readLine()?.toDoubleOrNull() ?: run {
            println("No valido")
            0.0
        }
    }

    override fun calcularArea(): Double {
        return (base * altura) / 2
    }
}

class Rectangulo : Figura() {
    private var base: Double = 0.0
    private var altura: Double = 0.0

    override fun solicitarDatos() {
        print("Ingrese la base del rectangulo: ")
        base = readLine()?.toDoubleOrNull() ?: run {
            println("Igual que mi IFE, no valido sjsjs")
            0.0
        }

        print("Ingrese la altura del rectangulo: ")
        altura = readLine()?.toDoubleOrNull() ?: run {
            println("Siga participando")
            0.0
        }
    }

    override fun calcularArea(): Double {
        return base * altura
    }
}

fun main() {
    var opcion: Int

    do {
        println("\n1. Circulo")
        println("2. Cuadrado")
        println("3. Pentagono")
        println("4. Triangulo")
        println("5. Rectangulo")
        println("6. Salida de emergencia")
        print("Seleccione una: ")

        opcion = when (val input = readLine()?.toIntOrNull()) {
            null -> {
                println("Estas viendo y no vez que solo hasy 6")
                -1
            }
            !in 1..6 -> {
                println("UNO (1) O SEIS (6) NO ES TAN DIFICIL")
                -1
            }
            else -> input
        }

        if (opcion in 1..5) {
            val figura = when (opcion) {
                1 -> Circulo()
                2 -> Cuadrado()
                3 -> Pentagono()
                4 -> Triangulo()
                5 -> Rectangulo()
                else -> null
            }

            figura?.let {
                it.solicitarDatos()
                val area = it.calcularArea()
                println("El area de la figura es: ${"%.2f".format(area)}")
            }
        } else if (opcion == 6) {
            println("Hasta la proximaaaaa jsjs")
        }
    } while (opcion != 6)
}

