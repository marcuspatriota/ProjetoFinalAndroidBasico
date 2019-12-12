package com.example.projetofinalandroidbasico.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.projetofinalandroidbasico.R

class PrincipalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val buttonLogin = findViewById<Button>(R.id.activity_principal_button)
        val buttonRegistrar=findViewById<Button>(R.id.activity_principal_button2)

        buttonLogin.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        buttonRegistrar.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

    }
}
