package com.shekharkg.tml_todo.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.shekharkg.tml_todo.InjectorUtils
import com.shekharkg.tml_todo.R
import kotlinx.android.synthetic.main.activity_scrolling.*
import kotlinx.android.synthetic.main.content_scrolling.*

class ScrollingActivity : AppCompatActivity() {

    private lateinit var adapter: Adapter

    private val mViewModel: ToDoViewModel by lazy {
        ViewModelProviders.of(
            this,
            InjectorUtils.provideToDoViewModelFactory(application)
        ).get(ToDoViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }


        setupViews()
        setupObservers()
    }

    private fun setupViews() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = Adapter()
        recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        mViewModel.toDos?.observe(this, Observer { todos ->
            if (todos.isNullOrEmpty()) labelEmptyList.visibility = View.VISIBLE
            else labelEmptyList.visibility = View.GONE

            adapter.resetList(todos)
            adapter.notifyDataSetChanged()
        })
    }
}
