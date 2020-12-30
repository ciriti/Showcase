package com.ciriti.bookapp.ui.bookslist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule // ktlint-disable
import androidx.lifecycle.Observer
import arrow.core.Either
import com.ciriti.bookapp.ui.bookslist.components.BaseState
import com.ciriti.bookapp.ui.bookslist.components.Book4View
import com.ciriti.bookapp.ui.bookslist.components.toBook4View
import com.ciriti.datalayer.network.BooksListNullable
import com.ciriti.datalayer.network.ServerException
import com.ciriti.datalayer.network.toBooksList
import com.util.test.* // ktlint-disable
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BooksListViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @MockK
    lateinit var useCase: BooksListUseCase
    @MockK
    lateinit var observer: Observer<BaseState>

    val mockList by lazy {
        runBlocking {
            TestUtilGson.run { "books.json".createListObjByJsonFile<BooksListNullable>() }
                .toBooksList()
                .results
                .books
                .fold(mutableListOf<Book4View>()) { acc, it ->
                    it.map { book -> acc.add(book.toBook4View()) }
                    acc
                }
                .toList()
        }
    }

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `load a books list successfully`() = runBlockingUnit {
        // preconditions
        coEvery { useCase.getListBooks(any(), any()) } returns Either.right(mockList)

        // system under test
        val sut = BooksListViewModel(
            mainDispatcher = Dispatchers.Unconfined,
            workerDispatcher = Dispatchers.Unconfined,
            useCase = useCase
        )

        val eventQueue = mutableListOf<BaseState>()
        sut.liveData.observeForever { eventQueue.add(it) }

        sut.loadBooks("2018-09-01", "combined-print-and-e-book-fiction.json")

        // verify result
        eventQueue.size assertEquals 3
        (eventQueue[0] as BaseState.StateLoading).loading.assertTrue()
        (eventQueue[1] as BaseState.StateLoading).loading.assertFalse()
        (eventQueue[2] as BaseState.StateSuccess).data.size assertEquals mockList.size
    }

    @Test
    fun `load a books list with error`() = runBlockingUnit {
        // preconditions
        coEvery { useCase.getListBooks(any(), any()) } returns Either.Left(ServerException("test"))

        // system under test
        val sut = BooksListViewModel(
            mainDispatcher = Dispatchers.Unconfined,
            workerDispatcher = Dispatchers.Unconfined,
            useCase = useCase
        )

        val eventQueue = mutableListOf<BaseState>()
        sut.liveData.observeForever { eventQueue.add(it) }

        sut.loadBooks("2018-09-01", "combined-print-and-e-book-fiction.json")

        // verify result
        eventQueue.size assertEquals 3
        (eventQueue[0] as BaseState.StateLoading).loading.assertTrue()
        (eventQueue[1] as BaseState.StateLoading).loading.assertFalse()
        (eventQueue[2] as BaseState.StateError).errorMessage assertEquals "Error on server"
    }
}
