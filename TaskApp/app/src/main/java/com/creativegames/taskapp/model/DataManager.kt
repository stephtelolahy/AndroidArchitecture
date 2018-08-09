package com.creativegames.taskapp.model

import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson

class DataManager(private val preferences: SharedPreferences) {

    companion object {
        const val key = "tasks"
    }

    fun loadTasks(): List<Task> {
        val json = preferences.getString(key, "[]")
        val array = Gson().fromJson(json, Array<Task>::class.java)
        return array.asList()
    }

    fun saveTasks(tasks: List<Task>) {
        val json = Gson().toJson(tasks)
        preferences.edit { putString(key, json) }
    }
}