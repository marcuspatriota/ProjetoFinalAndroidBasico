package com.example.projetofinalandroidbasico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AtividadesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter:AtividadesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atividades)
        val textView = findViewById<TextView>(R.id.activity_atividades_textView2)
        textView.text = "${textView.text.toString()} , ${intent.getStringExtra("login").toString()}"

        recyclerView = findViewById<RecyclerView>(R.id.activity_atividades_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = AtividadesAdapter(mutableListOf<Atividades>())
        recyclerView.adapter=adapter

        val buttonFloat = findViewById<FloatingActionButton>(R.id.activity_atividades_floatingActionButton)
        buttonFloat.setOnClickListener{

            val fm = supportFragmentManager
            val  dialogCustumer = DialogCustumer()
            dialogCustumer.show(fm, "DialogCustumer_tag")
        }

    }
    fun uptEditText(descAtividade:String){
        val atv = Atividades(descAtividade)
        adapter.AddAtividade(atv)
    }
}
