package com.example.projetofinalandroidbasico.activitys

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetofinalandroidbasico.*
import com.example.projetofinalandroidbasico.adapter.AtividadesAdapter
import com.example.projetofinalandroidbasico.beans.Atividades
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AtividadesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AtividadesAdapter
    private var atividadeDataBase = AtividadeDataBase(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atividades)
        val textView = findViewById<TextView>(R.id.activity_atividades_textView2)
        textView.text = "${textView.text.toString()} , ${intent.getStringExtra("login").toString()}"

        recyclerView = findViewById<RecyclerView>(R.id.activity_atividades_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter =
            AtividadesAdapter(
                mutableListOf<Atividades>()
            )
        recyclerView.adapter=adapter

        val buttonFloat = findViewById<FloatingActionButton>(R.id.activity_atividades_floatingActionButton)
        buttonFloat.setOnClickListener{

            val fm = supportFragmentManager
            val  dialogCustumer =
                DialogCustumer()
            dialogCustumer.show(fm, "DialogCustumer_tag")
        }

    }
//Inflamando o menu.
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    //Ação dos itens do menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.item_menu_distracao -> {
                var intentNews = Intent(this, DistracaoActivity::class.java)
                startActivity(intentNews)
                return true}
            else -> return super.onOptionsItemSelected(item)

        }
    }

    fun uptEditText(descAtividade:String){
        val atv =
            Atividades(descAtividade, "segunda")
        adapter.AddAtividade(atv)
    }

    fun criarAtividade(descAtividade:String, dia : String){
        val db = atividadeDataBase.writableDatabase
        val values = ContentValues().apply {
            put(AtividadeDataBase.ATV_DIA, dia)
            put(AtividadeDataBase.ATV_DESC, descAtividade)
        }
        db?.insert(AtividadeDataBase.TABLE_ATIVIDADES, null, values)

        val atv =
            Atividades(descAtividade, dia)
        adapter.AddAtividade(atv)

    }

}
