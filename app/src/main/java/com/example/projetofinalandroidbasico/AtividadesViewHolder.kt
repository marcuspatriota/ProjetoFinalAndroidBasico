package com.example.projetofinalandroidbasico

import android.view.View
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AtividadesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var textView: TextView = itemView.findViewById(R.id.layout_atividades_textView)
    var dia: Spinner = itemView.findViewById(R.id.spndia)
    var buttonDelete: ImageButton = itemView.findViewById(R.id.layout_atividades_button2)
    var buttonEdit: ImageButton = itemView.findViewById(R.id.layout_atividades_button)
}