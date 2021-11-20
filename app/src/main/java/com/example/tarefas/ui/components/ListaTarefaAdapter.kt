package com.example.tarefas.ui.components

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tarefas.R
import com.example.tarefas.models.Tarefa

class ListaTarefaAdapter(
    private val tarefas: List<Tarefa>,
    private val context: Context
) : RecyclerView.Adapter<ListaTarefaAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun vincular(tarefas: Tarefa){
            val itemTitulo = itemView.findViewById<TextView>(R.id.item)
            itemTitulo.text = tarefas.titulo

            val descricao = itemView.findViewById<TextView>(R.id.item_descricao)
            descricao.text = tarefas.descricao

            val preco = itemView.findViewById<TextView>(R.id.item_preco)
            preco.text = "R$: "+tarefas.preco
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_tarefa, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tarefas =  tarefas[position]
        holder.vincular(tarefas)
    }

    override fun getItemCount(): Int = tarefas.size
}