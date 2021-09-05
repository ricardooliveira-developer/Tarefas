package br.com.ricardo.developer.tarefas.banco

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import br.com.ricardo.developer.tarefas.util.constantes.bd.BancoConstantes

open class Dao(
    private val context: Context
) {

    protected var db: SQLiteDatabase? = null

    fun openConnection() {
        val dbHelper = SqliteHelperTarefas(
            context,
            BancoConstantes.NOME,
            null,
            BancoConstantes.VERSAO
        )

        this.db = dbHelper.writableDatabase
    }

    fun closeConnection() {
        db?.close()
        db = null
    }
}