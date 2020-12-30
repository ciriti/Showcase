package com.ciriti.datalayer.network

import arrow.core.Either
import com.ciriti.datalayer.util.Logger
import com.util.test.TestUtilGson
import com.util.test.assertEquals
import com.util.test.runBlockingUnit
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class BooksRemoteDatasourceTest {

    @MockK
    lateinit var api: Api
    @MockK
    lateinit var logger: Logger
    @MockK
    lateinit var responseBody: ResponseBody

    val mockList by lazy {
        TestUtilGson.run { "books.json".createListObjByJsonFile<BooksListNullable>() }
    }

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true, relaxed = true)
    }

    @Test
    fun `fetch a books list successfully`() = runBlockingUnit {
        // preconditions
        coEvery { api.getBooksList(any(), any()) } returns Response.success(mockList)
        // system under test
        val sut = BookRemoteDatasource.create(api, logger) { RuntimeException("test") }
        val res = sut.getBooks("2018-09-01", "combined-print-and-e-book-fiction.json")
        // verify result
        (res as Either.Right).b.results.books.count() assertEquals mockList.results!!.books!!.count()
    }

    @Test
    fun `fetch a books list with error`() = runBlockingUnit {
        // preconditions
        coEvery { api.getBooksList(any(), any()) } returns Response.error<BooksListNullable>(
            404,
            responseBody
        )
        // system under test
        val sut = BookRemoteDatasource.create(api, logger) { RuntimeException("test") }
        val res = sut.getBooks("2018-09-01", "combined-print-and-e-book-fiction.json")
        // verify result
        ((res as Either.Left).a as RuntimeException).localizedMessage assertEquals "test"
    }
}
