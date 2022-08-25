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

    suspend fun insertToDoList(toDoList: List<ToDoEntity>)

}