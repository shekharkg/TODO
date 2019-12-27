package com.shekharkg.tml_todo.utils

import android.app.Application
import com.shekharkg.tml_todo.room.Repository
import com.shekharkg.tml_todo.ui.list.ToDoViewModelFactory

object InjectorUtils {

    private fun getRepository(application: Application): Repository {
        return Repository.getInstance(application)
    }

    /**
     * Static method used to inject classes needed for [ScrollingActivity].
     */
    fun provideToDoViewModelFactory(application: Application): ToDoViewModelFactory {
        val repository = getRepository(application)
        return ToDoViewModelFactory(repository)
    }

}