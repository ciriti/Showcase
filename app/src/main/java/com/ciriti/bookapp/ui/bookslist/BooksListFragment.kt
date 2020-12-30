package com.ciriti.bookapp.ui.bookslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ciriti.bookapp.R
import com.ciriti.bookapp.di.ModuleKey
import com.ciriti.bookapp.ui.bookslist.components.BaseState
import com.ciriti.bookapp.ui.bookslist.components.BooksAdapter
import kotlinx.android.synthetic.main.fragment_books_list.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class BooksListFragment : Fragment() {

    private val viewModel: BooksListViewModel by
        viewModel(qualifier = named(ModuleKey.KEY_BOOKS_VIEW_MODEL))
    private val adapter by lazy { BooksAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_books_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.liveData.observe(viewLifecycleOwner, Observer { resultHandler(it) })
        viewModel.loadBooks(name = "combined-print-and-e-book-fiction.json", date = "2019-09-01")
        books_list.layoutManager = LinearLayoutManager(context)
        books_list.adapter = adapter
        bottom_nav.setOnNavigationItemSelectedListener { onMenuClicked(it) }
        swiperefresh.setOnRefreshListener {
            viewModel.loadBooks(
                name = "combined-print-and-e-book-fiction.json",
                date = "2019-09-01"
            )
        }
    }

    private fun resultHandler(state: BaseState) {
        when (state) {
            is BaseState.StateError -> {
                Toast.makeText(context, state.errorMessage, Toast.LENGTH_LONG).show()
            }
            is BaseState.StateLoading -> {
                swiperefresh.isRefreshing = state.loading
            }
            is BaseState.StateSuccess -> {
                bottom_nav.selectedItemId = R.id.action_sort_asc_rank
                adapter.addItems(state.data)
            }
        }
    }

    private fun onMenuClicked(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_sort_asc_rank -> adapter.sort(BooksAdapter.ASC_BY_RANK)
            R.id.action_sort_desc_favorites -> adapter.sort(BooksAdapter.DESC_BY_FAVORITES)
        }
        return true
    }
}
