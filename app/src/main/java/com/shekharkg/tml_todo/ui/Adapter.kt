package com.shekharkg.tml_todo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shekharkg.tml_todo.R
import com.shekharkg.tml_todo.extension.toDateTime
import com.shekharkg.tml_todo.room.entity.ToDoEntity
import kotlinx.android.synthetic.main.item_todo.view.*

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var todos: List<ToDoEntity>? = null

    fun resetList(todos: List<ToDoEntity>?) {
        this.todos = todos
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_todo, null)
        )
    }

    override fun getItemCount(): Int {
        return todos?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(todos?.get(position))
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(entity: ToDoEntity?) {
            itemView.labelTitle.text = entity?.title
            itemView.labelDescription.text = entity?.description
            itemView.labelTimeStamp.text = entity?.timeStamp?.toDateTime()
        }
    }
}