package com.example.introkotlin_901.diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin_901.R

class menuuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar los botones
        initializeButtons()
    }

    private fun initializeButtons() {
        // Botón Capturar Palabras
        val btnCapturarPalabras = findViewById<Button>(R.id.btnCapturarPalabras)
        btnCapturarPalabras.setOnClickListener {
            val intent = Intent(this, agregarActivity::class.java)
            startActivity(intent)
        }

        // Botón Buscar Palabras
        val btnBuscarPalabras = findViewById<Button>(R.id.btnBuscarPalabras)
        btnBuscarPalabras.setOnClickListener {
            val intent = Intent(this, buscarActivity::class.java)
            startActivity(intent)
        }
    }
}