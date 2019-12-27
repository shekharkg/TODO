package com.shekharkg.tml_todo.ui.list

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.shekharkg.tml_todo.utils.InjectorUtils
import com.shekharkg.tml_todo.R
import com.shekharkg.tml_todo.ui.add.AddtaskActivity
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

        setupViews()

        setupObservers()
    }

    private fun setupViews() {
        fab.setOnClickListener {
            startActivity(Intent(this@ScrollingActivity, AddtaskActivity::class.java))
        }

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
