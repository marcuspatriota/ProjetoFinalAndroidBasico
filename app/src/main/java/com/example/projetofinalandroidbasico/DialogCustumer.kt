package com.example.projetofinalandroidbasico

import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.projetofinalandroidbasico.activitys.AtividadesActivity

class DialogCustumer : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = activity!!.layoutInflater.inflate(R.layout.layout_dialog, null)
        val builder = AlertDialog.Builder(context!!)
           // .setTitle("Atividade")
            .setView(view)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                val  dia = view.findViewById<Spinner>(R.id.spndia).toString()
                val  atividades = view.findViewById<EditText>(R.id.layout_dialog_editText).text.toString()
                (activity as AtividadesActivity).criarAtividade(atividades,dia)
                dismiss()
            }
            .setNegativeButton(android.R.string.cancel) { _, _ ->
                dismiss()
            }

        return builder.create()
    }
}
