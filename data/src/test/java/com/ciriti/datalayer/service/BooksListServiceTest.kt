package com.ciriti.datalayer.service

import arrow.core.Either
import arrow.core.Left
import arrow.core.Right
import com.ciriti.datalayer.network.BookRemoteDatasource
import com.ciriti.datalayer.network.BooksListNullable
import com.ciriti.datalayer.network.toBooksList
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

class BooksListServiceTest {

    @MockK
    lateinit var bookRemoteDs: BookRemoteDatasource
    @MockK
    lateinit var logger: Logger

    val mockList by lazy {
        runBlocking {
            TestUtilGson.run { "books.json".createListObjByJsonFile<BooksListNullable>() }
                .toBooksList()
        }
    }

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true, relaxed = true)
    }

    @Test
    fun `fetch a books list successfully`() = runBlockingUnit {
        // preconditions
        coEvery { bookRemoteDs.getBooks(any(), any()) } returns Right(mockList)
        // system under test
        val sut = BooksService.create(bookRemoteDs, logger)
        val res = sut.getBooks("2018-09-01", "combined-print-and-e-book-fiction.json")
        // verify result
        (res as Either.Right).b.count() assertEquals mockList.results.books.count()
    }

    @Test
    fun `fetch a books list with error`() = runBlockingUnit {
        // preconditions
        coEvery {
            bookRemoteDs.getBooks(
                any(),
                any()
            )
        } returns Left(java.lang.RuntimeException("test"))
        // system under test
        val sut = BooksService.create(bookRemoteDs, logger)
        val res = sut.getBooks("2018-09-01", "combined-print-and-e-book-fiction.json")
        // verify result
        ((res as Either.Left).a as RuntimeException).localizedMessage assertEquals "test"
    }
}
