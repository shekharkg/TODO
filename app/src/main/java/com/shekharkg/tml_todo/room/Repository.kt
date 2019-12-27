package com.shekharkg.tml_todo.room

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.shekharkg.tml_todo.room.entity.ToDoEntity

class Repository private constructor(private val application: Application) {

    // For Singleton instantiation
    companion object {
        @Volatile
        private var sInstance: Repository? = null

        fun getInstance(application: Application) = sInstance ?: synchronized(this) {
            sInstance ?: Repository(application).also { sInstance = it }
        }
    }

    private val mDb: ToDoDB? =
        Room.databaseBuilder(application, ToDoDB::class.java, "todo_db")
            .fallbackToDestructiveMigration().build()


    private val toDos: LiveData<List<ToDoEntity>>? = mDb?.todoDao()?.getAll()
    fun getToDos(): LiveData<List<ToDoEntity>>? = toDos

    fun insert(todo: ToDoEntity) {
        Thread {
            mDb?.todoDao()?.insert(todo)
        }.start()
    }

    fun delete(todo: ToDoEntity) {
        Thread {
            mDb?.todoDao()?.delete(todo)
        }.start()
    }


}