package com.ciriti.bookapp

import android.app.Application
import com.ciriti.bookapp.di.bookListModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Use Koin Android Logger
            androidLogger()
            // declare Android context
            androidContext(this@App)
            // declare modules to use
            modules(bookListModule)
        }
    }
}
