package com.ciriti.datalayer.network

import arrow.core.Either
import com.ciriti.datalayer.util.failFast
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.coroutineScope

/**
 * Nullable model
 */
class BooksListNullable(
    @SerializedName("status") var status: String?,
    @SerializedName("results") var results: ResultsNullable?
)

class ResultsNullable(@SerializedName("books") var books: List<BookNullable>?)

class BookNullable(
    @SerializedName("rank") var rank: Int?,
    @SerializedName("weeks_on_list") var weeksOnList: Int?,
    @SerializedName("primary_isbn10") var primaryIsbn10: String?,
    @SerializedName("title") var title: String?,
    @SerializedName("author") var author: String?
)

/**
 * Not Nullable model
 */

class BooksList(
    var status: String,
    var results: Results
)

class Results(var books: List<Either<Throwable, Book>>)

class Book(
    var rank: Int,
    var weeksOnList: Int,
    var primaryIsbn10: String,
    var title: String,
    var author: String
)

/**
 * Model's extensions
 */

fun BookNullable.toBook() = Book(
    rank = rank ?: failFast("Parameter rank not valid!!!"),
    author = author ?: failFast("Parameter author not valid!!!"),
    primaryIsbn10 = primaryIsbn10 ?: failFast("Parameter primaryIsbn10 not valid!!!"),
    title = title ?: failFast("Parameter title not valid!!!"),
    weeksOnList = weeksOnList ?: failFast("Parameter weeksOnList not valid!!!")
)

suspend fun BooksListNullable.toBooksList() = coroutineScope {
    BooksList(
        results = results?.toResults() ?: failFast("Parameter results not valid!!!"),
        status = status ?: failFast("Parameter status not valid!!!")
    )
}

suspend fun ResultsNullable.toResults() = coroutineScope {
    Results(
        books = books?.map { Either.catch { it.toBook() } }
            ?: failFast("Parameter books not valid!!!")
    )
}
