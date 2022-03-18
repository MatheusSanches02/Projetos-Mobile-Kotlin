package br.com.fiap.checkpoint1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_conta_telefonica.*
import kotlinx.android.synthetic.main.activity_main.*

class ContaTelefonica : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conta_telefonica)

        var assinatura = findViewById<EditText>(R.id.txtAssinatura);
        var minCelular = findViewById<EditText>(R.id.txtCelular);
        var minLocal = findViewById<EditText>(R.id.txtLocal);
        btnContaTelefonica.setOnClickListener{view : View? ->

            var result = 0.0;
            val valorAssinatura = assinatura.text.toString().toDouble();
            val minutosCelular = minCelular.text.toString().toDouble();
            val minutosLocal = minLocal.text.toString().toDouble();

            var valorCelular = minutosCelular * 0.20;
            var valorLocal = minutosLocal * 0.04;

            result = valorAssinatura + valorCelular + valorLocal;
            val mensagem = """Assinatura : R$${String.format("%.2f",valorAssinatura)}
                            |Chamada Local : R$${String.format("%.2f",minutosLocal)}
                            |Chamada Celular : R$${String.format("%.2f",minutosCelular)}
                            |
                            |Valor Total : R$${result}
            """.trimMargin("|");

            var intentResultado = Intent(this, TelaResultado::class.java);
            intentResultado.putExtra("msg", mensagem )
            startActivity(intentResultado)
        }
    }
}