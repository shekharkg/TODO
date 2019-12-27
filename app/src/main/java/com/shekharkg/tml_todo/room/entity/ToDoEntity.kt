package com.shekharkg.tml_todo.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.shekharkg.tml_todo.extension.toDateTime

@Entity
data class ToDoEntity(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "timestamp") val timeStamp: Long
) {
    override fun toString(): String {
        return "{id: $uid, title: $title, description: $description, timestamp: ${timeStamp.toDateTime()}}"
    }
}