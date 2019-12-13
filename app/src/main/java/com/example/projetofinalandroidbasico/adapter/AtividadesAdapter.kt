package com.example.projetofinalandroidbasico.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetofinalandroidbasico.viwholder.AtividadesViewHolder
import com.example.projetofinalandroidbasico.R
import com.example.projetofinalandroidbasico.beans.Atividades


class AtividadesAdapter (private val atividades:MutableList<Atividades> ): RecyclerView.Adapter<AtividadesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AtividadesViewHolder {
        return AtividadesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_atividades,
                parent,
                false
            )
        )
    }
    override fun getItemCount(): Int {
        return atividades.size
    }

    override fun onBindViewHolder(holder: AtividadesViewHolder, position: Int) {
        holder.textView.text = atividades[position].descAtividade
        holder.dia?.setSelection(position)
        holder.buttonDelete.setOnClickListener{
            atividades.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, itemCount)
        }
        holder.buttonEdit.setOnClickListener {

        }
    }


    fun AddAtividade (atv: Atividades){
        /**
        val atividadeDataBase = AtividadeDataBase(this)
        val db = atividadeDataBase.writableDatabase
        val values = ContentValues().apply {
                put(AtividadeDataBase.ATV_DIA, atv.dia)
                put(AtividadeDataBase.ATV_DESC, atv.descAtividade)
            }
        db?.insert(AtividadeDataBase.TABLE_ATIVIDADES, null, values)
        **/
        atividades.add(atv)

        notifyItemInserted(itemCount)
    }


}