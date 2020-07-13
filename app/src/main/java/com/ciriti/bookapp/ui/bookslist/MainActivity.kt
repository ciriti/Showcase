package com.ciriti.bookapp.ui.bookslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ciriti.bookapp.R
import com.ciriti.bookapp.core.init

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedInstanceState ?: init(R.id.fragmentContainer, BooksListFragment())
    }
}
