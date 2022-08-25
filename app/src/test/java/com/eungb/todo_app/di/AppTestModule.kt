package com.eungb.todo_app.di

import androidx.room.Update
import com.eungb.todo_app.data.repository.TestToDoRepository
import com.eungb.todo_app.data.repository.ToDoRepository
import com.eungb.todo_app.domain.todo.*
import com.eungb.todo_app.presentation.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appTestModule = module {

    // UseCase
    factory { GetToDoListUseCase(get()) }
    factory { InsertToDoListUseCase(get()) }
    factory { UpdateToDoUseCase(get()) }
    factory { GetToDoItemUseCase(get()) }
    factory { DeleteAllToDoItemUseCase(get()) }

    // Repository
    single<ToDoRepository> { TestToDoRepository() }

    // ViewModel
    viewModel { ListViewModel(get(), get(), get()) }

}