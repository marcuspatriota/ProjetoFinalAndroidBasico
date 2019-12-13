package com.example.projetofinalandroidbasico.activitys

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.projetofinalandroidbasico.AtividadeDataBase
import com.example.projetofinalandroidbasico.R
import com.example.projetofinalandroidbasico.beans.Atividades

class LoginActivity : AppCompatActivity() {

    private var dataBase = AtividadeDataBase(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonCancelar = findViewById<Button>(R.id.activity_login_button)
        val buttonEntrar = findViewById<Button>(R.id.activity_login_button2)
        val textView = findViewById<EditText>(R.id.activity_login_editText2)
        val senha = findViewById<EditText>(R.id.activity_login_editText)

        buttonEntrar.setOnClickListener {
            if (isUser(textView.text.toString(),senha.text.toString())){
                val intent = Intent(this,
                    AtividadesActivity::class.java)
                intent.putExtra("login",textView.text.toString())
                startActivity(intent)
            }else{
                Toast.makeText(this, "Usuário ou Senha inválidos",Toast.LENGTH_SHORT).show()
            }

        }
        buttonCancelar.setOnClickListener {
            finish()
        }
    }
    private fun isUser(login:String, senha: String):Boolean{
        return dataBase.getIdUsuario(login,senha) > 0
    }
}
