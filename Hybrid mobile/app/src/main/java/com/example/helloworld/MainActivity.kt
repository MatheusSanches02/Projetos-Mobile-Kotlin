package com.example.helloworld

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    // Criando a lista
    var tasks = ArrayList<String>();
    var adapter: ArrayAdapter<String>? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buscando os components em tela de acordo com o id
        val addTaskButton = findViewById<FloatingActionButton>(R.id.addButton);
        val listTaskView = findViewById<ListView>(R.id.listItens);

        // Criando o adpter
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tasks);
        listTaskView.adapter = adapter;

        // Click no botão de adicionar
        addTaskButton.setOnClickListener {
            addTask();
        };

        // Click no item da lista
        listTaskView.setOnItemClickListener { adapterView, view, index, id ->
            val task = adapterView.adapter.getItem(index).toString();
            updateTask(task, index);
        }
    }

    // Método para criar uma nova task
    fun addTask() {
        // Criando o dialog
        val dialog = AlertDialog.Builder(this );
        dialog.setTitle("New task");

        // Injetando os inputs do dialog
        val input = EditText(this );
        dialog.setView(input);

        // Criando ações das opções
        dialog.setPositiveButton("ok") { _, _ ->
            tasks.add(input.text.toString());
            adapter?.notifyDataSetChanged();
        }
        dialog.setNegativeButton("Cancel", null);

        // Criando a visualização em tela
        dialog.create().show();
    }

    // Método para atualizar um item da lista
    fun updateTask(task: String, index: Int) {
        // Criando o dialog
        val dialog = AlertDialog.Builder(this);
        dialog.setTitle("Update task");

        // Injetando os inputs do dialog
        val input = EditText(this );
        input.setText(task, TextView.BufferType.EDITABLE);
        dialog.setView(input);

        // Criando ações das opções
        dialog.setPositiveButton("ok") { _, _ ->
            tasks[index] = input.text.toString();
            adapter?.notifyDataSetChanged();
        }
        dialog.setNegativeButton("Cancel", null);
        dialog.setNeutralButton("Excluir") { _, _ ->
            tasks.removeAt(index);
            adapter?.notifyDataSetChanged();
        }

        // Criando a visualização em tela
        dialog.create().show();
    }
}