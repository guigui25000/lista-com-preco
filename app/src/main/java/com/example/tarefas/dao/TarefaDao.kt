package com.example.tarefas.dao

import com.example.tarefas.models.Tarefa

class TarefaDao {

    fun salvar(tarefa: Tarefa){
        tarefas.add(tarefa)
    }

    fun buscarTarefa() : List<Tarefa>{
        return tarefas.toList()
    }

    companion object {
        private val tarefas =  mutableListOf<Tarefa>()
    }
}