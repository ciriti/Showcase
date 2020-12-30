package com.ciriti.bookapp.ui.bookslist.components

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout

/**
 * In this case the fields of the view model are the of the service model
 */
data class Book4View(
    var rank: Int,
    var weeksOnList: Int,
    var primaryIsbn10: String,
    var title: String,
    var author: String
)

sealed class BaseState {
    data class StateLoading(val loading: Boolean) : BaseState()
    data class StateSuccess(val data: List<Book4View>) : BaseState()
    data class StateError(val errorMessage: String) : BaseState()
}

class BookItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr)
