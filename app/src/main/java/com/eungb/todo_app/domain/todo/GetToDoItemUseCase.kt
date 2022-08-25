package com.eungb.todo_app.domain.todo

import com.eungb.todo_app.data.entity.ToDoEntity
import com.eungb.todo_app.data.repository.ToDoRepository
import com.eungb.todo_app.domain.UseCase

internal class GetToDoItemUseCase(
    private val toDoRepository: ToDoRepository
) : UseCase {

    suspend operator fun invoke(itemId: Long): ToDoEntity? {
        return toDoRepository.getToDoItem(itemId)
    }
}