package com.creativegames.taskapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.EditText
import android.widget.LinearLayout
import androidx.core.content.edit
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: TaskAdapter
    private lateinit var tasks: MutableList<Task>
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferences = this.getSharedPreferences("sharedPref", Context.MODE_PRIVATE)

        recycler_view.layoutManager = LinearLayoutManager(this)
        adapter = TaskAdapter { id, checked -> updateTask(id, checked) }
        recycler_view.adapter = adapter

        fab.setOnClickListener { showCreateTaskDialog() }

        loadTask()
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
            addTask(input.text.toString())
        }
        alertDialog.show()
    }

    private fun loadTask() {
        val groupsJsonString = preferences.getString("tasks", "[]")
        val groupsArray = Gson().fromJson(groupsJsonString, Array<Task>::class.java)
        tasks = groupsArray.asList().toMutableList()
        refresh()
    }

    private fun addTask(name: String) {
        tasks.add(Task(name = name))
        refresh()
        saveData()
    }

    private fun updateTask(id: String, checked: Boolean) {
        tasks.first { it.id == id }.done = checked
        saveData()
    }

    private fun refresh() {
        adapter.items = tasks
        adapter.notifyDataSetChanged()
    }


    private fun saveData() {
        val groupsJsonString = Gson().toJson(tasks)
        preferences.edit { putString("tasks", groupsJsonString) }
    }
}

