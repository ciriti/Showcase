package com.ciriti.bookapp.ui.bookslist

import androidx.lifecycle.LiveData // ktlint-disable
import androidx.lifecycle.MutableLiveData
import com.ciriti.bookapp.core.BaseViewModel
import com.ciriti.bookapp.ui.bookslist.components.BaseState
import com.ciriti.bookapp.ui.bookslist.components.BaseState.* // ktlint-disable
import com.ciriti.bookapp.ui.bookslist.components.Book4View
import com.ciriti.bookapp.ui.bookslist.components.getErrorMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class BooksListViewModel(
    private val useCase: BooksListUseCase,
    mainDispatcher: CoroutineContext = Dispatchers.Main,
    private val workerDispatcher: CoroutineContext = Dispatchers.IO
) : BaseViewModel(mainDispatcher) {

    private val mutableLiveData by lazy { MutableLiveData<BaseState>() }
    val liveData: LiveData<BaseState> get() = mutableLiveData

    fun loadBooks(date: String, name: String) {
        scope.launch {
            mutableLiveData.value = StateLoading(true)
            val result = withContext(workerDispatcher + job) { useCase.getListBooks(date, name) }
            mutableLiveData.value = StateLoading(false)
            result.fold(::onError, ::onSuccess)
        }
    }

    private fun onSuccess(data: List<Book4View>) {
        mutableLiveData.value = StateSuccess(data)
    }

    private fun onError(error: Throwable) {
        mutableLiveData.value = StateError(getErrorMessage(error))
    }
}
