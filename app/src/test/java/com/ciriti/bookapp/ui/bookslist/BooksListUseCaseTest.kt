package com.ciriti.bookapp.ui.bookslist

import arrow.core.Either
import arrow.core.Left
import arrow.core.Right
import com.ciriti.datalayer.network.Book
import com.ciriti.datalayer.network.BooksListNullable
import com.ciriti.datalayer.network.toBooksList
import com.ciriti.datalayer.service.BooksService
import com.ciriti.datalayer.util.Logger
import com.util.test.TestUtilGson
import com.util.test.assertEquals
import com.util.test.runBlockingUnit
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class BooksListUseCaseTest {

    @MockK
    lateinit var booksService: BooksService
    @MockK
    lateinit var logger: Logger

    val mockList by lazy {
        runBlocking {
            TestUtilGson.run { "books.json".createListObjByJsonFile<BooksListNullable>() }
                .toBooksList()
                .results
                .books
                .fold(mutableListOf<Book>()) { acc, it ->
                    it.map { book -> acc.add(book) }
                    acc
                }
                .toList()
        }
    }

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true, relaxed = true)
    }

    @Test
    fun `load a books list into a data list for the view successfully`() = runBlockingUnit {
        // preconditions
        coEvery { booksService.getBooks(any(), any()) } returns Right(mockList)
        // system under test
        val sut = BooksListUseCase.create(booksService)
        val res = sut.getListBooks("2018-09-01", "combined-print-and-e-book-fiction.json")
        // verify result
        (res as Either.Right).b.count() assertEquals mockList.count()
    }

    @Test
    fun `load a books list into a data list for the view with error`() = runBlockingUnit {
        // preconditions
        coEvery {
            booksService.getBooks(
                any(),
                any()
            )
        } returns Left(java.lang.RuntimeException("test"))
        // system under test
        val sut = BooksListUseCase.create(booksService)
        val res = sut.getListBooks("2018-09-01", "combined-print-and-e-book-fiction.json")
        // verify result
        ((res as Either.Left).a as RuntimeException).localizedMessage assertEquals "test"
    }
}
