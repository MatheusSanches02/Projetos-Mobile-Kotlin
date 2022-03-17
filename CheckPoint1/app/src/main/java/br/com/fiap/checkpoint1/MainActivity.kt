package br.com.fiap.checkpoint1

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_calculadora.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIntegrantes.setOnClickListener(){
            integrantes()
        }
        btnCalc.setOnClickListener{view : View? ->
            var intentResultado = Intent(this, Calculadora::class.java);
            intentResultado.putExtra("msg", "teste")
            startActivity(intentResultado)
        }

    }



    fun integrantes(){
        val dialog = AlertDialog.Builder(this);
        dialog
            .setTitle("Integrantes: ")
            .setMessage("""Danielle Lobo 
                    |Giovanna França
                    |Matheus Sanches
                    """.trimMargin("|"))
            .setPositiveButton("Ok", null)
        dialog.create().show()

    }
}

