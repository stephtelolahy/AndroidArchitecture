package com.creativegames.taskapp.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.CheckBox
import com.creativegames.taskapp.R

class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
}