package com.example.tarefas.ui.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.tarefas.R
import com.example.tarefas.dao.TarefaDao
import com.example.tarefas.models.Tarefa

class FormularioTarefa : AppCompatActivity(R.layout.activity_formulario_tarefa) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        confiBotaoSalvar()

    }

    fun confiBotaoSalvar(){
        val btnSalvar = findViewById<Button>(R.id.form_btn_salvar)
        btnSalvar.setOnClickListener {
            salvarTarefa()
        }
    }

    fun salvarTarefa(){
        val textTitulo = findViewById<EditText>(R.id.form_titulo)
        val textDescricao = findViewById<EditText>(R.id.form_descricao)
        val textPreco = findViewById<EditText>(R.id.form_preco)
        val titulo = textTitulo.text.toString()
        val descricao = textDescricao.text.toString()
        val preco = textPreco.text.toString()

        val novaTarefa =  Tarefa(titulo, descricao, preco)
        TarefaDao().salvar(novaTarefa)
        Log.i("FormularioTarefa", "titulo: $titulo")
        Log.i("FormularioTarefa", "descricao: $descricao")
        Log.i("FormularioTarefa", "tarefa $novaTarefa")

        AlertDialog.Builder(this)
            .setTitle("Adicionado com sucesso")
            .setMessage("Tarefa $titulo adicionada com sucesso")
            .setPositiveButton("Ok"){_,_ ->  finish() }
            .show()

    }
}