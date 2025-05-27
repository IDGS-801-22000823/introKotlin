package com.example.introkotlin_901.diccionario

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin_901.R
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class agregarActivity : AppCompatActivity() {

    // Declarar las vistas
    private lateinit var etEspanol: EditText
    private lateinit var etIngles: EditText
    private lateinit var btnGuardar: Button
    private lateinit var btnRegresarMenu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_agregar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar las vistas
        inicializarVistas()

        // Configurar listeners
        setupListeners()
    }

    private fun inicializarVistas() {
        etEspanol = findViewById(R.id.etEspanol)
        etIngles = findViewById(R.id.etIngles)
        btnGuardar = findViewById(R.id.btnGuardar)
        btnRegresarMenu = findViewById(R.id.btnRegresarMenu)
    }

    private fun setupListeners() {
        // Listener para el botón Guardar
        btnGuardar.setOnClickListener {
            mostrarDialogoConfirmacion()
        }

        // Listener para el botón Regresar al Menú
        btnRegresarMenu.setOnClickListener {
            finish() // Cierra la actividad y regresa a la anterior
        }
    }

    private fun mostrarDialogoConfirmacion() {
        val palabraEspanol = etEspanol.text.toString().trim()
        val palabraIngles = etIngles.text.toString().trim()

        // Validar que ambos campos estén llenos
        if (palabraEspanol.isEmpty() || palabraIngles.isEmpty()) {
            Toast.makeText(this, "Por favor, completa ambos campos", Toast.LENGTH_SHORT).show()
            return
        }

        // Guardar directamente la palabra
        guardarPalabra(palabraEspanol, palabraIngles)

        // Mostrar mensaje de confirmación con solo botón OK
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Guardado Exitoso")
        builder.setMessage("La palabra se ha guardado correctamente:\n\nEspañol: $palabraEspanol\nInglés: $palabraIngles")
        builder.setIcon(android.R.drawable.ic_dialog_info)
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }

        builder.create().show()
    }


    private fun guardarPalabra(palabraEspanol: String, palabraIngles: String) {
        try {
            // Verificar si la palabra ya existe
            if (palabraYaExiste(palabraEspanol, palabraIngles)) {
                Toast.makeText(this, "Esta palabra ya está guardada", Toast.LENGTH_LONG).show()
                return
            }

            // Crear el directorio si no existe
            val directory = File(filesDir, "diccionario")
            if (!directory.exists()) {
                directory.mkdirs()
            }

            // Crear o abrir el archivo
            val archivo = File(directory, "palabras_guardadas.txt")

            // Preparar el texto a guardar
            val fechaHora = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).format(Date())
            val textoAGuardar = "$palabraEspanol|$palabraIngles|$fechaHora\n"

            // Escribir al archivo (agregar al final)
            val fos = FileOutputStream(archivo, true) // true = append mode
            fos.write(textoAGuardar.toByteArray())
            fos.close()

            // Limpiar campos
            etEspanol.text.clear()
            etIngles.text.clear()

            // Mostrar mensaje de éxito
            Toast.makeText(this, "Palabra guardada exitosamente en archivo TXT", Toast.LENGTH_LONG).show()

            // Enfocar el primer campo para continuar agregando
            etEspanol.requestFocus()

        } catch (e: IOException) {
            Toast.makeText(this, "Error al guardar la palabra: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun palabraYaExiste(espanol: String, ingles: String): Boolean {
        return try {
            val directory = File(filesDir, "diccionario")
            val archivo = File(directory, "palabras_guardadas.txt")

            if (!archivo.exists()) {
                return false
            }

            // Leer el archivo y verificar si la palabra ya existe
            val contenido = archivo.readText()
            val lineas = contenido.split("\n")

            for (linea in lineas) {
                if (linea.isNotEmpty()) {
                    val partes = linea.split("|")
                    if (partes.size >= 2) {
                        val palabraEspanolExistente = partes[0]
                        val palabraInglesExistente = partes[1]

                        if (palabraEspanolExistente.equals(espanol, ignoreCase = true) ||
                            palabraInglesExistente.equals(ingles, ignoreCase = true)) {
                            return true
                        }
                    }
                }
            }
            false
        } catch (e: Exception) {
            false
        }
    }

}