package br.com.ricardo.developer.tarefas.datasource

import android.content.Context
import br.com.ricardo.developer.tarefas.model.Task
import br.com.ricardo.developer.tarefas.viewmodel.AddTask.AddTaskViewModel

object TaskDataSource {
    private val list = arrayListOf<Task>()

    fun getList() = list.toList()

    fun insertTask(task: Task, context: Context) {
        if (task.id == 0) {
            list.add(task.copy(id = list.size + 1))
            AddTaskViewModel(context).addTask(task)
        } else {
            list.remove(task)
            list.add(task)
        }
    }

    fun findById(taskId: Int) = list.find { it.id == taskId }

    fun deleteTask(task: Task) {
        list.remove(task)
    }
}