package com.ciriti.datalayer.util

import com.ciriti.datalayer.BuildConfig
import com.ciriti.datalayer.network.ApiKeyInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.security.InvalidParameterException

/**
 * factory method for the retrofit adapter
 */
inline fun <reified T> Retrofit.Builder.createAdapter(
    url: String,
    apiKey: String = BuildConfig.API_KEY
): T {

    val loginInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    /** add the api key */
    val apiInterceptor = ApiKeyInterceptor(apiKey)

    val client = OkHttpClient.Builder()
        .addInterceptor(apiInterceptor)
        .addInterceptor(loginInterceptor)
        .build()

    val builder = this
        .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
        .baseUrl(url)
        .client(client)
        .build()

    return builder.create(T::class.java)
}

/**
 * Throws an exception with the message in the parameter
 */
fun failFast(message: String): Nothing {
    throw InvalidParameterException(message)
}
