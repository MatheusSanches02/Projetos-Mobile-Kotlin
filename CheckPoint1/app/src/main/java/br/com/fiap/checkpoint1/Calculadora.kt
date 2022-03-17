package br.com.fiap.checkpoint1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculadora.*

class Calculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val valor1 = findViewById<EditText>(R.id.n1);
        val valor2 = findViewById<EditText>(R.id.n2);

        btnCalcular.setOnClickListener{view : View ->
            val num1 = valor1.text.toString().toDouble();
            val num2 = valor2.text.toString().toDouble();
            if(rbSoma.isChecked){
                var result  = num1 + num2;
                Toast.makeText(this,"A soma dos valores é: ${result}", Toast.LENGTH_LONG).show()
            }
        }

    }
}