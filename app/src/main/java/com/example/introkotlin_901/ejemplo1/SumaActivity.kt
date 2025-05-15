package com.example.introkotlin_901.ejemplo1

import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin_901.R
import android.view.View

class SumaActivity : AppCompatActivity() {

    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var tv1: TextView
    private lateinit var radioSuma: RadioButton
    private lateinit var radioResta: RadioButton
    private lateinit var radioMultiplicacion: RadioButton
    private lateinit var radioDivision: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_suma)

        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        tv1 = findViewById(R.id.tv1)
        radioSuma = findViewById(R.id.radioSuma)
        radioResta = findViewById(R.id.radioResta)
        radioMultiplicacion = findViewById(R.id.radioMultiplicacion)
        radioDivision = findViewById(R.id.radioDivision)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcular(view: View) {
        val num1 = et1.text.toString().toDouble()
        val num2 = et2.text.toString().toDouble()
        var resultado = 0.0

        when {
            radioSuma.isChecked -> resultado = num1 + num2
            radioResta.isChecked -> resultado = num1 - num2
            radioMultiplicacion.isChecked -> resultado = num1 * num2
            radioDivision.isChecked -> resultado = if (num2 != 0.0) num1 / num2 else Double.NaN
        }

        tv1.text = "Resultado = $resultado"
    }
}