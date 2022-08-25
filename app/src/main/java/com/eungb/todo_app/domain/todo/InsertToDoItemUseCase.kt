package com.eungb.todo_app.domain.todo

import com.eungb.todo_app.data.entity.ToDoEntity
import com.eungb.todo_app.data.repository.ToDoRepository
import com.eungb.todo_app.domain.UseCase

internal class InsertToDoItemUseCase(
    private val toDoRepository: ToDoRepository
) : UseCase {

    suspend operator fun invoke(todoItem: ToDoEntity): Long {
        toDoRepository.insertToDoItem(todoItem)
        return todoItem.id
    }

}