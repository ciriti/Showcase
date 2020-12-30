package com.ciriti.datalayer.network

import com.ciriti.datalayer.BuildConfig
import com.ciriti.datalayer.util.createAdapter
import com.util.test.assertEquals
import com.util.test.runBlockingUnit
import org.junit.Test
import retrofit2.Retrofit

class NetworkTest {

    val adapter by lazy { Retrofit.Builder().createAdapter<Api>(BuildConfig.URL) }

    @Test
    fun `net test`() = runBlockingUnit {
        val res = adapter.getBooksList("2018-09-01", "combined-print-and-e-book-fiction.json")
        res.code() assertEquals 200
    }
}
