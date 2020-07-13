package com.ciriti.bookapp.core

import androidx.lifecycle.ViewModel // ktlint-disable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel(dispatcher: CoroutineContext) : ViewModel() {

    var job = SupervisorJob()
    val scope by lazy { CoroutineScope(dispatcher + job) }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
