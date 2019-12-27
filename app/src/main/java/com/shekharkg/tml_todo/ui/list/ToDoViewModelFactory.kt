package com.shekharkg.tml_todo.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shekharkg.tml_todo.room.Repository

class ToDoViewModelFactory(
    private val repository: Repository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ToDoViewModel(repository) as T
    }
}