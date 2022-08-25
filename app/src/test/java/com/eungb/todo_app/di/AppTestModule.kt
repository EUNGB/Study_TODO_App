package com.eungb.todo_app.di

import com.eungb.todo_app.data.repository.TestToDoRepository
import com.eungb.todo_app.data.repository.ToDoRepository
import com.eungb.todo_app.domain.todo.GetToDoListUseCase
import com.eungb.todo_app.domain.todo.InsertToDoListUseCase
import com.eungb.todo_app.presentation.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appTestModule = module {

    // UseCase
    factory { GetToDoListUseCase(get()) }
    factory { InsertToDoListUseCase(get()) }

    // Repository
    single<ToDoRepository> { TestToDoRepository() }

    // ViewModel
    viewModel { ListViewModel(get()) }

}