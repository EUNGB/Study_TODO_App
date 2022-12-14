package com.eungb.todo_app.data.entity

data class ToDoEntity(
    val id: Long = 0,
    val title: String,
    val description: String,
    val hasCompleted: Boolean = false
)
