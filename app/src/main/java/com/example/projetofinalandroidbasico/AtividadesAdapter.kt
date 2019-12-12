package com.example.projetofinalandroidbasico

import android.content.ContentValues
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetofinalandroidbasico.beans.Atividades
import kotlin.concurrent.timer


class AtividadesAdapter (private val atividades:MutableList<Atividades> ): RecyclerView.Adapter<AtividadesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AtividadesViewHolder {
        return AtividadesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_atividades,parent,false))
    }
    override fun getItemCount(): Int {
        return atividades.size
    }

    override fun onBindViewHolder(holder: AtividadesViewHolder, position: Int) {
        holder.textView.text = atividades[position].descAtividade
        val diaDefault:String = "Domingo"
        holder.dia.selectedItem.toString()=atividades[position].dia?: diaDefault
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