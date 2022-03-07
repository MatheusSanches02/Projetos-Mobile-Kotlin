package br.fiap.exemplo02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        btnCalcular.setOnClickListener{
            val txtPrecoAlcool = findViewById<EditText>(R.id.txtPrecoAlcool)
            val precoAlcool = txtPrecoAlcool.text.toString().toDouble()
            val txtPrecoGasolina = findViewById<EditText>(R.id.txtPrecoGasolina)
            val precoGasolina = txtPrecoGasolina.text.toString().toDouble()
            val resultado : Double = precoAlcool / precoGasolina
            var mensagem = ""
            if(resultado > 0.7){
                mensagem = "Gasolina"
            }
            else if(resultado < 0.7){
                mensagem = "Alcool"
            }
            else{
                mensagem = "Tanto faz"
            }
            val intentResultado = Intent (this, ResultadoActivity::class.java)
            intentResultado.putExtra("msg", mensagem)
            startActivity(intentResultado)
        }
    }
}