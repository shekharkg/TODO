package com.shekharkg.tml_todo.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shekharkg.tml_todo.room.dao.ToDoDao
import com.shekharkg.tml_todo.room.entity.ToDoEntity

@Database(entities = [ToDoEntity::class], version = 1)
abstract class ToDoDB: RoomDatabase() {

    abstract fun todoDao(): ToDoDao

}