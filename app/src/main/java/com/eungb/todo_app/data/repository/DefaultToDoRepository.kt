package com.eungb.todo_app.data.repository

import com.eungb.todo_app.data.entity.ToDoEntity

class DefaultToDoRepository : ToDoRepository {

    override suspend fun getToDoList(): List<ToDoEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun insertToDoItem(toDoItem: ToDoEntity): Long {
        TODO("Not yet implemented")
    }

    override suspend fun insertToDoList(toDoList: List<ToDoEntity>) {
        TODO("Not yet implemented")
    }

    override suspend fun updateToDoItem(toDoItem: ToDoEntity): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getToDoItem(itemId: Long): ToDoEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAll() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteToDoItem(itemId: Long): Boolean {
        TODO("Not yet implemented")
    }
}