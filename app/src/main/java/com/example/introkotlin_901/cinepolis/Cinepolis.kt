package com.example.introkotlin_901.cinepolis

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin_901.R

class Cinepolis : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etCompradores: EditText
    private lateinit var etBoletos: EditText
    private lateinit var rgTarjetaCineco: RadioGroup
    private lateinit var rbSi: RadioButton
    private lateinit var rbNo: RadioButton
    private lateinit var tvResultado: TextView
    private lateinit var btnCalcular: Button

    // Precio por boleto
    private val precioBoleto = 12.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar vistas
        initViews()

        // Configurar eventos
        setupEvents()
    }

    private fun initViews() {
        etNombre = findViewById(R.id.etNombre)
        etCompradores = findViewById(R.id.etCompradores)
        etBoletos = findViewById(R.id.etBoletos)
        rgTarjetaCineco = findViewById(R.id.rgTarjetaCineco)
        rbSi = findViewById(R.id.rbSi)
        rbNo = findViewById(R.id.rbNo)
        tvResultado = findViewById(R.id.tvResultado)
        btnCalcular = findViewById(R.id.btnCalcular)
    }

    private fun setupEvents() {
        btnCalcular.setOnClickListener {
            calcularTotal()
        }
    }

    private fun calcularTotal() {
        try {
            val nombre = etNombre.text.toString().trim()
            val compradores = etCompradores.text.toString().toIntOrNull() ?: 0
            val boletos = etBoletos.text.toString().toIntOrNull() ?: 0

            if (nombre.isEmpty()) {
                showError("Por favor ingresa tu nombre")
                return
            }

            if (compradores <= 0) {
                showError("Compradores 0 ?")
                return
            }

            if (boletos <= 0) {
                showError("Dale mas boletos")
                return
            }

            val boletosMaximos = compradores * 7
            if (boletos > boletosMaximos) {
                showError("Maximo 7 boletos por persona\nMaximo permitido: $boletosMaximos boletos")
                return
            }

            // Calcular precio
            var total = boletos * precioBoleto

            //  descuentos cantidad
            val descuentoPorCantidad = calcularDescuentoPorCantidad(boletos)
            total *= (1 - descuentoPorCantidad)

            //  descuentopor tarjeta
            if (rbSi.isChecked) {
                total *= 0.9 // 10% de descuento adicional
            }

            // Mostrar resultado
            tvResultado.text = String.format("$ %.2f", total)

        } catch (e: Exception) {
            showError("Error en el calculo.\nVerifica los datos ingresados.")
        }
    }

    private fun calcularDescuentoPorCantidad(boletos: Int): Double {
        return when {
            boletos >= 5 -> 0.15  // 5 o mas
            boletos in 3..4 -> 0.10  // 3-4
            else -> 0.0  // Sin descuento
        }
    }

    private fun showError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
}