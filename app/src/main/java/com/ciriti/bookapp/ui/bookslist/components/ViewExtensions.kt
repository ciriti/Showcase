package com.ciriti.bookapp.ui.bookslist.components

import android.view.View
import com.ciriti.bookapp.BuildConfig
import com.ciriti.bookapp.R
import com.ciriti.datalayer.network.Book
import com.ciriti.datalayer.network.ClientErrorException
import com.ciriti.datalayer.network.ServerException
import java.security.InvalidParameterException
import kotlinx.android.synthetic.main.item_list.view.*

fun Book.toBook4View() = Book4View(
    rank = rank.failIfNotValid("rank"),
    weeksOnList = weeksOnList,
    title = title,
    primaryIsbn10 = primaryIsbn10.failIfEmpty("primaryIsbn10"),
    author = author
)

fun String.failIfEmpty(name: String) = this.apply {
    if (this.isEmpty()) {
        throw InvalidParameterException("the $name cannot be null!!!")
    }
}

fun Int.failIfNotValid(name: String) = this.apply {
    if (this < 0) {
        throw InvalidParameterException("the $name cannot be null!!!")
    }
}

fun getErrorMessage(throwable: Throwable): String = when (throwable) {
    is ServerException -> "Error on server"
    is ClientErrorException -> "Error on client"
    else -> "Generic error"
}

fun BookItemView.bind(book: Book4View, pos: Int) {
    title.text = book.title
    authors.text = book.author
    val bg = if (pos % 2 == 0) R.color.even_bg else R.color.odd_bg
    item_bg.setBackgroundColor(resources.getColor(bg))
    if (BuildConfig.HIDDEN_ITEM_FIELDS) {
        rank.visibility = View.VISIBLE
        weeks.visibility = View.VISIBLE
    } else {
        rank.run {
            visibility = View.VISIBLE
            text = "rank: ${book.rank}"
        }
        weeks.run {
            visibility = View.VISIBLE
            text = "weeks: ${book.weeksOnList}"
        }
    }
}
