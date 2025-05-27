package com.example.introkotlin_901

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin_901.archivoTexto.Ejemplo5
import com.example.introkotlin_901.cinepolis.Cinepolis
import com.example.introkotlin_901.diccionario.menuuActivity
import com.example.introkotlin_901.ejemplo1.SumaActivity
import com.example.introkotlin_901.ejemplo2.SaludoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu2)

        val btnSaludo = findViewById<Button>(R.id.btn1)
        btnSaludo.setOnClickListener {navegateToSaludo()}

        val btnCine = findViewById<Button>(R.id.btn2)
        btnCine.setOnClickListener {navegateToCine()}

        val btnSaludor = findViewById<Button>(R.id.btn3)
        btnSaludor.setOnClickListener {navegateToSaludar()}

        val btnDiccionario = findViewById<Button>(R.id.btn4)
        btnDiccionario.setOnClickListener {navegateToDiccionario()}

        val btnEjemplo5 = findViewById<Button>(R.id.btn5)
        btnEjemplo5.setOnClickListener {navegateToEjemplo5()}

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navegateToSaludo() {
        val intent = Intent(this, SumaActivity::class.java)
        startActivity(intent)
    }

    private fun navegateToCine() {
        val intent = Intent(this, Cinepolis::class.java)
        startActivity(intent)
    }

    private fun navegateToSaludar() {
        val intent = Intent(this, SaludoActivity::class.java)
        startActivity(intent)
    }

    private fun navegateToDiccionario() {
        val intent = Intent(this, menuuActivity::class.java)
        startActivity(intent)
    }

    private fun navegateToEjemplo5() {
        val intent = Intent(this, Ejemplo5::class.java)
        startActivity(intent)
    }

}