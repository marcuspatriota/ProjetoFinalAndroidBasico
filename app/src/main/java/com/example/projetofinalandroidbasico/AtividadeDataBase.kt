package com.example.projetofinalandroidbasico

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.ContactsContract
import android.util.Log

class AtividadeDataBase (context: Context):SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {

        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "atividades.db"
        const val TABLE_ATIVIDADES = "ATIVIDADES"
        const val TABLE_USER = "USER"

        const val ATV_ID: String = "ATV_ID"
        const val ATV_DIA: String = "ATV_DIA"
        const val ATV_DESC: String = "ATV_DESC"
        const val ATV_ID_USER: String = "ATV_ID_USER"


        const val USER_ID: String = "USER_ID"
        const val USER_NOME: String = "USER_NOME"
        const val USER_CPF: String = "USER_CPF"
        const val USER_LOGIN: String = "USER_LOGIN"
        const val USER_EMAIL: String = "USER_EMAIL"
        const val USER_SENHA: String = "USER_SENHA"
    }
//criação das tabelas de banco de dados

    val DATABASE_CREATE =
        "CREATE TABLE if not exists $TABLE_ATIVIDADES (" +
                "$ATV_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$ATV_DIA VARCHAR," +
                "$ATV_DESC VARCHAR," +
                "$ATV_ID_USER INTEGER," +
                "CONSTRAINT FK_ATV_ID_USER FOREIGN KEY ($ATV_ID_USER) REFERENCES $TABLE_USER($USER_ID))"

    val DATABASE_USUARIO =
        "CREATE TABLE if not exists $TABLE_USER (" +
                "$USER_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$USER_NOME VARCHAR," +
                "$USER_CPF VARCHAR," +
                "$USER_LOGIN VARCHAR," +
                "$USER_EMAIL VARCHAR," +
                "$USER_SENHA VARCHAR" +
                ")"

    override fun onCreate(db: SQLiteDatabase?) {
        Log.d("MyDatabase", "Creating: $DATABASE_USUARIO")
        db?.execSQL(DATABASE_USUARIO)
        Log.d("MyDatabase", "Creating: $DATABASE_CREATE")
        db?.execSQL(DATABASE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_ATIVIDADES")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USER")
        onCreate(db)
    }

    fun getAtividades(idUser: Int):Cursor{
        return readableDatabase.query(TABLE_ATIVIDADES, arrayOf(ATV_ID, ATV_DESC, ATV_DIA, ATV_ID_USER), "$ATV_ID_USER = '$idUser'", null, null, null, null)
    }

    fun getIdUsuario (login:String, senha:String):Int{
        return readableDatabase.query(TABLE_USER, arrayOf(USER_ID, USER_LOGIN, USER_SENHA), "$USER_LOGIN = '$login' and $USER_SENHA= '$senha'", null, null, null, null).count

    }

    fun criarUser (nome:String, login: String, senha: String, cpf:String, email: String ){
        val values = ContentValues()
        values.put(USER_EMAIL, email)
        values.put(USER_NOME, nome)
        values.put(USER_CPF, cpf)
        values.put(USER_LOGIN, login)
        values.put(USER_SENHA, senha)

        readableDatabase.insert(TABLE_USER, null, values )
    }



}