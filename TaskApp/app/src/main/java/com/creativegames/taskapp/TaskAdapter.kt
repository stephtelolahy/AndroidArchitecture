package com.creativegames.taskapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup


class TaskAdapter : RecyclerView.Adapter<TaskViewHolder>() {

    var tasks = ArrayList<Task>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): TaskViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_task, viewGroup, false)
        return TaskViewHolder(v)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(viewHolder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        viewHolder.checkBox.text = task.name
        viewHolder.checkBox.isChecked = task.done
    }

}