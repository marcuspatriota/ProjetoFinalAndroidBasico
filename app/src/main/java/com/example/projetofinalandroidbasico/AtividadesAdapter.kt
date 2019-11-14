package com.example.projetofinalandroidbasico

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class AtividadesAdapter (private val atividades:MutableList<Atividades> ): RecyclerView.Adapter<AtividadesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AtividadesViewHolder {
        return AtividadesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_atividades,parent,false))
    }
    override fun getItemCount(): Int {
        return atividades.size
    }

    override fun onBindViewHolder(holder: AtividadesViewHolder, position: Int) {
        holder.textView.text = atividades[position].descAtividade
        holder.buttonDelete.setOnClickListener{
            atividades.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, itemCount)
        }
        holder.buttonEdit.setOnClickListener {

        }
    }

    fun AddAtividade (atv:Atividades){
        atividades.add(atv)
        notifyItemInserted(itemCount)
    }


}