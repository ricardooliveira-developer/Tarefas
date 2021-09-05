package br.com.ricardo.developer.tarefas.viewmodel.AddTask

import android.content.Context
import br.com.ricardo.developer.tarefas.dao.cadastro.CadastroDao
import br.com.ricardo.developer.tarefas.model.Task

class AddTaskViewModel(val context: Context) {

    fun addTask(task: Task) {
        CadastroDao(context).inserirTarefa(task)
    }

    fun removerTask(idtask: Int){
        CadastroDao(context).deleteTarefa(idtask)
    }

    fun removerTask(task: Task){
        CadastroDao(context).updateTarefa(task)
    }

    fun retornaTask(): Task? {
        return CadastroDao(context).retornaTarefa()
    }
}