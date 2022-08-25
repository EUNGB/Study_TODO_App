package com.eungb.todo_app.data.repository

import com.eungb.todo_app.data.entity.ToDoEntity


/**
 * 1. insertToDoList
 * 2. getToDoList
 *
 * Coroutine 사용
 */

interface ToDoRepository {

    suspend fun getToDoList(): List<ToDoEntity>

    suspend fun insertToDoItem(toDoItem: ToDoEntity): Long

    suspend fun insertToDoList(toDoList: List<ToDoEntity>)

    suspend fun updateToDoItem(toDoItem: ToDoEntity): Boolean

    suspend fun getToDoItem(itemId: Long): ToDoEntity?

    suspend fun deleteAll()

    suspend fun deleteToDoItem(itemId: Long): Boolean

}