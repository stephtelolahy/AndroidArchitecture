package com.creativegames.taskapp.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.creativegames.taskapp.model.DataManager
import com.creativegames.taskapp.model.Task

class TasksViewModel(private val dataManager: DataManager) : ViewModel() {

    val tasksLiveData = MutableLiveData<List<Task>>()

    fun onViewCreated() {
        val data = dataManager.loadTasks()
        tasksLiveData.postValue(data.toMutableList())
    }

    fun onTaskAdded(name: String) {
        val tasks = tasksLiveData.value?.toMutableList() ?: return
        tasks.add(Task(name = name))
        dataManager.saveTasks(tasks)
        tasksLiveData.postValue(tasks)
    }

    fun onTaskUpdated(id: String, checked: Boolean) {
        val tasks = tasksLiveData.value ?: return
        tasks.first { it.id == id }.done = checked
        dataManager.saveTasks(tasks)
    }
}