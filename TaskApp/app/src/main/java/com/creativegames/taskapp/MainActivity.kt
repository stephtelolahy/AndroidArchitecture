package com.creativegames.taskapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
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
    }
}
