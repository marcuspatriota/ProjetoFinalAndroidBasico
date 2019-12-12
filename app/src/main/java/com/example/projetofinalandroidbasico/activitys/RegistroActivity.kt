package com.example.projetofinalandroidbasico.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.projetofinalandroidbasico.R

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val buttonCancelar = findViewById<Button>(R.id.activity_registro_button)
        val buttonEntrar = findViewById<Button>(R.id.activity_registro_button2)
        val login = findViewById<EditText>(R.id.activity_registro_editText6)

        buttonEntrar.setOnClickListener {
            val intent = Intent(this, AtividadesActivity::class.java)
            intent.putExtra("login", login.text.toString())
            startActivity(intent)
        }
        buttonCancelar.setOnClickListener {
            finish()
        }

    }
}
