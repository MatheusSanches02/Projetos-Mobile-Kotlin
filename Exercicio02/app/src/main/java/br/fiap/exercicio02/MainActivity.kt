package br.fiap.exercicio02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnSoma = findViewById<Button>(R.id.btnSoma)
        btnSoma.setOnClickListener{
            val txtNumero1 = findViewById<EditText>(R.id.txtNumero1)
            val numero1 = txtNumero1.text.toString().toDouble()
            val txtNumero2 = findViewById<EditText>(R.id.txtNumero2)
            val numero2 = txtNumero2.text.toString().toDouble()
            val resultado : Double = numero1 + numero2

            val intentResultado = Intent (this, ResultadoActivity::class.java)
            intentResultado.putExtra("result", resultado)
            startActivity(intentResultado)
        }
    }
}