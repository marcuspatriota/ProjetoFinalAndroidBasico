package com.example.projetofinalandroidbasico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonCancelar = findViewById<Button>(R.id.activity_login_button)
        val buttonEntrar = findViewById<Button>(R.id.activity_login_button2)
        val textView = findViewById<EditText>(R.id.activity_login_editText2)

        buttonEntrar.setOnClickListener {
            val intent = Intent(this,AtividadesActivity::class.java)
            intent.putExtra("login",textView.text.toString())
            startActivity(intent)
        }
        buttonCancelar.setOnClickListener {
            finish()
        }
    }

}
