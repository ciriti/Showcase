package com.ciriti.bookapp.ui.bookslist

import arrow.core.Either
import com.ciriti.bookapp.ui.bookslist.components.Book4View
import com.ciriti.bookapp.ui.bookslist.components.toBook4View
import com.ciriti.datalayer.service.BooksService

interface BooksListUseCase {
    suspend fun getListBooks(date: String, name: String): Either<Throwable, List<Book4View>>

    companion object
}

fun BooksListUseCase.Companion.create(
    booksService: BooksService
): BooksListUseCase =
    BooksListUseCaseImpl(booksService)

/**
 * This is the place to build view data model
 */
private class BooksListUseCaseImpl(val booksService: BooksService) :
    BooksListUseCase {

    override suspend fun getListBooks(
        date: String,
        name: String
    ): Either<Throwable, List<Book4View>> {
        return booksService.getBooks(date, name)
            .map { list -> list.map { it.toBook4View() } }
    }
}
