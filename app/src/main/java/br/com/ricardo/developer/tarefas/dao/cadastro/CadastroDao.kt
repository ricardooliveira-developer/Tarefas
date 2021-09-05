package br.com.ricardo.developer.tarefas.dao.cadastro

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import br.com.ricardo.developer.tarefas.banco.Dao
import br.com.ricardo.developer.tarefas.banco.scripts.cadastro.selectRetornaTarefas
import br.com.ricardo.developer.tarefas.model.Task

class CadastroDao(
    context: Context,
) : Dao(context) {

    companion object {
        const val TABELA = "tarefas"
        const val ID = "id"
        const val NOME = "nome"
        const val DATA = "data"
        const val HORA = "hora"
    }

    fun inserirTarefa(Tarefa: Task) {
        try {

            openConnection()

            val cv = ContentValues()

            cv.put(NOME, Tarefa.title)
            cv.put(DATA, Tarefa.date)
            cv.put(HORA, Tarefa.hour)

            db?.insert(TABELA, null, cv)

            closeConnection()

        } catch (e: Exception) {
            e.message
        }
    }

    fun updateTarefa(Tarefa: Task) {
        try {

            openConnection()

            val cv = ContentValues()

            cv.put(NOME, Tarefa.title)
            cv.put(DATA, Tarefa.date)
            cv.put(HORA, Tarefa.hour)

            db?.update(TABELA, cv, null, null)

            closeConnection()

        } catch (e: Exception) {
            e.message
        }
    }

    fun deleteTarefa(idtask: Int) {
        try {

            openConnection()

            db?.delete(TABELA, null, null)

            closeConnection()

        } catch (e: Exception) {
            e.message
        }
    }

    fun retornaTarefa(): Task? {

        try {

            openConnection()

            val comando = selectRetornaTarefas(TABELA)

            val cursor: Cursor? = db?.rawQuery(comando, null)

            cursor!!.moveToFirst()

            if (cursor.count == 0)
                return null

            val tarefa = Task(
                cursor.getString(cursor.getColumnIndex(NOME)),
                cursor.getString(cursor.getColumnIndex(HORA)),
                cursor.getString(cursor.getColumnIndex(DATA)),
                cursor.getInt(cursor.getColumnIndex(ID))
            )

            cursor.close()

            closeConnection()

            return tarefa

        } catch (e: Exception) {
            e.message
            return null
        }
    }
}
