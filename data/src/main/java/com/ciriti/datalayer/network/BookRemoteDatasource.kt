package com.ciriti.datalayer.network

import arrow.core.Either
import com.ciriti.datalayer.util.Logger
import com.ciriti.datalayer.util.failFast
import kotlinx.coroutines.coroutineScope

interface BookRemoteDatasource {
    suspend fun getBooks(date: String, name: String): Either<Throwable, BooksList>

    companion object
}

fun BookRemoteDatasource.Companion.create(
    api: Api,
    logger: Logger,
    errorMapping: (Int) -> Throwable
): BookRemoteDatasource = BookRemoteDatasourceImpl(api, logger, errorMapping)

private class BookRemoteDatasourceImpl(
    val api: Api,
    val logger: Logger,
    val errorMapping: (Int) -> Throwable
) : BookRemoteDatasource {

    override suspend fun getBooks(date: String, name: String): Either<Throwable, BooksList> =
        coroutineScope {
            logger.info(
                "thread type",
                "${Thread.currentThread().name} ${this.javaClass.simpleName}  "
            )
            /** here if anything will crash the Try factory will
             * return automatically an Either.Left obj */
            /** here if anything will crash the Try factory will
             * return automatically an Either.Left obj */
            Either.catch {
                api.getBooksList(date, name).let {
                    when (it.isSuccessful) {
                        true -> it.body()?.toBooksList() ?: failFast("Response body is null!!!")
                        else -> throw errorMapping(it.code())
                    }
                }
            }
        }
}
