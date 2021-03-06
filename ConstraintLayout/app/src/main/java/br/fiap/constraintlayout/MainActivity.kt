package br.fiap.constraintlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnCalcular = findViewById<Button>(R.id.btnCalcular)
        //Função que implementa o evento de clique em um botão
        btnCalcular.setOnClickListener {view : View? ->
            var txtPrecoAlcool = findViewById<EditText>(R.id.editTextPrecoAlcool)
            //declaração implicita do tipo da variavel
            var precoAlcool = txtPrecoAlcool.text.toString().toDouble()
            var txtPrecoGasolina = findViewById<EditText>(R.id.editTextPrecoGasolina)
            var precoGasolina = txtPrecoGasolina.text.toString().toDouble()
            //declaração explicita do tipo da variavel
            var resultado : Double = precoAlcool / precoGasolina
            var mensagem = ""
            if(resultado > 0.7){
                mensagem = "Gasolina"
            }
            else if(resultado < 0.7){
                mensagem = "Alcool"
            }
            else{
                mensagem = "Indiferente"
            }
            //Instancia o obj Intent, apontando a activity alvo
            var intentResultado = Intent(this, ResultadoActivity::class.java)
            //armazenamento por conjunto de chave-valor
            intentResultado.putExtra("msg", mensagem)
            //disparo da Intent para carregar a nova tela
            startActivity(intentResultado)
            //Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show()
        }
    }
}