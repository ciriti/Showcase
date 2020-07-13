package com.ciriti.datalayer.network

import com.ciriti.datalayer.BuildConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET(BuildConfig.URL + "svc/books/v3/lists/{date}/{name}")
    suspend fun getBooksList(@Path("date") date: String, @Path("name") name: String): Response<BooksListNullable>
}
