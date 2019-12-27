package com.shekharkg.tml_todo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.shekharkg.tml_todo.room.Repository
import com.shekharkg.tml_todo.room.entity.ToDoEntity

class ToDoViewModel(
    private val repository: Repository
) : ViewModel() {

    val toDos: LiveData<List<ToDoEntity>>? = repository.getToDos()

    fun addNewTodo(todo: ToDoEntity) {
        repository.insert(todo)
    }

    fun deleteTodo(todo: ToDoEntity) {
        repository.delete(todo)
    }

}