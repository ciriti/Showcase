package com.ciriti.datalayer.service

import arrow.core.Either
import com.ciriti.datalayer.network.Book
import com.ciriti.datalayer.network.BookRemoteDatasource
import com.ciriti.datalayer.util.Logger

interface BooksService {
    suspend fun getBooks(date: String, name: String): Either<Throwable, List<Book>>

    companion object
}

fun BooksService.Companion.create(netDatasource: BookRemoteDatasource, logger: Logger): BooksService =
    BooksServiceImpl(netDatasource, logger)

/**
 * This class will collect the local and remote datasource.
 * This is the right place to place the logic for caching etc..
 */
private class BooksServiceImpl(
    val netDatasource: BookRemoteDatasource,
    val logger: Logger
) : BooksService {

    /**
     * Here I'm going to:
     *      - check each parameter of each book
     *      - transform the network bean into a safe bean to be used into the app
     */
    override suspend fun getBooks(date: String, name: String): Either<Throwable, List<Book>> {

        return netDatasource.getBooks(date, name).map {
            it.results.books.fold(mutableListOf<Book>()) { acc, monad ->
                monad.map { value -> acc.add(value) }
                acc
            }.toList()
        }
    }
}
