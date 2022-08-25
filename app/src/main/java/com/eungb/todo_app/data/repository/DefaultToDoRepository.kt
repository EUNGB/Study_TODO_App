package com.eungb.todo_app.data.repository

import com.eungb.todo_app.data.entity.ToDoEntity

class DefaultToDoRepository: ToDoRepository {

    override suspend fun getToDoList(): List<ToDoEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun insertToDoList(toDoList: List<ToDoEntity>) {
        TODO("Not yet implemented")
    }
}