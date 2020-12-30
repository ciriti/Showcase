package com.ciriti.datalayer.util

import android.util.Log

interface Logger {
    fun info(tag: String, message: String)
    fun debug(tag: String, message: String)
    fun error(tag: String, message: String)
    fun verbose(tag: String, message: String)

    companion object
}

private class LoggerImpl : Logger {
    override fun info(tag: String, message: String) {
        Log.i(tag, message)
    }

    override fun debug(tag: String, message: String) {
        Log.d(tag, message)
    }

    override fun error(tag: String, message: String) {
        Log.e(tag, message)
    }

    override fun verbose(tag: String, message: String) {
        Log.v(tag, message)
    }
}

fun Logger.Companion.create(): Logger = LoggerImpl()
