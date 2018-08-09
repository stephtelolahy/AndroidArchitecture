package com.creativegames.taskapp.view

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.EditText
import android.widget.LinearLayout
import com.creativegames.taskapp.R
import com.creativegames.taskapp.model.DataManager
import com.creativegames.taskapp.viewmodel.TasksViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: TaskAdapter
    private lateinit var viewModel: TasksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val dataManager = DataManager(preferences)
        viewModel = TasksViewModel(dataManager)

        recycler_view.layoutManager = LinearLayoutManager(this)
        adapter = TaskAdapter { id, checked -> viewModel.onTaskUpdated(id, checked) }
        recycler_view.adapter = adapter

        fab.setOnClickListener { showCreateTaskDialog() }

        viewModel.tasksLiveData.observe(this, Observer {
            it?.let {
                adapter.items = it
                adapter.notifyDataSetChanged()
            }
        })

        viewModel.onViewCreated()
    }

    private fun showCreateTaskDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle(getString(R.string.add_task_title))

        val input = EditText(this)
        val lp = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)
        input.layoutParams = lp
        alertDialog.setView(input)

        alertDialog.setPositiveButton(android.R.string.ok
        ) { _, _ ->
            viewModel.onTaskAdded(input.text.toString())
        }
        alertDialog.show()
    }
}

