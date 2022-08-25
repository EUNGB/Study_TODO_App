package com.eungb.todo_app.presentation.list

import com.eungb.todo_app.data.entity.ToDoEntity

// State 패턴
sealed class ToDoListState {

    object UnInitialized: ToDoListState()
    object Loading : ToDoListState()
    data class Success(
        val toDoList: List<ToDoEntity>
    ): ToDoListState()
    object Error: ToDoListState()

}
