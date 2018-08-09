package com.creativegames.taskapp

import java.util.*

data class Task(val id: String = "${UUID.randomUUID()}",
                val name: String,
                var done: Boolean = false)