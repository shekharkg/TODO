package com.shekharkg.tml_todo.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.shekharkg.tml_todo.room.entity.ToDoEntity

@Dao
interface ToDoDao {

    @Insert
    fun insert(todo: ToDoEntity)

    @Query("SELECT * FROM ToDoEntity")
    fun getAll(): LiveData<List<ToDoEntity>>

    @Delete
    fun delete(todo: ToDoEntity)
}