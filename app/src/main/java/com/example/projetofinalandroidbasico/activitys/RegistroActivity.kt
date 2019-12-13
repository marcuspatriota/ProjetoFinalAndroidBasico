package com.example.projetofinalandroidbasico.activitys

import android.content.ContentValues
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projetofinalandroidbasico.AtividadeDataBase
import com.example.projetofinalandroidbasico.R


class RegistroActivity : AppCompatActivity() {
    private var dataBase = AtividadeDataBase(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val buttonCancelar = findViewById<Button>(R.id.activity_registro_button)
        val buttonEntrar = findViewById<Button>(R.id.activity_registro_button2)
        val login = findViewById<EditText>(R.id.activity_registro_editText6)
        val senha = findViewById<EditText>(R.id.activity_registro_editText7)
        val nome = findViewById<EditText>(R.id.activity_registro_editText3)
        val cpf = findViewById<EditText>(R.id.activity_registro_editText4)
        val email = findViewById<EditText>(R.id.activity_registro_editText5)

        buttonEntrar.setOnClickListener {
            if (!validateEmailFormat(email.text.toString())){
                Toast.makeText(this, "Email inválidos", Toast.LENGTH_SHORT).show()

            }else{
                insertUser(nome.text.toString(),login.text.toString(),senha.text.toString(),cpf.text.toString(),email.text.toString())
                finish()
            }

        }
        buttonCancelar.setOnClickListener {
            finish()
        }

    }
    private fun insertUser(nome:String, login: String, senha: String, cpf:String, email: String ){
        val db = dataBase.writableDatabase
        val values = ContentValues()
        values.put(AtividadeDataBase.USER_EMAIL, email)
        values.put(AtividadeDataBase.USER_NOME, nome)
        values.put(AtividadeDataBase.USER_CPF, cpf)
        values.put(AtividadeDataBase.USER_LOGIN, login)
        values.put(AtividadeDataBase.USER_SENHA, senha)

        db?.insert(AtividadeDataBase.TABLE_USER, null, values)
    }

    private fun validateEmailFormat(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
