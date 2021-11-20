package com.example.tarefas.ui.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.tarefas.R
import com.example.tarefas.dao.TarefaDao
import com.example.tarefas.ui.components.ListaTarefaAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaTarefas : AppCompatActivity(R.layout.activity_lista_tarefas) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        configRecycleView()
        configBotaoSalvar()
    }

    fun configRecycleView(){
        val listaTarefaView = findViewById<RecyclerView>(R.id.lista_tarefas)
        listaTarefaView.adapter = ListaTarefaAdapter(TarefaDao().buscarTarefa(), this)
    }
    fun configBotaoSalvar(){
        val btnAdd = findViewById<FloatingActionButton>(R.id.btn_add_tarefa)
        btnAdd.setOnClickListener {
            val intent = Intent(this, FormularioTarefa::class.java)
            startActivity(intent)
        }
    }
}