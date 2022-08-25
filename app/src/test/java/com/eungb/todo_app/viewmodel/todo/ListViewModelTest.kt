package com.eungb.todo_app.viewmodel.todo

import com.eungb.todo_app.ViewModelTest
import com.eungb.todo_app.data.entity.ToDoEntity
import com.eungb.todo_app.domain.todo.GetToDoItemUseCase
import com.eungb.todo_app.domain.todo.InsertToDoListUseCase
import com.eungb.todo_app.presentation.list.ListViewModel
import com.eungb.todo_app.presentation.list.ToDoListState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.koin.test.inject

/**
 * [ListViewModel]을 테스트하기 위한 Unit Test Class
 *
 * 1. initData()
 * 2. test viewModel fetch
 * 3. test Item Update
 * 4. test Item Delete All
 *
 */
@OptIn(ExperimentalCoroutinesApi::class)
internal class ListViewModelTest : ViewModelTest() {

    private val viewModel: ListViewModel by inject()

    private val insertToDoListUseCase: InsertToDoListUseCase by inject()
    private val getToDoItemUseCase: GetToDoItemUseCase by inject()

    private val mockList = (0 until 10).map {
        ToDoEntity(
            id = it.toLong(),
            title = "title $it",
            description = "description $it",
            hasCompleted = false
        )
    }

    /**
     * UseCase
     * 1. InsertToDoListUseCase
     * 2. GetTodoItemUseCase
     */


    @Before
    fun init() {
        initData()
    }

    private fun initData() = runBlockingTest {
        insertToDoListUseCase(mockList)
    }

    // Test : 입력된 데이터를 불러와서 검증
    @Test
    fun `test viewModel fetch`(): Unit = runBlockingTest {
        val testObservable = viewModel.toDoListLiveData.test()

        viewModel.fetchData()

        testObservable.assertValueSequence(
            listOf(
                ToDoListState.UnInitialized,
                ToDoListState.Loading,
                ToDoListState.Success(mockList)
            )
        )
    }


    // Test : 데이터 업데이트 시 반영 여부 검증
    @Test
    fun `test Item Update`(): Unit = runBlockingTest {
        val todo = ToDoEntity(
            id = 1L,
            title = "title 1",
            description = "description 1",
            hasCompleted = true
        )
        viewModel.updateEntity(todo)

        assert((getToDoItemUseCase(todo.id)?.hasCompleted ?: false) == todo.hasCompleted)
    }

    // Test : 데이터를 전부 삭제햇을 때 빈상태로 보여지는지 검증
    @Test
    fun `test Item Delete All`(): Unit = runBlockingTest {
        val testObservable = viewModel.toDoListLiveData.test()
        viewModel.deleteAll()
        testObservable.assertValueSequence(
            listOf(
                ToDoListState.UnInitialized,
                ToDoListState.Loading,
                ToDoListState.Success(listOf())
            )
        )
    }

}