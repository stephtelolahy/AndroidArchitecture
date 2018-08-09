package com.creativegames.taskapp

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.CheckBox

class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
}