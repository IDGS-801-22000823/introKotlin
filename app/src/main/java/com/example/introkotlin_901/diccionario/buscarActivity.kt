package com.example.introkotlin_901.diccionario

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.introkotlin_901.R
import java.io.File

class buscarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar)

        val etPalabraBuscar = findViewById<EditText>(R.id.etPalabraBuscar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val tvPalabraEncontrada = findViewById<TextView>(R.id.tvPalabraEncontrada)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)
        val btnRegresar = findViewById<Button>(R.id.btnRegresarMenuBuscar)
        val rbEspanol = findViewById<RadioButton>(R.id.rbEspanol)
        val rbIngles = findViewById<RadioButton>(R.id.rbIngles)

        btnBuscar.setOnClickListener {
            val palabraBuscar = etPalabraBuscar.text.toString().trim()

            if (palabraBuscar.isEmpty()) {
                Toast.makeText(this, "Ingrese una palabra a buscar", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val idioma = if (rbEspanol.isChecked) "espanol" else "ingles"
            val resultado = buscarPalabra(palabraBuscar, idioma)

            if (resultado != null) {
                tvPalabraEncontrada.text = "Palabra encontrada:"
                tvResultado.text = resultado
            } else {
                tvPalabraEncontrada.text = "Palabra no encontrada"
                tvResultado.text = ""
            }
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }

    private fun buscarPalabra(palabra: String, idioma: String): String? {
        return try {
            val directory = File(filesDir, "diccionario")
            val archivo = File(directory, "palabras_guardadas.txt")

            if (!archivo.exists()) {
                Toast.makeText(this, "No hay palabras guardadas", Toast.LENGTH_SHORT).show()
                return null
            }

            val lineas = archivo.readLines()
            for (linea in lineas) {
                if (linea.isNotEmpty()) {
                    val partes = linea.split("|")
                    if (partes.size >= 2) {
                        val esp = partes[0].trim().lowercase()
                        val ing = partes[1].trim().lowercase()

                        // Español traduce del ingles al español
                        if (idioma == "espanol" && palabra.lowercase() == ing) {
                            return esp.uppercase()
                        }

                        // Ingles traduce del español al inglés
                        if (idioma == "ingles" && palabra.lowercase() == esp) {
                            return ing.uppercase()
                        }
                    }
                }
            }

            null
        } catch (e: Exception) {
            Toast.makeText(this, "Error al buscar la palabra", Toast.LENGTH_SHORT).show()
            null
        }
    }


}

