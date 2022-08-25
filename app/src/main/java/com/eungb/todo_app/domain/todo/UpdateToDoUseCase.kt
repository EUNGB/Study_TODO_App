package com.eungb.todo_app.domain.todo

import com.eungb.todo_app.data.entity.ToDoEntity
import com.eungb.todo_app.data.repository.ToDoRepository
import com.eungb.todo_app.domain.UseCase

internal class UpdateToDoUseCase(
    private val toDoRepository: ToDoRepository
) : UseCase {

    suspend operator fun invoke(toDoItem: ToDoEntity): Boolean {
        return toDoRepository.updateToDoItem(toDoItem)
    }

}