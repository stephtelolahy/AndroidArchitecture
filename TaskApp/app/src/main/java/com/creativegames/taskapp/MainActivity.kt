package com.creativegames.taskapp

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.EditText
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = TaskAdapter()
        adapter.tasks = arrayListOf(Task("Game of thrones"),
                Task("Walking dead", true),
                Task("Big bang theory", true))

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter

        fab.setOnClickListener { showCreateTaskDialog() }
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
            val text = input.text.toString()
            adapter.tasks.add(Task(text))
            adapter.notifyDataSetChanged()
        }
        alertDialog.show()
    }
}
