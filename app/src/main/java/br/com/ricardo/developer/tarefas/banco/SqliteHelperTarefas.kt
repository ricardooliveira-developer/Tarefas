package br.com.ricardo.developer.tarefas.banco

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import br.com.ricardo.developer.tarefas.banco.scripts.cadastro.tabelaTarefas
import java.util.*

class SqliteHelperTarefas(
    context: Context,
    nome: String,
    factory: SQLiteDatabase.CursorFactory?,
    versao: Int,
) : SQLiteOpenHelper(context, nome, factory, versao) {

    override fun onCreate(db: SQLiteDatabase?) {
        try {

            val sb = StringBuilder()

            sb.append(tabelaTarefas())

            val comandos = sb.toString().split("#")

            for (i in comandos.indices) {
                db?.execSQL(comandos[i].lowercase(Locale.getDefault()))
            }

        } catch (e: Exception) {
            e.message
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        try {


        } catch (e: Exception) {
            e.message
        }
    }

}