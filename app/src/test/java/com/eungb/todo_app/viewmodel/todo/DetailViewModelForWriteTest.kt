package com.eungb.todo_app.viewmodel.todo

import com.eungb.todo_app.ViewModelTest
import com.eungb.todo_app.data.entity.ToDoEntity
import com.eungb.todo_app.domain.todo.InsertToDoItemUseCase
import com.eungb.todo_app.presentation.detail.DetailMode
import com.eungb.todo_app.presentation.detail.DetailViewModel
import com.eungb.todo_app.presentation.detail.ToDoDetailState
import com.eungb.todo_app.presentation.list.ListViewModel
import com.eungb.todo_app.presentation.list.ToDoListState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.koin.core.parameter.parametersOf
import org.koin.test.inject

/**
 * [DetailViewModel]을 테스트하기 위한 Unit Test Class
 *
 * 1. test viewModel fetch
 * 2. test insert todo
 *
 */
@OptIn(ExperimentalCoroutinesApi::class)
internal class DetailViewModelForWriteTest : ViewModelTest() {

    private val id = 0L

    private val detailViewModel: DetailViewModel by inject<DetailViewModel> { parametersOf(DetailMode.WRITE, id) }
    private val listViewModel: ListViewModel by inject()

    private val insertToDoItemUseCase: InsertToDoItemUseCase by inject()

    private val todo = ToDoEntity(
        id = id,
        title = "title $id",
        description = "description $id",
        hasCompleted = false
    )

    @Test
    fun `test viewModel fetch`(): Unit = runBlockingTest {
        val testObservable = detailViewModel.toDoDetailLiveData.test()
        detailViewModel.fetchData()

        testObservable.assertValueSequence(
            listOf(
                ToDoDetailState.UnInitialized,
                ToDoDetailState.Write
            )
        )
    }

    @Test
    fun `test insert todo`(): Unit = runBlockingTest {
        val detailTestObservable = detailViewModel.toDoDetailLiveData.test()
        val listObservable = listViewModel.toDoListLiveData.test()

        detailViewModel.writeToDo(
            title = todo.title,
            description = todo.description
        )


        detailTestObservable.assertValueSequence(
            listOf(
                ToDoDetailState.UnInitialized,
                ToDoDetailState.Loading,
                ToDoDetailState.Success(todo)
            )
        )

        assert(detailViewModel.detailMode == DetailMode.DETAIL)
        assert(detailViewModel.id == id)

        // 뒤로가기 후 리스트 검증
        listViewModel.fetchData()
        listObservable.assertValueSequence(
            listOf(
                ToDoListState.UnInitialized,
                ToDoListState.Loading,
                ToDoListState.Success(listOf(todo))
            )
        )
    }

}